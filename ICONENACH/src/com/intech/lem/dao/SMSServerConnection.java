package com.intech.lem.dao;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.intech.lem.dao.provider.SMSVariableProvider;

public class SMSServerConnection {

	private static ResourceBundle rsBundle1=ResourceBundle.getBundle("EMApplication");	
	private static String requestURL1=rsBundle1.getString("RequestURL");
	private static String  testRecipient = rsBundle1.getString("TestRecipient");
	private static String  testMessage = rsBundle1.getString("TestMessage");
	private static String  userName1= rsBundle1.getString("UserName");
	private static String  password1 = rsBundle1.getString("Password");
	private static String  originator1 = rsBundle1.getString("TestOriginator");
	private static String otpDeploymentArea= rsBundle1.getString("OTPAREA");

	
	public static Map<String,String> sendMessage(String data,String rec) {
		
		//http://127.0.0.1:9501/
		

		Map<String,String> respMap = new HashMap<String,String>();
		String response="";
try {	
		
		SMSVariableProvider obj = new SMSVariableProvider();
		obj.setRequestURL(requestURL1);
		obj.setUserName(userName1);
		obj.setTestOriginator(originator1);
		obj.setPassword(password1);
		obj.setTestMessage(data);
		obj.setTestRecipient(rec);
		String requestUrl="";
		
		String requestUrlLocal  = obj.getRequestURL()+
		 "&username=" + URLEncoder.encode(obj.getUserName(), "UTF-8") +
		 "&password=" + URLEncoder.encode(obj.getPassword(), "UTF-8") +
		 "&recipient=" + URLEncoder.encode(obj.getTestRecipient(), "UTF-8") +
		 "&messagetype=SMS:TEXT" +
		 "&messagedata=" + URLEncoder.encode(obj.getTestMessage(), "UTF-8") +
		 "&originator=" + URLEncoder.encode(obj.getTestOriginator(), "UTF-8") +
		 "&serviceprovider=GSMModem1" +
		 "&responseformat=html";
		
		
		//deploy query url
		String requestUrlUAT= obj.getRequestURL()+//http://10.144.23.154/ConnectOneUrl/sendsms/sendsms?
				"&uname=" + URLEncoder.encode(obj.getUserName(), "UTF-8")+  //karixotp
				"&pwd="+URLEncoder.encode(obj.getPassword(), "UTF-8") +//Welcome@1
				"&send=IDBIBK"+
				"&TYPE=0"+
				"&INTL=0"+
				"&dest=" + URLEncoder.encode(obj.getTestRecipient(), "UTF-8") +
				"&msg="+ URLEncoder.encode(obj.getTestMessage(), "UTF-8");

		
		if(otpDeploymentArea.equals("U"))
		{
			
			requestUrl=requestUrlUAT;
			
		}else if(otpDeploymentArea.equals("P"))
		{
			requestUrl=requestUrlUAT;
		}
		else{
			requestUrl=requestUrlLocal;
		}
	
		
		System.out.println(requestUrl);
		URL url = new URL(requestUrl);
		HttpURLConnection uc = (HttpURLConnection)url.openConnection();	
		response = uc.getResponseMessage();
		uc.disconnect();	
		System.out.println("done.");
		respMap.put("STATUS", "OK");
		respMap.put("RESPONSE", response);
		respMap.put("MOBILE_NUMBER", rec);

		}catch(Exception ex) 
        {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			respMap.put("STATUS", "ERROR");
			respMap.put("ERRORMESSAGE", ex.getMessage());
			response = ex.getMessage();			
		}
		
		System.out.println("OTP Response: "+respMap);
		return respMap;
	}
		
	
	public static void main(String[] args) {
		
		
		}
	
	
}
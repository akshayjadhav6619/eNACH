package com.intech.lem.service.sms;

import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

import com.intech.lem.dao.SMSServerConnection;

public class SMSService {

	private  ResourceBundle rsBundle1=ResourceBundle.getBundle("EMApplication");	

	//send otp
	public Map<String,String> sendOTP(String otp, String mobileNumber,String applicationID)
	{
				String 	template=rsBundle1.getString("otpFormate");
				String loanType = applicationID.substring(0,2);//#loantype 	//#appid   //#otp
		 		String data = template.replaceAll("#otp",otp);
		 		data = data.replaceAll("#loantype",loanType);						
				data = data.replaceAll("#appid",applicationID);
				return SMSServerConnection.sendMessage(data, mobileNumber);
		
	}
	//send message
	
	//send alert
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

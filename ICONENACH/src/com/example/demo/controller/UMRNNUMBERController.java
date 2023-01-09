package com.example.demo.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import com.intech.lem.dao.provider.DBVariablesProvider;




public class UMRNNUMBERController {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try {
			
		String response="0399|failure|No Variant is eligible for Selection|HL00183000117159|10010|1492995409|5.00|"+
				"{itc:~mandateData{amount_type:M~frequency:MNTH~account_number:156901001305~expiry_date:05-12-2099~ifsc_code:~amount:100~identifier:"+
					"~schedule_date:10-08-2021~debitDay:~debitFlag:N~aadharNo:~accountHolderName:AJAY KUMAR~accountType:Saving~dateOfBirth:~mandatePurpose:~utilityNo"+
					":~helpdeskNo:~helpdeskEmail:~pan:~phoneNumber:~emailID:KUMARAJAY@WWII.NET}}{email:KUMARAJAY@WWII.NET}{mob:919640547478}|09-07-2021 16:34:36|NA|||||";
		
		String driverName = "oracle.jdbc.driver.OracleDriver";
	    String 	strConn = "jdbc:oracle:thin:@";
	    String 	strIP = "10.144.136.249:";
		String strPort="1523:";
		String  strDBName="FINDEVTEST";
		String USRNAME ="SWFOUTDV";
		String PWD="SWFOUTDV";
		String strConnName = strConn + strIP + strPort +strDBName ;
		
		
		DBVariablesProvider dbVarProvider = new DBVariablesProvider(driverName,strConnName,USRNAME,PWD);
	    Connection con=null;
	    
	    Class.forName(dbVarProvider.getDRIVER());
		con =DriverManager.getConnection(dbVarProvider.getCONNECTION_URL(), dbVarProvider.getUSERNAME(), dbVarProvider.getPASSWORD());
	    String MandateDetails=response.split("mandateData")[1];
	    String MandateDetailsARR[]=MandateDetails.split("\\{")[1].split("\\~");
	    String AckDate=MandateDetails.split("\\|")[1];
	    SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        java.util.Date date = sdf.parse(AckDate); 
        java.sql.Date sqlDate = new Date(date.getTime());  
	    HashMap<String , String> hash_map = new HashMap<String, String>();
	    
	    for(int i=0;i<MandateDetailsARR.length;i++){
	    	
	        String MandateDetailsKeyValueArr[]=MandateDetailsARR[i].split("\\:");
	    	String MandateDetailsKey=MandateDetailsKeyValueArr[0];
	    	String MandateDetailsValue=MandateDetailsKeyValueArr.length>1?MandateDetailsKeyValueArr[1].replaceAll("}", ""):"";
	    	hash_map.put(MandateDetailsKey, MandateDetailsValue);
	    	
	    }
	     
	     
	PreparedStatement pst=con.prepareStatement("Insert into MMS_OUT_INFO_MAS(DBTR_OTHER_DETAILS,"
			+ " UMRN, MMS_TYPE ,ACK_DATE_RECEIVER ,DBTR_AGNT_IFSC"
			+ " ,DBTR_ACCT_NO ,DBTR_NAME, DBTR_ACCT_PRTRY,FILE_TYPE,REF_NUM,LCHG_DATE) values (?,?,?,?,?,?,?,?,?,?,sysdate)");
	
	pst.setString(1, "");
	pst.setString(2, "");
	pst.setString(3, "CREATE");
	pst.setDate(4, sqlDate);
	pst.setString(5,hash_map.get("ifsc_code") );
	pst.setString(6, hash_map.get("account_number"));
	pst.setString(7, hash_map.get("accountHolderName"));
	pst.setString(8, hash_map.get("accountType"));
	pst.setString(9,"ENACH");
	pst.setString(10," ");
	
	int i = pst.executeUpdate();
	if(i>0)
	{
		System.out.println("recorded inserted succesfully");
	}
} catch (Exception  e ) 
	{
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		//return con;
		
		}

}

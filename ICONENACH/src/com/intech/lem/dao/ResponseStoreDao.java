package com.intech.lem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class ResponseStoreDao {
	

	public void StoreResponseData( HashMap<String , String> hash_map, String ResponseString,Date  sqlDate )
	{
		try{
			
	      String IC_TRANS_no= hash_map.get("clnt_txn_ref");
	      System.out.println("UMRN Number:"+hash_map.get("UMRNNumber"));
			Connection con = ICONDBConnection.getConnection();//DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		    //PreparedStatement pst =con.prepareStatement("insert into INT_EMANADATE_REQ_RESPONSE(IC_TRANS_NO,IC_TRANS_SNO,IC_RESPONSE) VALUES(INT_SEQ_INW_RESP.NEXTVAL,2,?) ");
			PreparedStatement pst =con.prepareStatement("update INT_EMANADATE_REQ_RESPONSE set IC_RESPONSE=? where MER_REF_NUM=?");
			pst.setString(1, ResponseString);
			pst.setString(2, IC_TRANS_no);
		    int i=pst.executeUpdate();
		   
		    if(i>0)
		    {
		    	System.out.println("Response Successfully Inserted...");
		    	con.commit();
		    	
		    }
	
		   if( hash_map.get("txn_status").equalsIgnoreCase("0300"))
		   {
			
			   int Transcation_Number=0;
			   String emandateQuery="SELECT MAX(TRANS_NO) AS Trans_NO FROM  INT_EMANDATE_DATA_MAS  WHERE  APP_NO='"+hash_map.get("Application_ref")+"'   GROUP BY APP_NO";
			   Statement stmt =con.createStatement();
			   ResultSet rs= stmt.executeQuery(emandateQuery);
			 
			   if(rs.next())
			  {
				  Transcation_Number=rs.getInt("Trans_NO");
			  }
			   
		      PreparedStatement psmt =con.prepareStatement("insert into  INT_EMANADATE_REQ_RESPONSE_MAS(IC_TRANS_NO , IC_TRANS_SNO , IC_TXN_STATUS , IC_TXN_MSG , IC_TXN_ERR_MSG , IC_APP_REF , IC_TPSL_BANK_CODE , IC_TPSL_TRANS_ID , IC_TRANS_AMT , IC_TRANS_TIME , IC_UMRN_NUMBER , IC_CARD_ID , IC_ALIES_NAME , IC_BANK_TRANSACTION_ID , IC_MANDATE_REG_NUMBER , IC_TOKEN , IC_AMOUNT_TYPE , IC_FREQUENCY , IC_ACCOUNT_NUMBER , IC_EXPIRY_DATE , IC_IFSC_CODE , IC_AMOUNT , IC_IDENTIFIER , IC_SCHEDULE_DATE , IC_DEBIT_DAY , IC_DEBIT_FLAG , IC_ADHAR_NUMBER , IC_ACCOUNT_HOLDER_NAME , IC_ACCOUNT_TYPE , IC_DATE_OF_BIRTH , IC_PAN_NUMBER , IC_EMAIL_ID , IC_PHONE_NUMBER , IC_MANDATE_PURPOSE , IC_UTILITY_NO) VALUES (INT_RESP_MAS_SEQ.NEXTVAL , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ,? )");
		    	
		    psmt.setInt(1, Transcation_Number);
		    psmt.setString(2, hash_map.get("txn_status"));
		    psmt.setString(3, hash_map.get("txn_msg"));
		    psmt.setString(4, hash_map.get("txn_err_msg"));
		    psmt.setString(5, hash_map.get("clnt_txn_ref"));
		    psmt.setString(6, hash_map.get("tpsl_bank_cd"));
		    psmt.setString(7, hash_map.get("tpsl_txn_id"));
		    psmt.setString(8, hash_map.get("txn_amt"));
		    psmt.setString(9, hash_map.get("transaction_time"));
		    psmt.setString(10, hash_map.get("UMRNNumber"));
		    psmt.setString(11, hash_map.get("card_id"));
		    psmt.setString(12, hash_map.get("alias_name"));
		    psmt.setString(13, hash_map.get("BankTransactionID"));
		    psmt.setString(14, hash_map.get("mandate_reg_no"));
		    psmt.setString(15, hash_map.get("token"));
		    psmt.setString(16, hash_map.get("amount_type"));
		    psmt.setString(17,  hash_map.get("frequency"));
		    psmt.setString(18,  hash_map.get("account_number"));
		    psmt.setString(19,  hash_map.get("expiry_date"));
		    psmt.setString(20,  hash_map.get("IFSCCode"));
		    psmt.setString(21,  hash_map.get("amount"));
		    psmt.setString(22,  hash_map.get("identifier"));
		    psmt.setString(23,  hash_map.get("schedule_date"));
		    psmt.setString(24,  hash_map.get("debitDay"));
		    psmt.setString(25,  hash_map.get("debitFlag"));
		    psmt.setString(26,  hash_map.get("aadharNo"));
		    psmt.setString(27,  hash_map.get("accountHolderName"));
		    psmt.setString(28,  hash_map.get("accountType"));
		    psmt.setString(29,  hash_map.get("dateOfBirth"));
		    psmt.setString(30,  hash_map.get("pan"));
		    psmt.setString(31,  hash_map.get("emailID"));
		    psmt.setString(32,  hash_map.get("phoneNumber"));
		    psmt.setString(33,  hash_map.get("mandatePurpose"));
		    psmt.setString(34,  hash_map.get("utilityNo"));
		    
		    int J=psmt.executeUpdate();
		    if(J>0)
		    {
		    	System.out.println("Response Successfully Inserted...");
		    	con.commit();
		    }
		    
		    
		    
		       String ALPS_NUM="";
			   String GETALPS="SELECT TRIM(APP_NO) AS alps_no FROM  INT_EMANDATE_DATA_MAS  WHERE  MER_REF_NUM='"+hash_map.get("clnt_txn_ref")+"'";
			   Statement stmt1 =con.createStatement();
			   ResultSet rs1= stmt.executeQuery(GETALPS);
			 
			   if(rs1.next())
			  {
				   ALPS_NUM=rs1.getString("alps_no");
			  }
			
		    
		    
				System.out.println("ALPS NUM>>"+ALPS_NUM);

				System.out.println("sqlDate>>"+sqlDate);
				System.out.println("ALPS NUM>>"+ALPS_NUM);
				System.out.println("ALPS NUM>>"+ALPS_NUM);

		    
		 
			PreparedStatement pstmt=con.prepareStatement("Insert into MMS_OUT_INFO_MAS(ENACH_REF_NUM,UMRN , MMS_TYPE ,ACK_DATE_RECEIVER,DBTR_AGNT_IFSC , DBTR_ACCT_NO , DBTR_NAME , DBTR_ACCT_PRTRY , FILE_TYPE , REF_NUM , LCHG_DATE,DBTR_OTHER_DETAILS) VALUES  (?,?,?,?,?,?,?,?,?,to_char(to_char(sysdate,'ddMMyyyy') || LPAD (MMS_OUT_ACCPT_ZIP_SEQ_NO.NEXTVAL,6,'0')),sysdate,?)");
			System.out.println("Inside MAS Table!!!");
			pstmt.setString(1, hash_map.get("clnt_txn_ref"));
			pstmt.setString(2, hash_map.get("UMRNNumber"));
			pstmt.setString(3, "CREATE");
			pstmt.setDate(4, sqlDate);
			pstmt.setString(5,hash_map.get("IFSCCode") );
			pstmt.setString(6, hash_map.get("account_number"));
			pstmt.setString(7, hash_map.get("accountHolderName"));
			pstmt.setString(8, hash_map.get("accountType"));
			pstmt.setString(9,"ENACH");
			//pstmt.setInt(10,Transcation_Number);
			pstmt.setString(10,ALPS_NUM);
             
			System.out.println("Inside MAS Table!!!");
			
			int K  = pstmt.executeUpdate();
			System.out.println("Value of K>>"+K);
			if(K>0)
			{
				System.out.println("Record Inserted in MMSOut Mas..."  );
				con.commit();
			}
		    
		   }
			
		}catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		


}
}
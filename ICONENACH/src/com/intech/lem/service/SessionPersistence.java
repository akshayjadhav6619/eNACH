package com.intech.lem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.intech.lem.dao.ICONDBConnection;


public class SessionPersistence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionPersistence obj = new SessionPersistence();
		//obj.storeNewSession("1223", "9640547478", "asdhflajkshdf");
		System.out.println(obj.updateSessionById("9", "ABC", "k"));
	
	}

	//Insert into IDBI_UAT1.INT_ENACH_SESSION_MAS (SNO,TRAN_REF,"session_id",OTP,TRAN_DATE,"mobile",DEL_FLAG,IP,"otp_req","otp_resp",STATUS) values ('1','12',null,null,null,null,null,null,null,null,null);
	public String storeNewSession(String n, String mobileNumber, String sID) {
		// TODO Auto-generated method stub
		String seqID="";
		try{  

			Connection con = ICONDBConnection.getConnection();
			//Statement ps=con.Statement("Insert into IDBI_UAT1.INT_ENACH_SESSION_MAS (SNO,TRAN_REF,session_id,mobile,DEL_FLAG,STATUS) values (?,?,?,?,?,?)");
				String query="SELECT INT_SEQ_TEMPLATE_MAS.NEXTVAL SEQ FROM DUAL";//"Insert into IDBI_UAT1.INT_ENACH_SESSION_MAS (SNO,TRAN_REF,SESSION_ID,MOBILE,DEL_FLAG,STATUS) values (INT_SEQ_TEMPLATE_MAS.NEXTVAL,'"+n+"','"+sID+"','"+mobileNumber+"','N','O')";
				System.out.println("query:"+query);
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery(query);
				if(rs.next()) { 
					seqID = rs.getString("SEQ");						
		
					PreparedStatement ps=con.prepareStatement("Insert into INT_ENACH_SESSION_MAS (SNO,TRAN_REF,session_id,mobile,DEL_FLAG,STATUS) values (?,?,?,?,?,?)");
					ps.setString(1, seqID);
					ps.setString(2, n);
					ps.setString(3, sID);
					ps.setString(4, mobileNumber);
					ps.setString(5, "N");
					ps.setString(6, "O");
					
					int i = ps.executeUpdate();
					if(i>0){
						con.commit();
						;
						System.out.println("inserted successfully. ID:"+seqID);						
					}else{
						System.out.println("failled insertion.");
						System.out.println("inserted failled.");
						con.rollback();
					}
					//out.print("You are successfully registered...");  
				}else{
					System.out.println("insert faillure ..!\n");
					con.rollback();
				}
		          
				}catch (Exception e2) {System.out.println(e2); e2.printStackTrace(System.out);}  

		return seqID;
	}
	//UPDATE "IDBI_UAT1"."INT_ENACH_SESSION_MAS" SET "session_id" = '2' WHERE ROWID = 'AAAFSGAAEAAAAitAAA' AND ORA_ROWSCN = '1630332'
	public int updateSessionById(String SNO,String OTP,String STATUS){
				
				int row =0;
				String SQL_UPDATE = "UPDATE INT_ENACH_SESSION_MAS SET OTP=?,STATUS=? WHERE SNO=?";
				try {
				Connection con = ICONDBConnection.getConnection();				
				PreparedStatement preparedStatement = con.prepareStatement(SQL_UPDATE) ;
				System.out.println(OTP);
				preparedStatement.setString(1, OTP);
				
	            preparedStatement.setString(2, STATUS);

	            preparedStatement.setString(3, SNO);

	            row = preparedStatement.executeUpdate();
	            
	            if(row>0){

	            	System.out.println("Updated Success fully:\nStatus and SNO:"+STATUS+"-"+SNO);
	            	
	            	con.commit();
	            	
	            }else{
	            	
	            	con.rollback();
	            
	            }
				
				} catch (SQLException e) {
					
					System.out.println(e.getMessage());
					e.printStackTrace(System.out);
				
				}
				
				return row;
		
	}		
	
	public String getOTPById(String pID){
		String otp="";
		String SQL_UPDATE = "SELECT *  FROM INT_ENACH_SESSION_MAS WHERE SNO=?";

		try {
		Connection con = ICONDBConnection.getConnection();				
		PreparedStatement preparedStatement = con.prepareStatement(SQL_UPDATE) ;
		
		preparedStatement.setString(1, pID);
		
        
        ResultSet rs = preparedStatement.executeQuery();
        
        if(rs.next()){

        	otp = rs.getString("OTP");
        	
        }else{
        	
        System.out.println("OTP not returned by system while validation...");
        
        }
		
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
		
		}
		
		return otp;
		
		
	}
	
}
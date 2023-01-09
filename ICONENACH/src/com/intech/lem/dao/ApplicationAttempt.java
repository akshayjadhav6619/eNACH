package com.intech.lem.dao;
import java.sql.*;

public class ApplicationAttempt {

	public static boolean validateWRAttempt(String reference) {
		boolean status = false;
		try {
			
			//String sql="SELECT  a.APP_NO FROM APPLICATIONS a,PERAPPLICANT b, per_demographics c,loandetails d where a.app_no = c.demo_appno and c.demo_appid = b.perapp_id and a.app_no = d.loan_appno  and c.DEMO_TYPE ='a' and a.app_no =?";
			
			String sql="select count(1) as WRCOUNT from eNACH_APPLICATION_MASTER where LCHG_DATE=to_char(sysdate,'dd-MM-yyyy') and TRIM(APPLICATION_NUMBER)=? and (WRONG_ATMP_COUNT=2 OR MAXIMUM_ATMP > 10 OR LOGIN_STATUS='Y')";
			//idbi_uat2.get_dec_val(
			
			System.out.println("Query:"+sql);
			Connection con = ICONDBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reference);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			if( rs.getInt(1)>0){
			status = true;
			}else{
				String sql2="select count(1) as WRCOUNT from eNACH_APPLICATION_MASTER where LCHG_DATE=to_char(sysdate,'dd-MM-yyyy') and TRIM(APPLICATION_NUMBER)=?";
				//idbi_uat2.get_dec_val(
				
				System.out.println("Query:"+sql2);
				Connection con1 = ICONDBConnection.getConnection();
				PreparedStatement pst = con1.prepareStatement(sql2);
				pst.setString(1, reference);
				ResultSet rs1 = pst.executeQuery();
				rs1.next();
					if( rs1.getInt(1)>0){
						
						String updatemaxcount="UPDATE eNACH_APPLICATION_MASTER SET LOGIN_STATUS=?, MAXIMUM_ATMP=MAXIMUM_ATMP+1 where APPLICATION_NUMBER=? and  LCHG_DATE=to_char(sysdate,'dd-MM-yyyy')";
					    
						
						System.out.println("updatemaxcount:"+updatemaxcount);
						Connection con5 = ICONDBConnection.getConnection();
						
						PreparedStatement pstupdatemaxcount =con5.prepareStatement(updatemaxcount);
						pstupdatemaxcount.setString(1, "Y");
						pstupdatemaxcount.setString(2, reference);

					    int ij1=pstupdatemaxcount.executeUpdate();
					    if(ij1>0)
					    {
					    	System.out.println("Max Count Updated in Master table!!!!");
					    }
					   
						
						
				        }
					else
					{
						String sql3="insert into eNACH_APPLICATION_MASTER(APPLICATION_NUMBER,WRONG_ATMP_COUNT,MAXIMUM_ATMP,LCHG_DATE,LOGIN_STATUS) values(?,0,0,to_char(sysdate,'dd-MM-yyyy'),?)";
						//idbi_uat2.get_dec_val(
						
						System.out.println("Query:"+sql);
						Connection con2 = ICONDBConnection.getConnection();
						
						PreparedStatement pst2 =con2.prepareStatement(sql3);
						pst2.setString(1, reference);
						pst2.setString(2, "Y");

					    int ij=pst2.executeUpdate();
					    if(ij>0)
					    {
					    	System.out.println("Data Inserted in Application Master Table!!!!");
					    }
					   
					}
				
				System.out.println("no records  in APPLICATION_MASTER");
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println(e);
			
		}
		return status;
	}
	
	
	
	public static boolean LockUser(String reference) {
		boolean status = false;
		try {
			
			//String sql="SELECT  a.APP_NO FROM APPLICATIONS a,PERAPPLICANT b, per_demographics c,loandetails d where a.app_no = c.demo_appno and c.demo_appid = b.perapp_id and a.app_no = d.loan_appno  and c.DEMO_TYPE ='a' and a.app_no =?";
			
			String sql="UPDATE eNACH_APPLICATION_MASTER SET WRONG_ATMP_COUNT=WRONG_ATMP_COUNT+1 where APPLICATION_NUMBER=? and  LCHG_DATE=to_char(sysdate,'dd-MM-yyyy')";
			//idbi_uat2.get_dec_val(
			
			System.out.println("Query:"+sql);
			Connection con = ICONDBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reference);
			
			 int ij=ps.executeUpdate();
			    if(ij>0)
			    {
			    	System.out.println("Wrong Count Updated Application Master Table!!!!");
			    
			   
				status = true;
			}else{
				System.out.println("no records found");
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println(e);
			
		}
		return status;
	}
	
	
	
	public static boolean LogoutStatus(String reference) {
		boolean status = false;
		try {
			
			//String sql="SELECT  a.APP_NO FROM APPLICATIONS a,PERAPPLICANT b, per_demographics c,loandetails d where a.app_no = c.demo_appno and c.demo_appid = b.perapp_id and a.app_no = d.loan_appno  and c.DEMO_TYPE ='a' and a.app_no =?";
			
			String sql="UPDATE eNACH_APPLICATION_MASTER SET LOGIN_STATUS='N' where APPLICATION_NUMBER=? and  LCHG_DATE=to_char(sysdate,'dd-MM-yyyy')";
			//idbi_uat2.get_dec_val(
			
			System.out.println("Query:"+sql);
			Connection con = ICONDBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reference);
			
			 int ij=ps.executeUpdate();
			    if(ij>0)
			    {
			    	System.out.println("Logout Status Updated Application Master Table!!!!");
			    
			   
				status = true;
			}else{
				System.out.println("no records found");
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println(e);
			
		}
		return status;
	}
	
	
	//For Checking ACTIVE STATUS
	public static boolean validateActiveStatus(String reference) {
		boolean status = false;
		try {
			
			//String sql="SELECT  a.APP_NO FROM APPLICATIONS a,PERAPPLICANT b, per_demographics c,loandetails d where a.app_no = c.demo_appno and c.demo_appid = b.perapp_id and a.app_no = d.loan_appno  and c.DEMO_TYPE ='a' and a.app_no =?";
			
			String sql="select count(1) as WRCOUNT from eNACH_APPLICATION_MASTER where LCHG_DATE=to_char(sysdate,'dd-MM-yyyy') and TRIM(APPLICATION_NUMBER)=? and LOGIN_STATUS=?";
			//idbi_uat2.get_dec_val(
			
			System.out.println("Query:"+sql);
			Connection con = ICONDBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reference);
			ps.setString(2, "Y");
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			if( rs.getInt(1)>0){
			status = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println(e);
			
		}
		return status;
	}
	
	
	
	

}

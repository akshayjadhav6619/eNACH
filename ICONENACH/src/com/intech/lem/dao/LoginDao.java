package com.intech.lem.dao;

import java.sql.*;

public class LoginDao {
	public static boolean validate(String reference) {
		boolean status = false;
		try {
			
			//String sql="SELECT  a.APP_NO FROM APPLICATIONS a,PERAPPLICANT b, per_demographics c,loandetails d where a.app_no = c.demo_appno and c.demo_appid = b.perapp_id and a.app_no = d.loan_appno  and c.DEMO_TYPE ='a' and a.app_no =?";
			
			String sql="SELECT idbi_uat2.get_dec_val(b.PERAPP_MOBILE) FROM APPLICATIONS a,PERAPPLICANT b, per_demographics c,loandetails d where a.app_no = c.demo_appno and c.demo_appid = b.perapp_id and a.app_no = d.loan_appno  and c.DEMO_TYPE ='a' and a.app_no =?";
			//idbi_uat2.get_dec_val(
			
			System.out.println("Query:"+sql);
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reference);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
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
}
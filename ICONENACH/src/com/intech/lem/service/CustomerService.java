package com.intech.lem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.intech.lem.dao.DBConnection;

public class CustomerService {

	public String getMobileNumber(String ref){
		String mobileNumber=null;
		
			try {
				
				Connection con = DBConnection.getConnection();
				//PreparedStatement ps = con.prepareStatement("SELECT * FROM PERAPPLICANT WHERE PERAPP_ID IN (SELECT APP_USRID FROM APPLICATIONS WHERE APP_NO=?) ");
				PreparedStatement ps = con.prepareStatement("SELECT idbi_uat2.get_dec_val(b.PERAPP_MOBILE) PERAPP_MOBILE FROM APPLICATIONS a,PERAPPLICANT b, per_demographics c,loandetails d where a.app_no = c.demo_appno and c.demo_appid = b.perapp_id and a.app_no = d.loan_appno  and c.DEMO_TYPE ='a' and a.app_no =?");
					//idbi_uat2.get_dec_val()
				ps.setString(1, ref);
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					mobileNumber= rs.getString("PERAPP_MOBILE");
				}
				
			} catch (Exception e) {
				e.printStackTrace(System.out);
				System.out.println(e);
				
			}
			return mobileNumber;
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

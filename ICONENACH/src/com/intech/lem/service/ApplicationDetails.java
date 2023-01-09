package com.intech.lem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.intech.lem.dao.DBConnection;

public class ApplicationDetails {

	public Map<String,String> getAppDetailsById(String id){
		Map<String,String> map = new HashMap<String,String>();
		try {
			
			Connection con = DBConnection.getConnection();
			//PreparedStatement ps = con.prepareStatement("SELECT APPLICATIONS.APP_NO,PERAPPLICANT.PERAPP_FNAME,PERAPPLICANT.PERAPP_PANNO,PERAPPLICANT.PERAPP_PHONE,PERAPPLICANT.PERAPP_EMAIL,PERAPPLICANT.PERAPP_MOBILE,PERAPPLICANT.PERAPP_ADDRESS1,PERAPPLICANT.PERAPP_BANKACCNO,PERAPPLICANT.PERAPP_BANKACCTYPE,LOANDETAILS.LOAN_AMTREQD ,LOANDETAILS.LOAN_EMI,LOANDETAILS.LOAN_FILEDON,APPLICATIONS.APP_USRID FROM APPLICATIONS JOIN PERAPPLICANT ON APPLICATIONS.APP_USRID = PERAPPLICANT.PERAPP_ID JOIN LOANDETAILS ON LOANDETAILS.LOAN_APPNO =  APPLICATIONS.APP_NO where APPLICATIONS.APP_NO=?");
			PreparedStatement ps = con.prepareStatement("SELECT substr(a.app_no,1,2) loan_type, a.APP_NO,b.PERAPP_FNAME,b.PERAPP_ADDRESS1,b.PERAPP_PANNO,b.PERAPP_ID APP_USRID,b.PERAPP_PHONE,b.PERAPP_EMAIL,idbi_uat2.get_dec_val(b.PERAPP_MOBILE) PERAPP_MOBILE,b.PERAPP_BANKACCNO,b.PERAPP_BANKACCTYPE,(d.loan_emi)loan_emi,ceil((d.LOAN_EMI*2)/1000)*1000 loan_emi_nearest_1000,d.LOAN_RECMDAMT LOAN_AMT,(case when substr(a.app_no,1,2) in ('HL','ML') then '10-'||to_char(add_months(trunc(sysdate),1),'MM-YYYY') else '05-'||to_char(add_months(trunc(sysdate),1),'MM-YYYY') end)start_date,(case when substr(a.app_no,1,2) in ('HL','ML') then '10-12-2099' else '05-12-2049' end)end_date FROM APPLICATIONS a,PERAPPLICANT b, per_demographics c,loandetails d where a.app_no = c.demo_appno and c.demo_appid = b.perapp_id and a.app_no = d.loan_appno  and c.DEMO_TYPE ='a' and a.app_no =?");
			ps.setString(1, id);
			//--idbi_uat2.get_dec_val(
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				map.put("APP_NO", rs.getString("APP_NO"));
				map.put("LOAN_TYPE", rs.getString("LOAN_TYPE"));
				map.put("PERAPP_FNAME", rs.getString("PERAPP_FNAME"));
				map.put("PERAPP_PANNO", rs.getString("PERAPP_PANNO"));
				map.put("PERAPP_PHONE", rs.getString("PERAPP_PHONE"));
				map.put("PERAPP_EMAIL", rs.getString("PERAPP_EMAIL"));
				map.put("PERAPP_MOBILE", rs.getString("PERAPP_MOBILE"));
				map.put("PERAPP_ADDRESS1", rs.getString("PERAPP_ADDRESS1"));
				map.put("PERAPP_BANKACCNO", rs.getString("PERAPP_BANKACCNO"));
				map.put("PERAPP_BANKACCTYPE", rs.getString("PERAPP_BANKACCTYPE"));
				map.put("LOAN_AMT", rs.getString("LOAN_AMT"));
				map.put("LOAN_EMI", rs.getString("LOAN_EMI"));
				map.put("LOAN_EMI_NEAREST_1000", rs.getString("LOAN_EMI_NEAREST_1000"));
				map.put("APP_USRID", rs.getString("APP_USRID"));
				
				if(rs.getString("START_DATE")!=null){
					//Date sDate= rs.getDate("START_DATE");
					//System.out.println(sDate);
					/*System.out.println(sDate.getDate());
					System.out.println(sDate.getMonth());
					System.out.println(sDate.getYear());*/
					//Date date1=new SimpleDateFormat("yyyy-MM-DD HH:MM:SS.").parse(sDate);
					//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					//String strDate = dateFormat.format(sDate);
					String strDate = rs.getString("START_DATE");
					//System.out.println(strDate);
					map.put("START_DATE",strDate);
				}else{
					map.put("START_DATE",rs.getString("START_DATE"));
				}
				
				if(rs.getString("END_DATE")!=null){
					//Date sDate= rs.getDate("END_DATE");
					//System.out.println(sDate);
					/*System.out.println(sDate.getDate());
					System.out.println(sDate.getMonth());
					System.out.println(sDate.getYear());*/
					
					
					//Date date1=new SimpleDateFormat("yyyy-MM-DD HH:MM:SS.").parse(sDate);
					//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					String strDate = rs.getString("END_DATE");//dateFormat.format(sDate);
					//System.out.println(strDate);
					map.put("END_DATE",strDate);
				}else{
					map.put("END_DATE","10-12-2099");
				}
				//(a > b) ? a : b;
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.println(e);
			
		}
		
		return map;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationDetails appDetails = new ApplicationDetails();
		 Map<String,String> mapData = appDetails.getAppDetailsById("AL00001000000005");
		 System.out.println(mapData);
		 System.out.println(mapData.get("PERAPP_BANKACCNO")==null);
	}

}

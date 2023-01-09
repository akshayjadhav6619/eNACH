package com.intech.lem.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.intech.lem.dao.ICONDBConnection;

public class ListService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<String> getAllBanks()
	{
		ArrayList<String> list = new ArrayList<String>();
		try{
		   //Class.forName("com.mysql.jdbc.Driver");
		   Connection con = ICONDBConnection.getConnection();//DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("select DISTINCT(IC_BANK_NAME),IC_BANK_CODE from INT_SEND_RECV_INFO_DIR WHERE IC_DEL_FLG='N' AND IC_ENTITY_CRE_FLG='Y' order by IC_BANK_NAME"); //AND IC_BANK_NAME LIKE '"+name+"%'");
		    while(rs.next())
		    {
		    	list.add(rs.getString("IC_BANK_CODE")+"_"+rs.getString("IC_BANK_NAME"));
		    }
			//String searchList = new Gson().toJson(list);
		}
		 catch (Exception e) {
		    e.printStackTrace(System.out);
			 e.printStackTrace();
		 }
		return list;
	}
	
	public ArrayList<String> getBankCodeBySBankCode(String type,String str)
	{
		ArrayList<String> list = new ArrayList<String>();
		try{
		   //Class.forName("com.mysql.jdbc.Driver");
		   Connection con = ICONDBConnection.getConnection();//DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		   Statement st=con.createStatement();
		   
		   ResultSet rs=null; //AND IC_BANK_NAME LIKE '"+name+"%'");
		if (type.equals("netBanking")) {
			rs = st.executeQuery(
					"select DISTINCT(IC_BANK_NAME),IC_BANK_CODE from INT_SEND_RECV_INFO_DIR WHERE IC_DEL_FLG='N' AND IC_ENTITY_CRE_FLG='Y' order by IC_BANK_NAME");
		}else{
			rs = st.executeQuery(
					"select DISTINCT(IC_BANK_NAME),IC_BANK_CODE from INT_SEND_RECV_INFO_DIR WHERE IC_DEL_FLG='N' AND IC_ENTITY_CRE_FLG='Y' order by IC_BANK_NAME");
		}
		    while(rs.next())
		    {
		    	list.add(rs.getString("IC_BANK_CODE")+"_"+rs.getString("IC_BANK_NAME"));
		    }
			//String searchList = new Gson().toJson(list);
		}
		 catch (Exception e) {
		    e.printStackTrace(System.out);
			 e.printStackTrace();
		 }
		return list;
	}

}

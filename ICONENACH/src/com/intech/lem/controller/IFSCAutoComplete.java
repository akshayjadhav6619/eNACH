package com.intech.lem.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.intech.lem.dao.ICONDBConnection;

public class IFSCAutoComplete  extends HttpServlet  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("term");
		System.out.println("TEST:"+name);
		String buffer="";  
		  ArrayList<String> list = new ArrayList<String>();
		  String reqState = req.getParameter("request");
          resp.setContentType("application/json");
		try{
		   //Class.forName("com.mysql.jdbc.Driver");
		   Connection con = ICONDBConnection.getConnection();//DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("SELECT IC_ID_CODE,IC_BANK_NAME,IC_BRANCH_NAME,IC_BRANCH_ADDRS,IC_CITY_NAME,IC_BRANCH_CODE,IC_BANK_CODE from SFMS.INT_SEND_RECV_INFO_DIR WHERE IC_DEL_FLG='N' AND IC_ENTITY_CRE_FLG='Y' AND IC_ID_CODE LIKE '"+name+"%'");
		    while(rs.next())
		    {
		    	if(reqState.equals("2")){
		    		list.add(rs.getString("IC_BANK_NAME"));
		    		list.add(rs.getString("IC_BRANCH_NAME"));
		    	}else{
		    	list.add(rs.getString("IC_ID_CODE"));
		    	}
		    //buffer=buffer+"'"+rs.getString("IC_ID_CODE")+"',";
		    }
		//resp.getWriter().println(buffer);
		
		String searchList = new Gson().toJson(list);
        System.out.println(searchList);
		resp.getWriter().write(searchList);
		}
		 catch (Exception e) {
		    e.printStackTrace(System.out);
			 e.printStackTrace();
		 }
		resp.getWriter().close();
		//super.doGet(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*		String name="IB";
		String buffer="";  
		try{
		   //Class.forName("com.mysql.jdbc.Driver");
		   Connection con = ICONDBConnection.getConnection();//DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("SELECT IC_ID_CODE,IC_BANK_NAME,IC_BRANCH_NAME,IC_BRANCH_ADDRS,IC_CITY_NAME,IC_BRANCH_CODE,IC_BANK_CODE from INT_SEND_RECV_INFO_DIR WHERE IC_DEL_FLG='N' AND IC_ENTITY_CRE_FLG='Y' AND IC_ID_CODE LIKE '"+name+"%'");
		    while(rs.next())
		    {
		    buffer=buffer+"'"+rs.getString("IC_ID_CODE")+"',";
		    }
		System.out.println(buffer);
		}
		 catch (Exception e) {
		    e.printStackTrace(System.out);
			 e.printStackTrace();
		 }*/

	}

}

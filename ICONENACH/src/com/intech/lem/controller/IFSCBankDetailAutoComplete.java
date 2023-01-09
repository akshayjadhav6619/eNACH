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

/**
 * Servlet implementation class IFSCBankDetailAutoComplete
 */
public class IFSCBankDetailAutoComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IFSCBankDetailAutoComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Key=request.getParameter("Key");
		String IFSC_Code=request.getParameter("IFSC_Code");
		ArrayList<String> BankDetailslist = new ArrayList<String>();
		response.setContentType("application/json");
		try{
		   //Class.forName("com.mysql.jdbc.Driver");
		   Connection con = ICONDBConnection.getConnection();//DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery("SELECT IC_ID_CODE,IC_BANK_NAME,IC_BRANCH_NAME,IC_BRANCH_ADDRS,IC_CITY_NAME,IC_BRANCH_CODE,IC_BANK_CODE from SFMS.INT_SEND_RECV_INFO_DIR WHERE IC_DEL_FLG='N' AND IC_ENTITY_CRE_FLG='Y' AND IC_ID_CODE = '"+IFSC_Code+"'");
		    if(rs.next())
		    {
		    	BankDetailslist.add("IFSC_Present");
		    	BankDetailslist.add(rs.getString("IC_BANK_NAME"));
		    	BankDetailslist.add(rs.getString("IC_BRANCH_NAME"));
		    	BankDetailslist.add(rs.getString("IC_ID_CODE"));
		    	
		    //buffer=buffer+"'"+rs.getString("IC_ID_CODE")+"',";
		    }else{
		    	BankDetailslist.add("IFSC_NOT_Present");
		    }
		//resp.getWriter().println(buffer);
		String searchList = new Gson().toJson(BankDetailslist);
        System.out.println(searchList);
        response.getWriter().write(searchList);
		}
		 catch (Exception e) {
		    e.printStackTrace(System.out);
			 e.printStackTrace();
		 }
		response.getWriter().close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

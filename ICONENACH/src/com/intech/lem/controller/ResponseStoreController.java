package com.intech.lem.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intech.lem.dao.ICONDBConnection;
import com.intech.lem.dao.MandateCancellationDao;
import com.intech.lem.model.MandateCancellationModel;
import com.intech.lem.service.ResponsesStoreService;

public class ResponseStoreController extends HttpServlet {
	public ResponseStoreController()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		
			
			String ResponseString=request.getParameter("responseString");
			System.out.println("ResponseString>>>>:"+ResponseString);
			ResponsesStoreService ResponseObj=new ResponsesStoreService();
			ResponseObj.StoreResponseData(ResponseString);
		    }catch(Exception e){
		    	
		    	System.out.println(e);
		    	
		    }
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		
		
		
	}
}

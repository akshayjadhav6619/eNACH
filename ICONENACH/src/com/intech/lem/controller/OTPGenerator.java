package com.intech.lem.controller;

import java.io.IOException;  


import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intech.lem.dao.LoginDao;
import com.intech.lem.service.CustomerService;
import com.intech.lem.service.OTPService;
import com.intech.lem.service.SessionPersistence;
import com.intech.lem.service.sms.SMSService;    

//@WebServlet("/OTPGen")
public class OTPGenerator extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    
	    String n=request.getParameter("loan_ref");
	    String enachPID=request.getParameter("enachPID");
	    
	    String mobileNumber =(String) request.getAttribute("mobileNumber");   //= new CustomerService().getMobileNumber(n);
	    String sessionPID=(String) request.getAttribute("sessionPID");

	    System.out.println("n:-->"+n);
	    System.out.println("mobileNumber---->"+mobileNumber);

	    System.out.println("enachPID---->"+enachPID);
	    //String sessionPID = enachPID;
	    request.setAttribute("sessionPID", sessionPID);

	    String otp = OTPService.OTP(6);
	    
	    HttpSession session = request.getSession(false);
	    
    	//System.out.println("from Session2:"+session.getAttribute("loan_ref"));

	    session.setAttribute("OTP", otp);
	    session.setAttribute("REF",n);
    	//System.out.println("from Session3:otp"+session.getAttribute("OTP"));
    	//System.out.println("from Session3:REF"+session.getAttribute("REF"));
	    
	    
	    //send otp to mobile
	    SMSService sMSService = new SMSService();
	    System.out.println("OTP:"+otp);
	    Map<String,String> respMap = sMSService.sendOTP(otp, mobileNumber,n);
	    
	    if(LoginDao.validate(n) && respMap.get("STATUS").equals("OK")){ 
	    	
	    	request.setAttribute("state", "O");
	        //request.setAttribute("mobileNumber",mobileNumber);
	        request.setAttribute("OTP", otp);
	        request.setAttribute("REF", n);
	        request.setAttribute("mobileNumber", mobileNumber);
	    	request.setAttribute("loan_ref", n);
	    	
	    	
	        String lastFourDigits="";
	        
			SessionPersistence obj = new SessionPersistence();
			System.out.println(obj.updateSessionById(sessionPID, otp, "O"));

			
			if (mobileNumber.length() > 4) 
	        {
	            lastFourDigits = mobileNumber.substring(mobileNumber.length() - 4);
	        } 
	        else
	        {
	            lastFourDigits = mobileNumber;
	        }
	        request.setAttribute("mobileNumberPart",lastFourDigits);
	        request.setAttribute("otp",otp); //It will commented in future..!

	        
	        
	        RequestDispatcher rd=request.getRequestDispatcher("otp.jsp");  
	        rd.forward(request,response); 
	        
	    }  
	    else{  
	        out.print("Some other issue, Please Contact System Admin...!!");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();  
	    }  
}  
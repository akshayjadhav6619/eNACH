package com.intech.lem.controller;

import java.io.IOException;  


import java.io.PrintWriter;   
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intech.lem.dao.LoginDao;
import com.intech.lem.dao.ApplicationAttempt;
import com.intech.lem.service.CustomerService;
import com.intech.lem.service.SessionPersistence;
import com.intech.lem.service.VerifyRecaptcha;    

//@WebServlet("/RefValidator")
public class RefValidation extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException { 
		
		
		response.addHeader("X-Frame-Options", "DENY");
		response.addHeader("Content-Security-Policy", "frame-ancestors 'none'");
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  	          
	    String n=request.getParameter("loan_ref");
	    
	   
	    
	    /*String gRecaptchaResponse = request
				.getParameter("g-recaptcha-response");
	    
		
		System.out.println(gRecaptchaResponse);
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);*/
	    //after enable domain recaptcha will enable here...!
	    
		
		
	    System.out.println("In controller logon attempt: "+n);
	    CustomerService customerService = new CustomerService();
	    String mobileNumber = customerService.getMobileNumber(n);
	    
	    
	   
	    //if(LoginDao.validate(n)  && verify){  
	    if(LoginDao.validate(n)){   
	    	System.out.println("into if");
	    	if(ApplicationAttempt.validateWRAttempt(n))
	    	{
	    		 out.print("<script>window.location.href = '/ICONENACH/refErr.jsp';</script>");
                 
		    	 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		    	 rd.forward(request,response);  
	    	}
	    	else{
	    		
	    		//if(ApplicationAttempt.validateActiveStatus(n))
	    		//{
	    			//out.print("<script>window.location.href = '/ICONENACH/refErr.jsp';</script>");
	                 
			    	// RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			    	 //rd.forward(request,response); 
	    		//}
	    		//else{
	    	HttpSession session = request.getSession(true);
	    	String sID = session.getId();
	    	session.setAttribute("loan_ref", n);
	    	//session.setMaxInactiveInterval(20*60);//20*60 Sec
	    	
	    	
	    	//session = request.getSession();
	        
	    	
	    	
	    	
	    	
	    	SessionPersistence sessionPersist = new SessionPersistence();	    	
	    	String sessionPID = sessionPersist.storeNewSession(n,mobileNumber,sID);
	    	
	    	//session.setAttribute("sessionPID", sessionPID);	    	
	    	//here we need to create session record in data base....
	    	System.out.println("from Session:"+session.getAttribute("loan_ref"));
	    	
	    	System.out.println("sessionPID====>"+sessionPID);

	    	System.out.println("enachPID+"+sessionPID);
	    	
	    	
	    	request.setAttribute("enachPID", sessionPID);
	    	request.setAttribute("sessionPID",sessionPID);
	    	request.setAttribute("loan_ref", n);
	    	request.setAttribute("mobileNumber", mobileNumber);
	    	System.out.println("Req test:"+request.getAttribute("enachPID"));
	    	RequestDispatcher rd=request.getRequestDispatcher("/OTPGen"); 	        	    	
	    	rd.include(request,response); 
	    	}
	    	}
	        
	   // }
	    else{  
	        //out.print("Sorry reference not found !");  
	        
	    	 out.print("<script>window.location.href = '/ICONENACH/refErr.jsp';</script>");
	    	                         
	    	 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
	    	 rd.forward(request,response);  
	    }  
	          
	    out.close();  
	    }  
}  
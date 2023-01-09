package com.intech.lem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Date;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
import com.intech.lem.dao.ApplicationAttempt;
import com.sun.xml.internal.bind.CycleRecoverable.Context;

/**
 * Servlet implementation class OTPValidator
 */
//@WebServlet("/OTPValidator")
public class OTPValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OTPValidator() {
        super();
        // TODO Auto-generated constructor stub
    }

   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("X-Frame-Options", "DENY");
		response.addHeader("Content-Security-Policy", "frame-ancestors 'none'");
		String  mobileNumber= (String) request.getParameter("mobileNumber");
		String  loan_ref=  (String) request.getParameter("loan_ref");
		String  sessionPID=  (String) request.getParameter("sessionPID");
	    
		
		System.out.println("sessionPID"+sessionPID);
		SessionPersistence obj = new SessionPersistence();
		String 	otpSystem = obj.getOTPById(sessionPID);//(String) request.getAttribute("otp");
    	
    	
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    
	    String otp_v1 = request.getParameter("otp_v1");
	    String otp_v2 = request.getParameter("otp_v2");
	    String otp_v3 = request.getParameter("otp_v3");
	    String otp_v4 = request.getParameter("otp_v4");
	    String otp_v5 = request.getParameter("otp_v5");
	    String otp_v6 = request.getParameter("otp_v6");
	    
	    String otp=""+otp_v1+otp_v2+otp_v3+otp_v4+otp_v5+otp_v6;
	    System.out.println("otp:"+otp);
	    System.out.println("otpSystem:"+otpSystem);

	   
	    HttpSession session = request.getSession(false);
	    
    	//System.out.println("from Session3:otptest4"+session.getAttribute("OTP"));
    	//System.out.println("2"+session.getAttribute("OTP").toString());
	    //String otpSystem=(String) session.getAttribute("OTP");
	    
	    //String referenceNumber = (String) session.getAttribute("REF");

	    //send otp to mobile
	    
	
	   
	   
	   
   	   int loginAttempt;
   	   if (session.getAttribute("loginCount") == null)
       {
         session.setAttribute("loginCount", 0);
         loginAttempt = 0;
       }
       else
       {
         loginAttempt = (Integer) 
          session.getAttribute("loginCount");
       }
        System.out.println("loginAttempt>>>"+loginAttempt);

	    if((loginAttempt < 2) && (otp.equals(otpSystem))){ 	    	
	        System.out.println("Inside Correct OTP loginAttempt>>>"+loginAttempt);

	        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
	        
	        request.setAttribute("mobileNumber",mobileNumber);
	        //request.setAttribute("otp",otp); //It will commented in future..!
	        //request.setAttribute("appliction_number", n);
	        request.setAttribute("mobileNumber",mobileNumber);
			request.setAttribute("loan_ref",loan_ref);
			request.setAttribute("sessionPID",sessionPID);	       
	        
	        //update to session as active...
	        rd.forward(request,response);
	        
	        
	    }  
	    else{ 
	    	
	    	//Added on 21022022
	           
	            //this is 3 attempt counting from 0,1,2
	            if (loginAttempt >= 2 )
	            {
	                long lastAccessedTime = 
	    session.getLastAccessedTime();
	                Date date = new Date();
	                long currentTime = date.getTime();
	                long timeDiff = currentTime - lastAccessedTime;
	                // 20 minutes in milliseconds
	                if (timeDiff >= 1200000)
	                {
	                    //invalidate user session, so they can try again
	                    ApplicationAttempt.LogoutStatus(loan_ref);

	                    session.invalidate();
	                }
	                else
	                {
	                    // Error message
	                	request.setAttribute("state", "W");
		    	        request.setAttribute("mobileNumber",mobileNumber);
		    	        //request.setAttribute("message", "Wrong OTP !!");
		    	        
		    	        request.setAttribute("mobileNumber",mobileNumber);
		    			request.setAttribute("loan_ref",loan_ref);
		    			request.setAttribute("sessionPID",sessionPID);
		    			request.setAttribute("message","You have  exceeded the 3 failed  attempt. Please try after in 20 minutes.");
		    			RequestDispatcher rd=request.getRequestDispatcher("otp.jsp");  			   
		    	        rd.include(request,response); 
	                }

	            }
	            else
	            {
	                loginAttempt++;
	                int allowLogin = 3-loginAttempt;
	                ApplicationAttempt.LockUser(loan_ref);
	                request.setAttribute("state", "W");
	    	        request.setAttribute("mobileNumber",mobileNumber);
	    	        //request.setAttribute("message", "Wrong OTP !!");
	    	        
	    	        request.setAttribute("mobileNumber",mobileNumber);
	    			request.setAttribute("loan_ref",loan_ref);
	    			request.setAttribute("sessionPID",sessionPID);
	                request.setAttribute("message","loginAttempt= "+loginAttempt+". Invalid OTP password. You have  "+allowLogin+" attempts remaining. Please try again!");
	    			RequestDispatcher rd=request.getRequestDispatcher("otp.jsp");  			   
	    	        rd.include(request,response); 
	            }
	            session.setAttribute("loginCount",loginAttempt);
	        }
	    	
	    	
	    	
	    	
	    	
///	Added on 21022022    	
	    	
	    	
	    	
	        //out.print("OTP wrong !!");  
	        
	   /*     request.setAttribute("state", "W");
	        request.setAttribute("mobileNumber",mobileNumber);
	        request.setAttribute("message", "Wrong OTP !!");
	        
	        request.setAttribute("mobileNumber",mobileNumber);
			request.setAttribute("loan_ref",loan_ref);
			request.setAttribute("sessionPID",sessionPID);
			
			RequestDispatcher rd=request.getRequestDispatcher("otp.jsp");  			   
	        rd.include(request,response);  
	    }  	     */     
	}

}

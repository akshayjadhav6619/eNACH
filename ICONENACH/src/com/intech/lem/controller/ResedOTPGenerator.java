package com.intech.lem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intech.lem.dao.LoginDao;
import com.intech.lem.service.CustomerService;
import com.intech.lem.service.OTPService;
import com.intech.lem.service.SessionPersistence;
import com.intech.lem.service.sms.SMSService;

/**
 * Servlet implementation class ResedOTPGenerator
 */
public class ResedOTPGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResedOTPGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		
				String  loan_ref=  (String) request.getAttribute("loan_ref");
			    response.setContentType("text/html");  
			    HttpSession session = request.getSession(false);
			    PrintWriter out = response.getWriter();  
			    String n=request.getParameter("loanRefNumber");
			    String mobileNumber=request.getParameter("mobileNumber");
			    String  sessionPID=  request.getParameter("sessionPID");
			    String otp = OTPService.OTP(6);
			    SMSService sMSService = new SMSService();
			    Map<String,String> respMap = sMSService.sendOTP(otp, mobileNumber,n);
			    
			    if(LoginDao.validate(n) && respMap.get("STATUS").equals("OK")){ 
			    	request.setAttribute("state", "O");
			        request.setAttribute("OTP", otp);
			        request.setAttribute("REF", n);
			        request.setAttribute("mobileNumber", mobileNumber);
			    	request.setAttribute("loan_ref", n);
					SessionPersistence obj = new SessionPersistence();
					obj.updateSessionById(sessionPID, otp, "O");
			        String lastFourDigits="";
			        
					if (mobileNumber.length() > 4) 
			        {
			            lastFourDigits = mobileNumber.substring(mobileNumber.length() - 4);
			        } 
			        else
			        {
			            lastFourDigits = mobileNumber;
			        }
				    request.setAttribute("mobileNumberPart",lastFourDigits);
					out.print(lastFourDigits);  
			    }
			   
			    else{  
			        out.print("error");  
			        
			    }  
			          
			    out.close();
		      response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  
	   // out.close();
		
		
	}

}

package com.intech.lem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.intech.lem.dao.ICONDBConnection;
import com.intech.lem.dao.SaveMandate;
import com.intech.lem.model.EMStructure;
import com.intech.lem.service.ApplicationDetails;
import com.intech.lem.service.HashGenerator;
import com.intech.lem.model.ConsumerData;

/**
 * Servlet implementation class ControllerStore
 */
//@WebServlet("/getSave")
public class ControllerStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerStore() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String  mobileNumber= (String) request.getParameter("mobileNumber");
		String  loan_ref=  (String) request.getParameter("loan_ref");
		String  sessionPID=  (String) request.getParameter("sessionPID");
		boolean hashStatus =false;
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		Map test = request.getParameterMap();  
    	HttpSession session = request.getSession();
		ApplicationDetails appDetails = new ApplicationDetails();
	 	Map<String,String> mapData = appDetails.getAppDetailsById(loan_ref);
		String start_date_str="";//c
		String paymentType="all";
		String Ref_num="";
		Connection con = ICONDBConnection.getConnection();

		String sqlIdentifier = "select ENACH_MER_ID_SEQ.NEXTVAL from dual";
		PreparedStatement pst=null;
		try {
			pst = con.prepareStatement(sqlIdentifier);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized( this ) {
		   ResultSet rs=null;
		try {
			rs = pst.executeQuery();
			if(rs.next())
			{
			      Ref_num  = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
		System.out.println("Sequence number:::"+Ref_num);
		
	    SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");  
	    Date date = new Date();
	    String date1=formatter.format(date);
	    System.out.println(date1);
	    String Mer_ref_num="EN"+date1+Ref_num;
		
		if (test.containsKey("start_date")) 
		{
			start_date_str = request.getParameter("start_date");
			
		}else
		{
			start_date_str = mapData.get("START_DATE");
		}
		
		String end_date_str="";//c
		if (test.containsKey("end_date"))
		{
			
			end_date_str = request.getParameter("end_date");
			
		}else
		{
			
			end_date_str=mapData.get("END_DATE");
		}		
		
		String debit_type="";//    ->fxa/mxa
		if (test.containsKey("dt"))
		{
			debit_type = request.getParameter("dt");
		}else
		{
			debit_type = "M";
		}
		
		String freq="";
		if (test.containsKey("freq"))
		{
			freq = request.getParameter("freq");
		}else
		{
			freq = "MNTH";
		}
		
		String dest_bank="";
		
		String dest_ifsc=null;
		if (test.containsKey("dest_ifsc"))
		{
			dest_ifsc = null;//request.getParameter("dest_ifsc");
		}else{
			
		}
		
		String amount="";//c
		if (test.containsKey("amount")) {
			amount = request.getParameter("amount");
		}else{
			amount=mapData.get("LOAN_EMI");
		}
		
		String loan_amount="";
		if (test.containsKey("loan_amount")) {
			loan_amount = request.getParameter("loan_amount");
		}else{
			loan_amount =  mapData.get("LOAN_AMT");
		}
		
		String LOAN_EMI_NEAREST_1000="";
		if (test.containsKey("LOAN_EMI_NEAREST_1000")) {
			
			LOAN_EMI_NEAREST_1000 = request.getParameter("LOAN_EMI_NEAREST_1000");
			
		}else{
			LOAN_EMI_NEAREST_1000 =  mapData.get("LOAN_EMI_NEAREST_1000");
		}
		
		
		String utility_code="";
		if (test.containsKey("utility_code")) {
			utility_code = "";
		}else{
			utility_code="";
		}
		
		String acc_type="Saving";
		if (test.containsKey("acc_type")) {
			acc_type = "Saving";
		}else{
			acc_type="Saving";
		}
		
		String acc_num=null;
		if (test.containsKey("acc_num")) {
			acc_num = request.getParameter("acc_num");
		}else{
			acc_num=mapData.get("PERAPP_BANKACCNO");
		}
		
		String acc_holder_name=null;//c
		if (test.containsKey("acc_holder_name")) {
			acc_holder_name = request.getParameter("acc_holder_name");
		}else{
			acc_holder_name =  mapData.get("PERAPP_FNAME");
			
		}
		
		String cust_additional_details="";//request.getParameter("cust_additional_details");
		if (test.containsKey("cust_additional_details")) {
			cust_additional_details = "";
		}else{
			cust_additional_details="";
		}
		
		String email="";//c
		if (test.containsKey("email")) {
			email = request.getParameter("email");
		}else{
			email =  mapData.get("PERAPP_EMAIL");
			
		}
		
		String tel_num=null;//request.getParameter("tel_num");
		if (test.containsKey("tel_num")) {
			tel_num = null;//"";
		}else{
			tel_num = null;//mapData.get("PERAPP_PHONE");
			
		}
		
		String mobile="";//c
		if (test.containsKey("mobile")) {
			mobile = request.getParameter("mobile").trim();
		}else{
			mobile = mapData.get("PERAPP_MOBILE").trim();
			
		}
		
		String ref_no="";//c
		if (test.containsKey("ref_no")) {
			ref_no = request.getParameter("ref_no");
		}{
			ref_no = mapData.get("APP_NO");
			
		}
		
		String panNumber=null;//request.getParameter("pan");
		if (test.containsKey("pan")) {
			panNumber = null;//""
		}else{
			panNumber =null;//mapData.get("PERAPP_PANNO");
		}
		
		String consumerID=mapData.get("APP_USRID");					//request.getParameter("");		
		
		
		String amountType="M";
		if (test.containsKey("dt")) {
			amountType = request.getParameter("dt");
		}
		
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		Date start_date=null;
		if (start_date_str!=null && !start_date_str.equals("")) {
			try {
				start_date = format.parse(start_date_str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Date end_date=null;
		if (end_date_str!=null && !end_date_str.equals("")) {
		 try {
			end_date = format.parse(end_date_str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		String dc_bank="";//c
		if (test.containsKey("dc_bank")) {
			dc_bank= request.getParameter("dc_bank");
		}else{
			
		}
		String dc_number="";//c
		if (test.containsKey("dc_number")) {
			dc_number= request.getParameter("dc_number");
		}else{
			
		}
		String dc_ey="";//c
		if (test.containsKey("dc_ey")) {
			dc_ey= request.getParameter("dc_ey");
		}else{
			
		}
		String dc_em="";//c
		if (test.containsKey("dc_em")) {
			dc_em= request.getParameter("dc_em");
		}else{
			
		}
		String dc_cvv="";//c
		if (test.containsKey("dc_cvv")) {
			dc_cvv= request.getParameter("dc_cvv");
		}else{
			
		}
		String terms="";//c
		if (test.containsKey("terms"))
		{
			terms= request.getParameter("terms");
		}else{
			
		}
		

		
		ResourceBundle rsBundle = ResourceBundle.getBundle("EMApplication");
	    String pwdID = rsBundle.getString("HSALT");
	    String sID = rsBundle.getString("BankSpecificCode");
	    String SCHEMECODE = rsBundle.getString("SCHEMECODE");
		EMStructure emObj =  new EMStructure();
		emObj.setStart_date(start_date);
		emObj.setEnd_date(end_date);
		emObj.setDebit_type(debit_type);
		emObj.setFreq(freq);
		emObj.setDest_bank(dest_bank);
		emObj.setDest_ifsc(dest_ifsc);
		emObj.setAmount(amount);
		emObj.setUtility_code(utility_code);
		emObj.setAcc_type(acc_type);
		emObj.setAcc_num(acc_num);
		emObj.setAcc_holder_name(acc_holder_name);
		emObj.setCust_additional_details(cust_additional_details);
		emObj.setEmail(email);
		emObj.setTel_num(tel_num);
		emObj.setMobile(mobile);
		emObj.setApp_no(ref_no);
		emObj.setPanNumber(panNumber);
		emObj.setSID(sID);
		emObj.setPwdID(pwdID);
		emObj.setConsumerID(consumerID);
		emObj.setAmountType(amountType);
		emObj.setCardBank(dc_bank);
		emObj.setCardNumber(dc_number);
		emObj.setCardExpiryYear(dc_ey);
		emObj.setCardExpiryMonth(dc_em);
		emObj.setCardCVV(dc_cvv);
		emObj.setTerms(terms);
		emObj.setLoanAmount(loan_amount);
		emObj.setMer_Ref_Num(Mer_ref_num);
		String deviceId=rsBundle.getString("deviceId");
		String returnUrl = rsBundle.getString("returnUrl");
    	String merchantLogoUrl = rsBundle.getString("merchantLogoUrl");
    	String PRIMARY_COLOR_CODE = rsBundle.getString("PRIMARY_COLOR_CODE");	    	
    	String SECONDARY_COLOR_CODE = rsBundle.getString("SECONDARY_COLOR_CODE");
    	String BUTTON_COLOR_CODE_1 = rsBundle.getString("BUTTON_COLOR_CODE_1");
    	String BUTTON_COLOR_CODE_2 = rsBundle.getString("BUTTON_COLOR_CODE_2");
    	
    	
		//0.create java.Object for cunsumer data...
		ConsumerData consumerData = new ConsumerData();
		consumerData.setDeviceId(deviceId);
		consumerData.setReturnUrl(returnUrl);
		consumerData.setResponseHandler("handleResponse");
		consumerData.setPaymentMode(paymentType);
		consumerData.setMerchantLogoUrl(merchantLogoUrl);
		consumerData.setMerchantId(sID);
		consumerData.setCurrency("INR");
		consumerData.setConsumerId(consumerID);
		
		consumerData.setConsumerMobileNo(mobile);
		consumerData.setConsumerEmailId(email);
		consumerData.setTxnId(Mer_ref_num);
		consumerData.setPan(panNumber);
		consumerData.setPhoneNumber(tel_num);
		Map<String,String> colors = new HashMap<String,String>();
		colors.put("PRIMARY_COLOR_CODE", PRIMARY_COLOR_CODE);
		colors.put("SECONDARY_COLOR_CODE", SECONDARY_COLOR_CODE);
		colors.put("BUTTON_COLOR_CODE_1", BUTTON_COLOR_CODE_1);
		colors.put("BUTTON_COLOR_CODE_2", BUTTON_COLOR_CODE_2);
		consumerData.setCustomStyle(colors);
		Map<String,String> itemData = new HashMap<String,String>();
		itemData.put("itemId", SCHEMECODE);
		LOAN_EMI_NEAREST_1000="5";
		itemData.put("amount", LOAN_EMI_NEAREST_1000);
		itemData.put("comAmt", "0");
		List<Map<String,String>> itemList = new ArrayList<Map<String,String>>();
		itemList.add(itemData);
		consumerData.setItems(itemList);
		consumerData.setAccountNo(acc_num);
		consumerData.setAccountHolderName("");
		consumerData.setAccountType(acc_type);
		consumerData.setDebitStartDate(start_date_str);
		consumerData.setDebitEndDate(end_date_str);
		consumerData.setMaxAmount("100");
		consumerData.setAmountType(amountType);
		consumerData.setFrequency(freq);
		consumerData.setIfscCode(dest_ifsc);
		
		consumerData.setCardNumber(dc_number);
		consumerData.setExpMonth(dc_em);
		consumerData.setExpYear(dc_ey);
		consumerData.setCvvCode(dc_cvv);
		
		String strHashCollection= consumerData.getMerchantId()+"|"+consumerData.getTxnId()+
				"|"+"5"+"|"+"|"+consumerData.getConsumerId()+
				"|"+consumerData.getConsumerMobileNo()+"|"+consumerData.getConsumerEmailId()+"|"+consumerData.getDebitStartDate()+
				"|"+consumerData.getDebitEndDate()+"|"+consumerData.getMaxAmount()+"|"+consumerData.getAmountType()+"|"+consumerData.getFrequency()+
				"|"+consumerData.getCardNumber()+"|"+consumerData.getExpMonth()+"|"+consumerData.getExpYear()+"|"+consumerData.getCvvCode()+
				"|"+pwdID;
		
		
		System.out.println("pipe seperated string :"+strHashCollection);
		PreparedStatement pst1=null;
		 try {
			 pst1 =con.prepareStatement("insert into INT_EMANADATE_REQ_RESPONSE(IC_TRANS_NO,IC_TRANS_SNO,MER_REF_NUM,IC_REQUEST) VALUES(INT_SEQ_INW_RESP.NEXTVAL,2,?,?) ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//PreparedStatement pst =con.prepareStatement("update INT_EMANADATE_REQ_RESPONSE set IC_RESPONSE=? where IC_TRANS_NO=?");
		try {
			pst1.setString(1, Mer_ref_num);
			pst1.setString(2, strHashCollection);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    int i=0;
		try {
			i = pst1.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	    if(i>0)
	    {
	    	System.out.println("Request Successfully Inserted...");
	    	try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
		
		
		String hashSALTCode="";
		try {
			hashSALTCode = new HashGenerator().getSHA(strHashCollection);
			hashStatus= true;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		
		System.out.println("hash:"+hashSALTCode);
		
		
		//2.create js.object for consumer data....
        consumerData.setToken(hashSALTCode);
        emObj.setHashValue(hashSALTCode);
		int result = SaveMandate.save(emObj);
		if(result>0){
			//hit url
			System.out.println("You are successfully registered...");
	    	
			
	        //Consumer data setted here done....!consumerData
	        Gson gson = new Gson();
	        System.out.println(consumerData);
	        String jsonObject = gson.toJson(consumerData);
	        System.out.println("jsonObject"+jsonObject.replaceAll("\"", "'"));
	        
	        RequestDispatcher rd=request.getRequestDispatcher("testIntegration.jsp");
			request.setAttribute("consumerData",jsonObject.replaceAll("\"", "'"));
			
	       
			// request.setAttribute("otp",otp); //It will commented in future..!
	        rd.forward(request,response);
			
		}
		
		else{
			System.out.println("some thing went wrong!!\n"+"while saving data into db");
			//out.print("some thing went wrong!!...");  
			
			RequestDispatcher rd=request.getRequestDispatcher("er.jsp");  
	       // request.setAttribute("mobileNumber",mobileNumber);
	        //request.setAttribute("otp",otp); //It will commented in future..!
	        rd.forward(request,response);
		}
		
		 
			out.close();  
		
		//doGet(request, response);
		}

}

package com.intech.lem.model;

import java.util.Date;

public class EMStructure {

	private Date end_date=null;
	private Date start_date=null;
	private String debit_type=null;
	private String freq=null;
	private String dest_bank=null;
	private String dest_ifsc=null;
	private String amount=null;
	private String utility_code=null;
	private String acc_type="Saving";//default
	private String acc_num=null;
	private String acc_holder_name=null;
	private String cust_additional_details=null;
	private String email=null;
	private String tel_num=null;
	private String mobile=null;
	private String app_no;
	private String panNumber=null;
	private String sID=null;
	private String pwdID=null;
	
	private String consumerID=null;
	private String amountType=null;
	
	private String cardBank=null;
	private String cardNumber=null;
	private String  cardExpiryYear=null;
	private String  cardExpiryMonth=null;
	private String cardCVV=null;	
	private String terms=null;
	
	
	private String loanAmount="";
	
	private String HashValue="";
	private String MerRefNum=null;
	
	
	public String getHashValue() {
		return HashValue;
	}
	public void setHashValue(String hashValue) {
		HashValue = hashValue;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getCardBank() {
		return cardBank;
	}
	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpiryYear() {
		return cardExpiryYear;
	}
	public void setCardExpiryYear(String cardExpiryYear) {
		this.cardExpiryYear = cardExpiryYear;
	}
	public String getCardExpiryMonth() {
		return cardExpiryMonth;
	}
	public void setCardExpiryMonth(String cardExpiryMonth) {
		this.cardExpiryMonth = cardExpiryMonth;
	}
	public String getCardCVV() {
		return cardCVV;
	}
	public void setCardCVV(String cardCVV) {
		this.cardCVV = cardCVV;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public String getDebit_type() {
		return debit_type;
	}
	public void setDebit_type(String debit_type) {
		this.debit_type = debit_type;
	}
	public String getFreq() {
		return freq;
	}
	public void setFreq(String freq) {
		this.freq = freq;
	}
	public String getDest_bank() {
		return dest_bank;
	}
	public void setDest_bank(String dest_bank) {
		this.dest_bank = dest_bank;
	}
	public String getDest_ifsc() {
		return dest_ifsc;
	}
	public void setDest_ifsc(String dest_ifsc) {
		this.dest_ifsc = dest_ifsc;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUtility_code() {
		return utility_code;
	}
	public void setUtility_code(String utility_code) {
		this.utility_code = utility_code;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public String getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}
	public String getAcc_holder_name() {
		return acc_holder_name;
	}
	public void setAcc_holder_name(String acc_holder_name) {
		this.acc_holder_name = acc_holder_name;
	}
	public String getCust_additional_details() {
		return cust_additional_details;
	}
	public void setCust_additional_details(String cust_additional_details) {
		this.cust_additional_details = cust_additional_details;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel_num() {
		return tel_num;
	}
	public void setTel_num(String tel_num) {
		this.tel_num = tel_num;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getApp_no() {
		return app_no;
	}
	public void setApp_no(String app_no) {
		this.app_no = app_no;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getSID() {
		return sID;
	}
	public void setSID(String sID) {
		this.sID = sID;
	}
	public String getPwdID() {
		return pwdID;
	}
	public void setPwdID(String pwdID) {
		this.pwdID = pwdID;
	}
	public String getAmountType() {
		return amountType;
	}
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}
	public String getConsumerID() {
		return consumerID;
	}
	public void setConsumerID(String consumerID) {
		this.consumerID = consumerID;
	}
	
	//Added on 23-01-2022 for unique Merchant Ref num
	
	public String getMer_Ref_Num() {
		return MerRefNum;
	}
	public void setMer_Ref_Num(String MerRefNum) {
		this.MerRefNum = MerRefNum;
	}

	
	
}

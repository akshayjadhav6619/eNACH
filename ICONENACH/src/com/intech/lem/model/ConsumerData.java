package com.intech.lem.model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.intech.lem.service.HashGenerator;

public class ConsumerData {

	String deviceId=null;
	String token=null;
	String returnUrl=null;
	
	String responseHandler=null;
	String paymentMode=null;
	String merchantLogoUrl=null;
	
	String merchantId=null;
	String currency=null;
	String consumerId=null;
	String consumerMobileNo=null;
	String consumerEmailId=null;
	String txnId=null;
	
	List<Map<String,String>> items=null;
	Map<String,String> customStyle=null;
	
	
	String accountNo=null;
	String accountHolderName=null;
	
	String accountType=null;
	
	String debitStartDate=null;
	String debitEndDate=null;
	String maxAmount=null;
	String amountType=null;
	String frequency=null;
	
	String ifscCode=null;
	
	String pan=null;
	String phoneNumber=null;
	
	
	String cardNumber=null;String  expMonth=null;
	String expYear=null;String cvvCode=null;
	/*String bankCode=null;
	
	
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}*/
	
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	public String getExpYear() {
		return expYear;
	}
	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}
	public String getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getResponseHandler() {
		return responseHandler;
	}
	public void setResponseHandler(String responseHandler) {
		this.responseHandler = responseHandler;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getMerchantLogoUrl() {
		return merchantLogoUrl;
	}
	public void setMerchantLogoUrl(String merchantLogoUrl) {
		this.merchantLogoUrl = merchantLogoUrl;
	}
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerMobileNo() {
		return consumerMobileNo;
	}
	public void setConsumerMobileNo(String consumerMobileNo) {
		this.consumerMobileNo = consumerMobileNo;
	}
	public String getConsumerEmailId() {
		return consumerEmailId;
	}
	public void setConsumerEmailId(String consumerEmailId) {
		this.consumerEmailId = consumerEmailId;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public List<Map<String, String>> getItems() {
		return items;
	}
	public void setItems(List<Map<String, String>> items) {
		this.items = items;
	}
	public Map<String, String> getCustomStyle() {
		return customStyle;
	}
	public void setCustomStyle(Map<String, String> customStyle) {
		this.customStyle = customStyle;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getDebitStartDate() {
		return debitStartDate;
	}
	public void setDebitStartDate(String debitStartDate) {
		this.debitStartDate = debitStartDate;
	}
	public String getDebitEndDate() {
		return debitEndDate;
	}
	public void setDebitEndDate(String debitEndDate) {
		this.debitEndDate = debitEndDate;
	}
	public String getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(String maxAmount) {
		this.maxAmount = maxAmount;
	}
	public String getAmountType() {
		return amountType;
	}
	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/*public static void main(String[] args) {
		ConsumerData consumerData = new ConsumerData();
		consumerData.getDeviceId();
		consumerData.setReturnUrl(returnUrl);
		consumerData.setResponseHandler("handleResponse");
		consumerData.setPaymentMode("netBanking");
		consumerData.setMerchantLogoUrl(merchantLogoUrl);
		consumerData.setMerchantId(sID);
		consumerData.setCurrency("INR");
		consumerData.setConsumerId(consumerID);
		consumerData.setConsumerMobileNo(mobile);
		consumerData.setConsumerEmailId(email);
		consumerData.setTxnId(ref_no);
		
		Map<String,String> colors = new HashMap<String,String>();
		colors.put("PRIMARY_COLOR_CODE", PRIMARY_COLOR_CODE);
		colors.put("SECONDARY_COLOR_CODE", SECONDARY_COLOR_CODE);
		colors.put("BUTTON_COLOR_CODE_1", BUTTON_COLOR_CODE_1);
		colors.put("BUTTON_COLOR_CODE_2", BUTTON_COLOR_CODE_2);
		consumerData.setCustomStyle(colors);
		
		Map<String,String> itemData = new HashMap<String,String>();
		itemData.put("itemId", "test");
		itemData.put("amount", "5");
		itemData.put("comAmt", "0");
		List<Map<String,String>> itemList = new ArrayList<Map<String,String>>();
		itemList.add(itemData);
		consumerData.setItems(itemList);
		consumerData.setAccountNo(acc_num);
		consumerData.setAccountHolderName(acc_holder_name);
		consumerData.setAccountType(acc_type);
		consumerData.setDebitStartDate(start_date_str);
		consumerData.setDebitEndDate(end_date_str);
		consumerData.setMaxAmount(amount);
		consumerData.setAmountType(amountType);
		consumerData.setFrequency(freq);
		consumerData.setIfscCode(dest_ifsc);
		
		
		
		
		
		
        consumerData.setToken(hashSALTCode);
	}*/
	
	
}

package com.intech.lem.model;

public class MandateCancellationModel {
	
	private String AccountName;;
	private String LoanAccNumber;
	private String UMRNumber;
	private String IFSC_code;
	private String Customer_Name;
	private String CancellationReason;
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getLoanAccNumber() {
		return LoanAccNumber;
	}
	public void setLoanAccNumber(String loanAccNumber) {
		LoanAccNumber = loanAccNumber;
	}
	public String getUMRNumber() {
		return UMRNumber;
	}
	public void setUMRNumber(String uMRNumber) {
		UMRNumber = uMRNumber;
	}
	public String getIFSC_code() {
		return IFSC_code;
	}
	public void setIFSC_code(String iFSC_code) {
		IFSC_code = iFSC_code;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getCancellationReason() {
		return CancellationReason;
	}
	public void setCancellationReason(String cancellationReason) {
		CancellationReason = cancellationReason;
	}
	@Override
	public String toString() {
		return "MandateCancellationModel [AccountName=" + AccountName
				+ ", LoanAccNumber=" + LoanAccNumber + ", UMRNumber="
				+ UMRNumber + ", IFSC_code=" + IFSC_code + ", Customer_Name="
				+ Customer_Name + ", CancellationReason=" + CancellationReason
				+ "]";
	}
	
	
	
}

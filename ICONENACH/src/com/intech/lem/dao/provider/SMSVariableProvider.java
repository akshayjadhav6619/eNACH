package com.intech.lem.dao.provider;

public class SMSVariableProvider {

		String RequestURL= null;
		String TestRecipient = null;
		String TestMessage = null;
		String UserName = null;
		String Password = null;
		String TestOriginator =null;
		public SMSVariableProvider() {
			super();
			// TODO Auto-generated constructor stub
		}
		public SMSVariableProvider(String requestURL, String testRecipient, String testMessage, String userName,
				String password, String testOriginator) {
			super();
			RequestURL = requestURL;
			TestRecipient = testRecipient;
			TestMessage = testMessage;
			UserName = userName;
			Password = password;
			TestOriginator = testOriginator;
		}
		public String getRequestURL() {
			return RequestURL;
		}
		public void setRequestURL(String requestURL) {
			RequestURL = requestURL;
		}
		public String getTestRecipient() {
			return TestRecipient;
		}
		public void setTestRecipient(String testRecipient) {
			TestRecipient = testRecipient;
		}
		public String getTestMessage() {
			return TestMessage;
		}
		public void setTestMessage(String testMessage) {
			TestMessage = testMessage;
		}
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getTestOriginator() {
			return TestOriginator;
		}
		public void setTestOriginator(String testOriginator) {
			TestOriginator = testOriginator;
		}
		@Override
		public String toString() {
			return "SMSVariableProvider [RequestURL=" + RequestURL + ", TestRecipient=" + TestRecipient
					+ ", TestMessage=" + TestMessage + ", UserName=" + UserName + ", Password=" + Password
					+ ", TestOriginator=" + TestOriginator + "]";
		} 

		
		
}

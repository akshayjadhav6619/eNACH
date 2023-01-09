package com.intech.lem.dao.provider;

public class DBVariablesProvider {

	private String DRIVER="";//"oracle.jdbc.driver.OracleDriver";  
	private String CONNECTION_URL="";//"jdbc:oracle:thin:@localhost:1521:xe";  
	private String USERNAME="";//"system";  
	private String PASSWORD="";//"oracle";
	
	
	public DBVariablesProvider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DBVariablesProvider(String dRIVER, String cONNECTION_URL, String uSERNAME, String pASSWORD) {
		super();
		DRIVER = dRIVER;
		CONNECTION_URL = cONNECTION_URL;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;
	}
	
	
	public String getDRIVER() {
		return DRIVER;
	}
	public void setDRIVER(String dRIVER) {
		DRIVER = dRIVER;
	}
	public String getCONNECTION_URL() {
		return CONNECTION_URL;
	}
	public void setCONNECTION_URL(String cONNECTION_URL) {
		CONNECTION_URL = cONNECTION_URL;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}  
	public String getConnectionString(){
		return "";
	}
	@Override
	public String toString() {
		return "DBVariablesProvider [DRIVER=" + DRIVER + ", CONNECTION_URL=" + CONNECTION_URL + ", USERNAME=" + USERNAME
				+ ", PASSWORD=" + PASSWORD + "]";
	}
	


}

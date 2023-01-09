package com.intech.lem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.intech.lem.dao.provider.DBVariablesProvider;

public class DBConnection {

	private static ResourceBundle rsBundle1=ResourceBundle.getBundle("EMApplication");	
	private static String driverName=rsBundle1.getString("DRIVER");
	private static String  strConn = rsBundle1.getString("CONN");
	private static String  strIP = rsBundle1.getString("IP");
	
	private static String  strPort= rsBundle1.getString("PORT");
	private static String  strDBName = rsBundle1.getString("DBNAME");
	private static String  strUsrName = rsBundle1.getString("USRNAME");
	private static String  strPwd = rsBundle1.getString("PWD");
	
	static Connection con=null;



	public  static synchronized Connection getConnection(){
		
		String strConnName = strConn + strIP + strPort +strDBName ;
		
		DBVariablesProvider dbVarProvider = new DBVariablesProvider(driverName,strConnName,strUsrName,strPwd);
		
		try {
			Class.forName(dbVarProvider.getDRIVER());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		
		try {
			con =DriverManager.getConnection(dbVarProvider.getCONNECTION_URL(), dbVarProvider.getUSERNAME(), dbVarProvider.getPASSWORD());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		return con;
	}
}
/*package com.intech.lem.service;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.*;

public class HMAC256TXT{
    public static String hmacDigest(String msg, String keyString, String algo) {
	System.out.println("hashcode KEY:: "+ keyString);
	System.out.println("hashcode Algo:: "+ algo);
    String digest = null;
	//msg=msg+"{5:{PDE:}}";
  
	try {
      SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
      Mac mac = Mac.getInstance(algo);
      mac.init(key);
      byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));
      StringBuffer hash = new StringBuffer();
      for (int i = 0; i < bytes.length; i++) {
        String hex = Integer.toHexString(0xFF & bytes[i]);
        if (hex.length() == 1) {
          hash.append('0');
        }
       hash.append(hex);
      }
      digest = hash.toString();
    } catch (UnsupportedEncodingException e) {
    	e.printStackTrace();
    } catch (InvalidKeyException e) {
    	e.printStackTrace();

    } catch (NoSuchAlgorithmException e) {
    	e.printStackTrace();

    }
    return digest;
  }
 
  public  String AppendHmac(String messageBody,String sBlock){
	 //messageBody=messageBody+"{5:{PDE:}}";
	  messageBody=messageBody+"{S:"+System.getProperty("line.separator")+"{MDG:"+sBlock.toUpperCase()+"}}";
	  return messageBody;
  }
  @SuppressWarnings("unused")
  public  String getFinalLAUmessage(String StrMsg){
	//ResourceBundle rsBundle = ResourceBundle.getBundle("intech.iconnect.OutMessage.OutUtils.IConnect_SFMS_APP");
	String Key1 = "abc";//rsBundle.getString("KEY1");
	String Key2 = "123";//rsBundle.getString("KEY2");
	String Key3=Key1+Key2;
	System.out.println(Key1.length()+Key2.length()+"::KEYS::"+Key1+Key2+"---K3"+Key3.length()+"::"+Key3);    
	String sBlock=hmacDigest(StrMsg,Key3, "HmacSHA256");
	//System.out.println("sBlock"+sBlock); 
	//String finalbody=AppendHmac(StrMsg,sBlock);
	//System.out.println("finalbody ::\n"+finalbody); 
	System.out.println(sBlock);
	Statement objStatement1 = null;
	int objResultSet1;
	Connection objConnection = null;
	return sBlock;
	}
  public static void main(String args){
	  HMAC256TXT obj =  new HMAC256TXT();
	  obj.getFinalLAUmessage("abc0");
  }
}*/
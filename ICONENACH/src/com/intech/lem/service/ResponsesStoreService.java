package com.intech.lem.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.intech.lem.dao.ResponseStoreDao;

public class ResponsesStoreService {
	
	
	public void StoreResponseData(String ResponseString)
	{
		try{
			
	
		String ResponseDetails[]=ResponseString.split("\\|",-1);
		String MandateDetails=ResponseDetails[7].split("mandateData")[1];
	    String MandateDetailsARR[]=MandateDetails.split("\\{")[1].split("\\~");
	    String AckDate=ResponseDetails[8];
	    SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
        java.util.Date date = sdf.parse(AckDate); 
        java.sql.Date sqlDate = new Date(date.getTime());  
	    HashMap<String , String> hash_map = new HashMap<String, String>();
	    hash_map.put("txn_status", ResponseDetails[0]);
	    hash_map.put("txn_msg", ResponseDetails[1]);
	    hash_map.put("txn_err_msg", ResponseDetails[2]);
	    hash_map.put("clnt_txn_ref", ResponseDetails[3]);
	    hash_map.put("tpsl_bank_cd", ResponseDetails[4]);
	    hash_map.put("tpsl_txn_id", ResponseDetails[5]);
	    hash_map.put("txn_amt", ResponseDetails[6]);
	    hash_map.put("transaction_time", ResponseDetails[8]);
	 //   hash_map.put("balance_amt", ResponseDetails[9]);
	    hash_map.put("card_id", ResponseDetails[10]==null?"":ResponseDetails[10]);
	    hash_map.put("alias_name", ResponseDetails[11]==null?"": ResponseDetails[11]);
	    hash_map.put("BankTransactionID", ResponseDetails[12]==null?"": ResponseDetails[12]);
	    hash_map.put("mandate_reg_no", ResponseDetails[13]==null?"": ResponseDetails[13]);
	    hash_map.put("token", ResponseDetails[14]==null?"": ResponseDetails[14]);
	    hash_map.put("hash", ResponseDetails[15]==null?"": ResponseDetails[15]);
	    
	    for(int i=0;i<MandateDetailsARR.length;i++){
	    	
	        String MandateDetailsKeyValueArr[]=MandateDetailsARR[i].split("\\:");
	    	String MandateDetailsKey=MandateDetailsKeyValueArr[0];
	    	String MandateDetailsValue=MandateDetailsKeyValueArr.length>1?MandateDetailsKeyValueArr[1].replaceAll("}", ""):"";
	    	hash_map.put(MandateDetailsKey, MandateDetailsValue);
	    	
	    }
	    
	    ResponseStoreDao ResposeDaoObj= new ResponseStoreDao();
	    ResposeDaoObj.StoreResponseData(hash_map,ResponseString,sqlDate);
	    
	    
		
	}catch(Exception e)
		{
		
		System.out.println(e);
		
		}

		
	}

	
}

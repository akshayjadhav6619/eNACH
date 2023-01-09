package com.intech.lem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.intech.lem.model.EMStructure;

public class SaveMandate {

	
	public static  int save(EMStructure mndtData){
		int i=0;
		try{  
			Connection con = ICONDBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Insert into INT_EMANDATE_DATA_MAS (TRANS_NO,APP_NO,STATUS,LAST_UPDATED,IS_DELETE,END_DATE,START_DATE,LCHG_DATE,DEBIT_TYPE,FREQ,DEST_BANK,DEST_IFSC,AMOUNT,UTILITY_CODE,ACC_TYPE,ACC_NUM,ACC_HOLDER_NAME,CUST_ADDITIONAL_DETAILS,EMAIL,TEL_NUM,MOBILE,CUST_REF,PROD_REF,ORG_REF,PAN_NUM,SID,PWID,HASH_VALUE,MER_REF_NUM) values (INT_SEQ_INW_TEMP_MAS.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		  
				ps.setString(1,mndtData.getApp_no());  
				ps.setString(2,"O");  
				ps.setDate(3,new Date(new java.util.Date().getTime()));  
				ps.setString(4,"N");
				
				
				if(mndtData.getEnd_date()!=null)
					ps.setDate(5,new Date(mndtData.getEnd_date().getTime()));  
				else
					ps.setDate(5,null);  
				
				
				if(mndtData.getStart_date()!=null)
					ps.setDate(6,new Date(mndtData.getStart_date().getTime()));  
				else
					ps.setDate(6,null);  
				
				ps.setDate(7,new Date(new java.util.Date().getTime())); 
				
				
				ps.setString(8,mndtData.getDebit_type());  
				ps.setString(9,mndtData.getFreq());  
				ps.setString(10,mndtData.getDest_bank()); 
				ps.setString(11,mndtData.getDest_ifsc());  
				ps.setString(12,mndtData.getAmount());  
				ps.setString(13,mndtData.getUtility_code()); 
				ps.setString(14,mndtData.getAcc_type());  
				ps.setString(15,mndtData.getAcc_num());  
				ps.setString(16,mndtData.getAcc_holder_name()); 
				ps.setString(17,mndtData.getCust_additional_details());  
				ps.setString(18,mndtData.getEmail());  
				ps.setString(19,mndtData.getTel_num()); 
				ps.setString(20,mndtData.getMobile()); 
				ps.setString(21,""); 
				ps.setString(22,""); 
				ps.setString(23,""); 
				ps.setString(24,mndtData.getPanNumber());
				ps.setString(25,mndtData.getSID());
				ps.setString(26,mndtData.getPwdID());
				ps.setString(27,mndtData.getHashValue());
				ps.setString(28,mndtData.getMer_Ref_Num());
				
				 i=ps.executeUpdate();  
				if(i>0) { 
					System.out.println("inserted successfully...!\n"+i);
					con.commit();
					//out.print("You are successfully registered...");  
				}else{
					System.out.println("insert faillure ..!\n"+i);
					con.rollback();
				}
		          
				}catch (Exception e2) {System.out.println(e2); e2.printStackTrace(System.out);}  

		return i;
	}
	
	
	
	
	public static  int updateStatus(EMStructure mndtData){
		int i=0;
		try{  
			Connection con = ICONDBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Insert into INT_EMANDATE_DATA_MAS (TRANS_NO,APP_NO,STATUS,LAST_UPDATED,IS_DELETE,END_DATE,START_DATE,LCHG_DATE,DEBIT_TYPE,FREQ,DEST_BANK,DEST_IFSC,AMOUNT,UTILITY_CODE,ACC_TYPE,ACC_NUM,ACC_HOLDER_NAME,CUST_ADDITIONAL_DETAILS,EMAIL,TEL_NUM,MOBILE,CUST_REF,PROD_REF,ORG_REF,PAN_NUM,SID,PWID,HASH_VALUE) values (EMNDT_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		  
				ps.setString(1,mndtData.getApp_no());  
				ps.setString(2,"O");  
				ps.setDate(3,new Date(new java.util.Date().getTime()));  
				ps.setString(4,"N");
				
				
				if(mndtData.getEnd_date()!=null)
					ps.setDate(5,new Date(mndtData.getEnd_date().getTime()));  
				else
					ps.setDate(5,null);  
				
				
				if(mndtData.getStart_date()!=null)
					ps.setDate(6,new Date(mndtData.getStart_date().getTime()));  
				else
					ps.setDate(6,null);  
				
				ps.setDate(7,new Date(new java.util.Date().getTime())); 
				
				
				ps.setString(8,mndtData.getDebit_type());  
				ps.setString(9,mndtData.getFreq());  
				ps.setString(10,mndtData.getDest_bank()); 
				ps.setString(11,mndtData.getDest_ifsc());  
				ps.setString(12,mndtData.getAmount());  
				ps.setString(13,mndtData.getUtility_code()); 
				ps.setString(14,mndtData.getAcc_type());  
				ps.setString(15,mndtData.getAcc_num());  
				ps.setString(16,mndtData.getAcc_holder_name()); 
				ps.setString(17,mndtData.getCust_additional_details());  
				ps.setString(18,mndtData.getEmail());  
				ps.setString(19,mndtData.getTel_num()); 
				ps.setString(20,mndtData.getMobile()); 
				ps.setString(21,""); 
				ps.setString(22,""); 
				ps.setString(23,""); 
				ps.setString(24,mndtData.getPanNumber());
				ps.setString(25,mndtData.getSID());
				ps.setString(26,mndtData.getPwdID());

				
				 i=ps.executeUpdate();  
				if(i>0) { 
					System.out.println("inserted successfully...!\n"+i);
					con.commit();
					//out.print("You are successfully registered...");  
				}else{
					System.out.println("insert faillure ..!\n"+i);
					con.rollback();
				}
		          
				}catch (Exception e2) {System.out.println(e2); e2.printStackTrace(System.out);}  

		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test
		EMStructure obj = new EMStructure();
		obj.setApp_no("11111");
		obj.setAcc_num("33444233");
		System.out.println(save(obj));
	}

}

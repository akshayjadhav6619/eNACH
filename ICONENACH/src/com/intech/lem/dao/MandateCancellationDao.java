package com.intech.lem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.intech.lem.model.MandateCancellationModel;

public class MandateCancellationDao {
	
	public String  MandateCancellationSave(MandateCancellationModel  CancellationModelObj){
		
		int i=0;
		try{  
			
			
			Connection con = ICONDBConnection.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps=con.prepareStatement("Insert into INT_Mandate_Cancellation(INT_Trans_No,Int_Account_Name,Int_Loan_AccNumber,Int_UMRNumber,Int_IFSC_Code,Int_Customer_Name,Int_Cancellation_Reason) values (INT_SEQ_INW_TEMP_MAS.NEXTVAL,?,?,?,?,?,?)");
			ps.setString(1,CancellationModelObj.getAccountName());  
			ps.setString(2,CancellationModelObj.getLoanAccNumber());  
			ps.setString(3,CancellationModelObj.getUMRNumber());  
			ps.setString(4,CancellationModelObj.getIFSC_code());
			ps.setString(5,CancellationModelObj.getCustomer_Name());
			ps.setString(6,CancellationModelObj.getCancellationReason());
			i=ps.executeUpdate();
			if(i>0)
			{
				con.commit();
			return "Successfully";
			
			}else {
				
				return "Falied";
			}
			
			
		}catch(Exception e)
		{
			System.out.println(e);
			
		}
		
		return "Falied"	;
	
	
	}

}

package com.intech.lem.service.sms;

import org.json.JSONObject;

public class TestJsonConvert {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String str = "[{\"No\":\"17\",\"Name\":\"Andrew\"},{\"No\":\"18\",\"Name\":\"Peter\"}, {\"No\":\"19\",\"Name\":\"Tom\"}]";  
		JSONObject object = new JSONObject(str);  
		System.out.println(object.getString("No"));  
		System.out.println(object.getString("Name"));  
	}

}

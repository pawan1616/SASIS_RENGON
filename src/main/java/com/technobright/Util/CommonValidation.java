package com.technobright.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.technobright.entities.ErrorMsgTransporter;

public class CommonValidation {
	
	
	
	static{
		System.out.println("..................");
		
	}
	
	
	public static boolean digitLengthValidation(String value,ErrorMsgTransporter errMsgTrans, String filedName,int valLength){
		boolean result=true;
		try{
		result=Pattern.compile("\\d{"+valLength+"}").matcher(value).matches();
		if(!result)
			errMsgTrans.getErrMsg().put(filedName, "It must be "+valLength+" digit no. only");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static boolean passwordValidation(String value,ErrorMsgTransporter errMsgTrans, String filedName){
		boolean result=true;
		try{
		result=value.matches("((?=.*[0-9])(?=.*[a-z])(?=.*[@#$%]).{6,20})");
		if(!result)
			errMsgTrans.getErrMsg().put(filedName, "Password must contain at least one special symbol and one digit and 6 to 20 charcter");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

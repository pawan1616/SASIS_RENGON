package com.technobright.actions;

import com.technobright.entities.ErrorMsgTransporter;

public class ErrorMsgTranportAction {

	private ErrorMsgTransporter errorMsgTransporter;
	
	public ErrorMsgTransporter getErrorMsgTransporter() {
		return errorMsgTransporter;
	}

	public void setErrorMsgTransporter(ErrorMsgTransporter errorMsgTransporter) {
		this.errorMsgTransporter = errorMsgTransporter;
	}

	public String execute(){
		
		return "success";
	}
}

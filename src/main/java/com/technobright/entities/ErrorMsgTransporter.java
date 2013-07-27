package com.technobright.entities;

import java.util.Map;

public class ErrorMsgTransporter {
	private boolean isErrorIn;
	private Map<String, String> errMsg;
	public boolean getIsErrorIn() {
		return isErrorIn;
	}
	public void setIsErrorIn(boolean isErrorIn) {
		this.isErrorIn = isErrorIn;
	}
	public Map<String, String> getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(Map<String, String> errMsg) {
		this.errMsg = errMsg;
	}
	
}

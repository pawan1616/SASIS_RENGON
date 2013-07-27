package com.technobright.actions;

public class MsgTransferHelper {
	private String msgCode;
	private String msgDescription;
	public String getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}
	public String getMsgDescription() {
		return msgDescription;
	}
	public void setMsgDescription(String msgDescription) {
		this.msgDescription = msgDescription;
	}
	public String execute(){
		
		return "success";
	}
}

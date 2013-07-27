package com.technobright.actions;

import com.technobright.dao.DAOInterface;
import com.technobright.entities.UserInfo;

public class AvailabilityCheck {
	private DAOInterface dao;
	private String usrNm;
	private boolean isAvailable;
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String usrNmAvail(){
		UserInfo usrInfo=dao.getUserInfo(usrNm);
		if(usrInfo!=null&&usrInfo.getUserName()!=null&&!usrInfo.getUserName().trim().equals(""))
			isAvailable=false;
		else
			isAvailable=true;
		return "success";
	}
}

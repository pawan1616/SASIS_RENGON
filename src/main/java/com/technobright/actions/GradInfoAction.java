package com.technobright.actions;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.GradInfo;
import com.technobright.entities.InstAdmin;

public class GradInfoAction extends ActionSupport{

	private GradInfo gradInfo;
	private DAOInterface dao;
	private boolean isUpdate;
	private boolean isHistory;
	private List<GradInfo> gradInfoList;
	private long gradInfoId;
	
	public GradInfo getGradInfo() {
		return gradInfo;
	}
	public void setGradInfo(GradInfo gradInfo) {
		this.gradInfo = gradInfo;
	}
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public boolean getIsHistory() {
		return isHistory;
	}
	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}
	public List<GradInfo> getGradInfoList() {
		return gradInfoList;
	}
	public void setGradInfoList(List<GradInfo> gradInfoList) {
		this.gradInfoList = gradInfoList;
	}
	public long getGradInfoId() {
		return gradInfoId;
	}
	public void setGradInfoId(long gradInfoId) {
		this.gradInfoId = gradInfoId;
	}
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		gradInfo.setInstAdmin(instAdmin);
		if(isUpdate)
			dao.updateObject(gradInfo);
		else
			dao.insertObject(gradInfo);
		return SUCCESS;
	}
	public String gradInfoNavigation(){
		isUpdate=false;
		return SUCCESS;
	}
	public String gradInfoSummaryNavigation(){		
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		gradInfoList=dao.getGradList(instAdmin, isHistory);
		return SUCCESS;
	}
	public String gradInfoEditNavigation(){
		isUpdate=true;
		gradInfo=dao.getGradById(gradInfoId);
		return SUCCESS;
	}
}

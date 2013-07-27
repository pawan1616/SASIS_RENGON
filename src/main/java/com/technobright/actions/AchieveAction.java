package com.technobright.actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.Achievement;
import com.technobright.entities.StudentInfo;

public class AchieveAction extends ActionSupport{

	private DAOInterface dao;
	private StudentInfo stdInfo;
	private Achievement achieve;
	private boolean isEdit;
	private boolean isUpdate;
	private int objId;
	private List<Achievement> achieveList;
	
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public StudentInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StudentInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	public Achievement getAchieve() {
		return achieve;
	}
	public void setAchieve(Achievement achieve) {
		this.achieve = achieve;
	}
	
	public boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	public List<Achievement> getAchieveList() {
		return achieveList;
	}
	public void setAchieveList(List<Achievement> achieveList) {
		this.achieveList = achieveList;
	}
	public boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public int getObjId() {
		return objId;
	}
	public void setObjId(int objId) {
		this.objId = objId;
	}
	public String achieveEditNavigation(){
		isEdit=true;
		isUpdate=false;
		Map session = ActionContext.getContext().getSession();
		StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
		achieveList=dao.getAchievementList(stdInfo);
		return SUCCESS;
	}
	public String profileAchieveNavigation(){
		isEdit=false;
		isUpdate=false;
		Map session = ActionContext.getContext().getSession();
		StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
		achieveList=dao.getAchievementList(stdInfo);
		return SUCCESS;
	}
	public String achieveSubmission(){
		try {
			Map session = ActionContext.getContext().getSession();
			StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
			achieve.setStdInfo(stdInfo);
			achieve.setModifiedDate(new Date());
			dao.insertObject(achieve);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String achieveUpdate(){
		try {
			dao.updateObject(achieve);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String getUpdatableAchieve(){
		isEdit=true;
		isUpdate=true;
		for(Achievement achieve: achieveList){
			if(achieve.getAchieveId()==objId)
				this.achieve=achieve;
		}
		return SUCCESS;
	}
}

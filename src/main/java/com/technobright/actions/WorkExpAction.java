package com.technobright.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.StdWorkExp;
import com.technobright.entities.StudentInfo;

public class WorkExpAction extends ActionSupport implements ServletRequestAware{
	private DAOInterface dao;
	private StudentInfo stdInfo;
	private StdWorkExp stdWorkExp;
	private boolean isUpdate;
	private boolean isEdit;
	private int objId;
	private HttpServletRequest request;
	private List<StdWorkExp> stdWorkExpList;
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
	
	public StdWorkExp getStdWorkExp() {
		return stdWorkExp;
	}
	public boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public boolean getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	public int getObjId() {
		return objId;
	}
	public void setObjId(int objId) {
		this.objId = objId;
	}
	public void setStdWorkExp(StdWorkExp stdWorkExp) {
		this.stdWorkExp = stdWorkExp;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	public List<StdWorkExp> getStdWorkExpList() {
		return stdWorkExpList;
	}
	public void setStdWorkExpList(List<StdWorkExp> stdWorkExpList) {
		this.stdWorkExpList = stdWorkExpList;
	}
	public String workExperienceNavigation(){
		isUpdate=false;
		stdInfo=(StudentInfo)request.getSession(false).getAttribute("StudentInfo");
		stdWorkExpList=dao.getStdWorkExpList(stdInfo);
		return SUCCESS;
	}
	public String workExperienceEditNavigation(){
		isUpdate=true;
		isEdit=false;
		stdInfo=(StudentInfo)request.getSession(false).getAttribute("StudentInfo");
		stdWorkExpList=dao.getStdWorkExpList(stdInfo);
		stdWorkExp=new StdWorkExp();
		return SUCCESS;
	}
	public String addWorkExp(){
		try {
			System.out.println(stdWorkExp.getIsCurrentOrg()+"****F*F*****D***S*DF**SD*F*D*F*SD*F*S*DF");
			stdWorkExp.setStdInfo(stdInfo);
			if(stdWorkExp.getIsCurrentOrg())
				dao.updateCurrWorkExpFalse(stdWorkExp);
			dao.insertObject(stdWorkExp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String getUpdatableWorkExp(){
		isUpdate=true;
		isEdit=true;
		for(StdWorkExp stdWorkExp:stdWorkExpList){
			if(stdWorkExp.getWorkExpId()==objId)
				this.stdWorkExp=stdWorkExp;
		}
		
		return SUCCESS;
	}
	public String updateWorkExp(){
		try {
			if(stdWorkExp.getIsCurrentOrg())
				dao.updateCurrWorkExpFalse(stdWorkExp);
			dao.updateObject(stdWorkExp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}

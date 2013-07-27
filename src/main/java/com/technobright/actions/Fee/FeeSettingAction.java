package com.technobright.actions.Fee;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.Other;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOFeeInterface;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.InstSessionInfo;
import com.technobright.entities.StudentInfo;
import com.technobright.entities.fee.FeeType;
import com.technobright.entities.fee.Installments;
import com.technobright.entities.fee.LateFee;
import com.technobright.entities.fee.OtherFee;
import com.technobright.entities.fee.Scholarship;
import com.technobright.entities.fee.TotalCourseFee;

public class FeeSettingAction extends ActionSupport{
	
	private DAOInterface dao;
	private DAOFeeInterface daoFee;
	private TotalCourseFee totalCourseFee;
	private Scholarship scholShip;
	private LateFee lateFee;
	private OtherFee otherFee;
	private long courseId;
	private List<Long> stdIdList;
	private long batchId;
	private long sessId;
	private int feeTypeId;
	private int noOfInstallment;
	private List<FeeType> feeTypeList;
	private List<CourseInfo> courseInfoList;
	private Map<String, Double> installmentsDisplayMap;
	private List<String> installmentsSaveList;
	private List<Long> selectedInstallments;
	private List<Installments> installList;
	
	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public DAOFeeInterface getDaoFee() {
		return daoFee;
	}
	public void setDaoFee(DAOFeeInterface daoFee) {
		this.daoFee = daoFee;
	}
	public TotalCourseFee getTotalCourseFee() {
		return totalCourseFee;
	}
	public void setTotalCourseFee(TotalCourseFee totalCourseFee) {
		this.totalCourseFee = totalCourseFee;
	}
	public Scholarship getScholShip() {
		return scholShip;
	}
	public void setScholShip(Scholarship scholShip) {
		this.scholShip = scholShip;
	}
	public LateFee getLateFee() {
		return lateFee;
	}
	public void setLateFee(LateFee lateFee) {
		this.lateFee = lateFee;
	}
	public OtherFee getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(OtherFee otherFee) {
		this.otherFee = otherFee;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public List<Long> getStdIdList() {
		return stdIdList;
	}
	public void setStdId(List<Long> stdIdList) {
		this.stdIdList = stdIdList;
	}
	public long getBatchId() {
		return batchId;
	}
	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}
	public long getSessId() {
		return sessId;
	}
	public void setSessId(long sessId) {
		this.sessId = sessId;
	}
	public int getFeeTypeId() {
		return feeTypeId;
	}
	public void setFeeTypeId(int feeTypeId) {
		this.feeTypeId = feeTypeId;
	}
	public int getNoOfInstallment() {
		return noOfInstallment;
	}
	public void setNoOfInstallment(int noOfInstallment) {
		this.noOfInstallment = noOfInstallment;
	}
	public List<FeeType> getFeeTypeList() {
		return feeTypeList;
	}
	public void setFeeTypeList(List<FeeType> feeTypeList) {
		this.feeTypeList = feeTypeList;
	}
	public List<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}
	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}
	public Map<String, Double> getInstallmentsDisplayMap() {
		return installmentsDisplayMap;
	}
	public void setInstallmentsDisplayMap(Map<String, Double> installmentsDisplayMap) {
		this.installmentsDisplayMap = installmentsDisplayMap;
	}
	public List<String> getInstallmentsSaveList() {
		return installmentsSaveList;
	}
	public void setInstallmentsSaveList(List<String> installmentsSaveList) {
		this.installmentsSaveList = installmentsSaveList;
	}
	public List<Long> getSelectedInstallments() {
		return selectedInstallments;
	}
	public void setSelectedInstallments(List<Long> selectedInstallments) {
		this.selectedInstallments = selectedInstallments;
	}
	public List<Installments> getInstallList() {
		return installList;
	}
	public void setInstallList(List<Installments> installList) {
		this.installList = installList;
	}
	public String execute(){
		return SUCCESS;
	}
	public String feeSettingNavigation(){
		feeTypeList=daoFee.feeType();
		return SUCCESS;
	}
	public String feeNavigation(){
		return SUCCESS;
	}
	public String totalCourseFeeNavigation(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		courseInfoList=dao.getCourses(instAdmin, false);
		return SUCCESS;
	}
	public String feeSettingOptionNavigation(){
		String returnStr=""; 
		switch (feeTypeId) {
		case 1:
			returnStr="totalCourseFee";
			break;
		case 2:
			returnStr=prerequisiteInstallments();
			break;
		case 3:
			returnStr="lateFee";
			break;
		case 4:
			stdIdList=new ArrayList<Long>();
			returnStr="scholarship";
			break;
		case 5:
			returnStr="otherAccesories";
			break;
		}
		return returnStr;
	}
	public String createLateFee(){
		CourseInfo crsInfo=dao.getCourse(courseId);
		lateFee.setCourseInfo(crsInfo);
		FeeType localFeeType=daoFee.getFeeTypeById(feeTypeId);
		lateFee.setFeeType(localFeeType);
		daoFee.insertObject(lateFee);
		return SUCCESS;
	}
	
	public String createTotalFee(){
//		System.out.println("...hoi gol.."+totalCourseFee.getAmnt());
		CourseInfo crsInfo=dao.getCourse(courseId);
		totalCourseFee.setCourseInfo(crsInfo);
		FeeType localFeeType=daoFee.getFeeTypeById(feeTypeId);
		totalCourseFee.setFeeType(localFeeType);
		List<Object> transObjList=new ArrayList<Object>();
		transObjList.add(crsInfo);
		daoFee.insertObject(totalCourseFee);
		return SUCCESS;
	}
	private String prerequisiteInstallments(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		courseInfoList=dao.getCourses(instAdmin, false);
		courseId=courseInfoList.get(0).getCourseId();
		noOfInstallment=12;
		return createInstallments();
	}
	public String changeCourseInstallment(){
		noOfInstallment=12;
		return createInstallments();
	}
	public String createInstallments(){
		CourseInfo crsInfo=dao.getCourse(courseId);
		totalCourseFee=daoFee.getActiveTotalFee(crsInfo);
		Double eachAmount=0.0;
		if(totalCourseFee!=null)
			eachAmount=totalCourseFee.getAmnt()/noOfInstallment;
		installmentsDisplayMap=new LinkedHashMap<String, Double>();
		for (int i = 0; i <noOfInstallment; i++) {
			installmentsDisplayMap.put((1+i)+"/11/"+"/13",eachAmount);
		}
		return "installments";
	}
	public String saveInstallment(){
		List<Installments> installmentList=new ArrayList<Installments>();
		CourseInfo crsInfo=dao.getCourse(courseId);
		FeeType feeType=daoFee.getFeeTypeById(2);
		for(String installStr:installmentsSaveList){
			String [] installNDate=installStr.split("~");
			Installments install=new Installments();
			install.setAmnt(Double.parseDouble(installNDate[0]));
			install.setCourseInfo(crsInfo);
			install.setFeeType(feeType);
			install.setDueDate(new Date(Date.parse(installNDate[1])));
			installmentList.add(install);
		}
		daoFee.insertInstallments(installmentList);
		return "installments";
	}
	public String createScholarship(){
		CourseInfo crsInfo=dao.getCourse(courseId);
		InstSessionInfo sessInfo=dao.getInstSessionById(sessId);
		BatchInfo batchInfo=dao.getBatchinfoById(batchId);
		scholShip.setBatchInfo(batchInfo);
		scholShip.setCourseInfo(crsInfo);
		scholShip.setInstSession(sessInfo);
		for(long stdIdLcl:stdIdList){
			StudentInfo stdInfo=dao.getStdInfoById(stdIdLcl);
			scholShip.setStdInfo(stdInfo);
			daoFee.insertObject(scholShip);
		}
		return "scholarship";
	}
	
	public String getInstallmentFromCourse(){
		CourseInfo crsInfo=dao.getCourse(courseId);
		installList=daoFee.getCourseInstallments(crsInfo, false);
		for(Installments install:installList){
			install.setCourseInfo(null);
			install.setFeeType(null);
		}
		return SUCCESS;
	}
	
	public String createOtherAccessories(){
		
		return "otherAccesories";
	}
}

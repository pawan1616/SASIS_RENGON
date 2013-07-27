package com.technobright.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.ExamType;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.SubjectInfo;

public class ExamTypeAction extends ActionSupport{
	private ExamType examType;
	private List subjectList;
	private List fetchedAllSubjects;
	private List fetchedAllExamTypes;
	private List<SubjectInfo> selExmTypSubjects;
	private Integer headerKey;
	private DAOInterface dao;
	private int updateExamTypeId;
	private boolean editable;
	private boolean isHistory;
	
	public ExamType getExamType() {
		return examType;
	}

	public void setExamType(ExamType examType) {
		this.examType = examType;
	}
	/*public Date getIntroYear() {
		return introYear;
	}

	public void setIntroYear(Date introYear) {
		this.introYear = !introYear.trim().equalsIgnoreCase("")?Integer.parseInt(introYear):0;
		examType.setIntroducedYear(this.introYear);
	}

	public int getModifiedYear() {
		return modifiedYear;
	}

	public void setModifiedYear(String modifiedYear) {
		this.modifiedYear = !modifiedYear.trim().equalsIgnoreCase("")?Integer.parseInt(modifiedYear):0;
		examType.setModifiedYear(this.modifiedYear);
	}*/

	public List getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List subjectList) {
		this.subjectList = subjectList;
	}

	public List getFetchedAllSubjects() {
		return fetchedAllSubjects;
	}

	public void setFetchedAllSubjects(List fetchedAllSubjects) {
		this.fetchedAllSubjects = fetchedAllSubjects;
	}

	public Integer getHeaderKey() {
		return headerKey;
	}

	public void setHeaderKey(Integer headerKey) {
		this.headerKey = headerKey;
	}

	public List getFetchedAllExamTypes() {
		return fetchedAllExamTypes;
	}

	public void setFetchedAllExamTypes(List fetchedAllExamTypes) {
		this.fetchedAllExamTypes = fetchedAllExamTypes;
	}

	public List<SubjectInfo> getSelExmTypSubjects() {
		return selExmTypSubjects;
	}

	public void setSelExmTypSubjects(List<SubjectInfo> selExmTypSubjects) {
		this.selExmTypSubjects = selExmTypSubjects;
	}

	public DAOInterface getDao() {
		return dao;
	}

	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}

	public int getUpdateExamTypeId() {
		return updateExamTypeId;
	}

	public void setUpdateExamTypeId(int updateExamTypeId) {
		this.updateExamTypeId = updateExamTypeId;
	}

	public boolean getEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
	public boolean getIsHistory() {
		return isHistory;
	}

	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}

	public String execute(){
		if(!editable)
			examType.setExamTypeId(0);
		examType.setSubjectList(new ArrayList<SubjectInfo>());
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		try{
		fetchedAllSubjects=dao.getAllSubjects(instAdmin);
		
		if(subjectList.get(0)!=null&&!((String)subjectList.get(0)).equalsIgnoreCase("")&&Integer.parseInt((String)subjectList.get(0))!=-1){
			for (int subI = 0; subI < subjectList.size(); subI++) {
				for (int i = 0; i < fetchedAllSubjects.size(); i++) {
					if(!subjectList.get(subI).equals("")
							&&Integer.parseInt((String)subjectList.get(subI))==((SubjectInfo)fetchedAllSubjects.get(i)).getSubjectId()
							&&!examType.getSubjectList().contains(fetchedAllSubjects.get(i))){
						examType.getSubjectList().add((SubjectInfo)fetchedAllSubjects.get(i));
						
					}
				}
			}
		}else if(subjectList.get(0)!=null&&!((String)subjectList.get(0)).equalsIgnoreCase("")&&Integer.parseInt((String)subjectList.get(0))==-1){
			for (int i = 0; i < fetchedAllSubjects.size(); i++) {
				if(!examType.getSubjectList().contains(fetchedAllSubjects.get(i)))
					examType.getSubjectList().add((SubjectInfo)fetchedAllSubjects.get(i));
			}
		}
		examType.setInstAdmin(instAdmin);
		if(editable)
			dao.updateObject(examType);
		else
			dao.insertObject(examType);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	public String examTypeSummaryNavigation(){
		editable=false;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		fetchedAllExamTypes=dao.getExamTypes(instAdmin,isHistory);
		fetchedAllSubjects=dao.getAllSubjects(instAdmin);
		return SUCCESS;
	}
	public String fetchSubjcts(){
		editable=false;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		fetchedAllSubjects=dao.getAllSubjects(instAdmin);
		fetchedAllExamTypes=dao.getExamTypes(instAdmin,false);
		return SUCCESS;
	}
	public String updateExamtype(){
		execute();
		editable=false;
		return SUCCESS;
	}
	public String updateExmTypeNavigation(){
		editable=true;
		examType=dao.getExamType(updateExamTypeId);
		selExmTypSubjects=examType.getSubjectList();
		return SUCCESS;
	}
}

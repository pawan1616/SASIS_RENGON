package com.technobright.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.ExamType;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.StudentInfo;
import com.technobright.entities.SubjectInfo;

public class CourseCreateAction extends ActionSupport implements ServletRequestAware{
	private CourseInfo courseInfo;
	private List fetchedAllSubjects;
	private List<SubjectInfo> selectedFetchedSubs;
	private List subjectList;
	private List fetchedAllExamType;
	private List examTypeList;
	private List<ExamType> selectedExmTypes;
	private List fetchedAllCourse;
	private Integer nextCourse;
	private Integer previousCourse;
	private DAOInterface dao;
	private String btnPressed;
	private String updateCourseId;	
	private HttpServletRequest request; 
	private boolean isUpdate;
	private List<CourseInfo> crsInfoList;
	private int crsInfoId;
	private List<StudentInfo> stdInfoList;
	private List<Integer> stdInfoIds;
	private BatchInfo batchInfo;
	private List<BatchInfo> batchInfoList;
	private long btchInfoId;
	private boolean isHistory;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	public List getFetchedAllSubjects() {
		return fetchedAllSubjects;
	}

	public void setFetchedAllSubjects(List fetchedAllSubjects) {
		this.fetchedAllSubjects = fetchedAllSubjects;
	}

	public List<SubjectInfo> getSelectedFetchedSubs() {
		return selectedFetchedSubs;
	}

	public void setSelectedFetchedSubs(List<SubjectInfo> selectedFetchedSubs) {
		this.selectedFetchedSubs = selectedFetchedSubs;
	}

	public List getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List subjectList) {
		this.subjectList = subjectList;
	}

	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	public List getFetchedAllExamType() {
		return fetchedAllExamType;
	}

	public void setFetchedAllExamType(List fetchedAllExamType) {
		this.fetchedAllExamType = fetchedAllExamType;
	}

	public List getExamTypeList() {
		return examTypeList;
	}

	public void setExamTypeList(List examTypeList) {
		this.examTypeList = examTypeList;
	}

	public List<ExamType> getSelectedExmTypes() {
		return selectedExmTypes;
	}

	public void setSelectedExmTypes(List<ExamType> selectedExmTypes) {
		this.selectedExmTypes = selectedExmTypes;
	}

	public List getFetchedAllCourse() {
		return fetchedAllCourse;
	}

	public void setFetchedAllCourse(List fetchedAllCourse) {
		this.fetchedAllCourse = fetchedAllCourse;
	}

	public Integer getNextCourse() {
		return nextCourse;
	}

	public void setNextCourse(Integer nextCourse) {
		this.nextCourse = nextCourse;
	}

	public Integer getPreviousCourse() {
		return previousCourse;
	}

	public void setPreviousCourse(Integer previousCourse) {
		this.previousCourse = previousCourse;
	}

	public DAOInterface getDao() {
		return dao;
	}

	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}

	public String getBtnPressed() {
		return btnPressed;
	}

	public void setBtnPressed(String btnPressed) {
		this.btnPressed = btnPressed;
	}

	public String getUpdateCourseId() {
		return updateCourseId;
	}

	public void setUpdateCourseId(String updateCourseId) {
		this.updateCourseId = updateCourseId;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public List<CourseInfo> getCrsInfoList() {
		return crsInfoList;
	}

	public void setCrsInfoList(List<CourseInfo> crsInfoList) {
		this.crsInfoList = crsInfoList;
	}

	public int getCrsInfoId() {
		return crsInfoId;
	}

	public void setCrsInfoId(int crsInfoId) {
		this.crsInfoId = crsInfoId;
	}

	public List<StudentInfo> getStdInfoList() {

		return stdInfoList;
	}

	public void setStdInfoList(List<StudentInfo> stdInfoList) {
		this.stdInfoList = stdInfoList;
	}

	public List<Integer> getStdInfoIds() {
		return stdInfoIds;
	}

	public void setStdInfoIds(List<Integer> stdInfoIds) {
		this.stdInfoIds = stdInfoIds;
	}

	public BatchInfo getBatchInfo() {
		return batchInfo;
	}

	public void setBatchInfo(BatchInfo batchInfo) {
		this.batchInfo = batchInfo;
	}

	public List<BatchInfo> getBatchInfoList() {
		return batchInfoList;
	}

	public void setBatchInfoList(List<BatchInfo> batchInfoList) {
		this.batchInfoList = batchInfoList;
	}

	public long getBtchInfoId() {
		return btchInfoId;
	}

	public void setBtchInfoId(long btchInfoId) {
		this.btchInfoId = btchInfoId;
	}

	public boolean getIsHistory() {
		return isHistory;
	}

	public void setIsHistory(boolean isHistory) {
		this.isHistory = isHistory;
	}

	public String execute(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		if(btnPressed.trim().equalsIgnoreCase("Delete")){
			dao.deleteThisCourse(courseInfo);
			fetchedAllCourse=dao.getCourses(instAdmin,false);
			return SUCCESS;
		}

		fetchedAllCourse=dao.getCourses(instAdmin,false);
		fetchedAllExamType=dao.getExamTypes(instAdmin,false);
		fetchedAllSubjects=dao.getAllSubjects(instAdmin);
		try{
			courseInfo.setSubjectList(new ArrayList<SubjectInfo>());
			courseInfo.setExamTypeList(new ArrayList<ExamType>());
			if(!subjectList.get(0).toString().trim().equals("")&&Integer.parseInt((String)subjectList.get(0))!=-1){
				for (int subI = 0; subI < subjectList.size(); subI++) {
					for (int i = 0; i < fetchedAllSubjects.size(); i++) {
						if(subjectList.get(subI)!=null&&!subjectList.get(subI).toString().trim().equals("")
								&&Integer.parseInt((String)subjectList.get(subI))==((SubjectInfo)fetchedAllSubjects.get(i)).getSubjectId()){
							System.out.println(courseInfo.getSubjectList().contains((SubjectInfo)fetchedAllSubjects.get(i))+"......");
							courseInfo.getSubjectList().add((SubjectInfo)fetchedAllSubjects.get(i));
						}
					}
				}
			}else{
				if(btnPressed.trim().equalsIgnoreCase("Create"))
					for (int i = 0; i < fetchedAllSubjects.size(); i++) {
						if(!courseInfo.getSubjectList().contains(fetchedAllSubjects.get(i)))
							courseInfo.getSubjectList().add((SubjectInfo)fetchedAllSubjects.get(i));
					}
			}
			if(!examTypeList.get(0).toString().trim().equals("")&&Integer.parseInt((String)examTypeList.get(0))!=-1){
				for (int subI = 0; subI < examTypeList.size(); subI++) {
					for (int i = 0; i < fetchedAllExamType.size(); i++) {
						System.out.println((ExamType)fetchedAllExamType.get(i)+"..........");
						if(examTypeList.get(subI)!=null&&!examTypeList.get(subI).toString().trim().equals("")
								&&Integer.parseInt((String)examTypeList.get(subI))==((ExamType)fetchedAllExamType.get(i)).getExamTypeId()
								&&!courseInfo.getExamTypeList().contains(fetchedAllExamType.get(i))){
							courseInfo.getExamTypeList().add((ExamType)fetchedAllExamType.get(i));
						}
					}
				}
			}else{
				if(btnPressed.trim().equalsIgnoreCase("Create"))
					for (int i = 0; i < fetchedAllExamType.size(); i++) {
						if(!courseInfo.getExamTypeList().contains(fetchedAllExamType.get(i)))
							courseInfo.getExamTypeList().add((ExamType)fetchedAllExamType.get(i));
					}
			}
			System.out.println(nextCourse+"..........ooooooooooo");
				if(nextCourse>0&&!fetchedAllCourse.isEmpty())
					for (int i = 0; i < fetchedAllCourse.size(); i++) {
						if(nextCourse==((CourseInfo)fetchedAllCourse.get(i)).getCourseId()){
							courseInfo.setNextCourse((CourseInfo)fetchedAllCourse.get(i));
							break;
						}
					}
				if(previousCourse>0&&!fetchedAllCourse.isEmpty())
					for (int i = 0; i < fetchedAllCourse.size(); i++) {
						if(previousCourse==((CourseInfo)fetchedAllCourse.get(i)).getCourseId()){
							courseInfo.setPreviousCourse((CourseInfo)fetchedAllCourse.get(i));
							break;
						}
					}
			courseInfo.setInstAdmin(instAdmin);
			if(btnPressed.trim().equalsIgnoreCase("Create"))
				dao.insertObject(courseInfo);
			if(btnPressed.trim().equalsIgnoreCase("Update"))
				dao.updateCourseInfo(courseInfo);
			courseNavigation();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String courseNavigation(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		isUpdate=false;
		courseInfo=new CourseInfo();
		subjectList =new ArrayList();
		examTypeList=new ArrayList();
		nextCourse=0;
		previousCourse=0;
		btnPressed="";
		updateCourseId="";		
		courseInfo.setSubjectList(new ArrayList<SubjectInfo>());
		courseInfo.setExamTypeList(new ArrayList<ExamType>());
		fetchedAllSubjects=dao.getAllSubjects(instAdmin);
		fetchedAllExamType=dao.getExamTypes(instAdmin,false);
		fetchedAllCourse=dao.getCourses(instAdmin,false);
		return SUCCESS;
	}
	public String courseSummaryNavigation(){
		isUpdate=false;
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		fetchedAllCourse=dao.getCourses(instAdmin,isHistory);
		return SUCCESS;
	}

	public String showUpdateCourse(){
		try {
			isUpdate=true;
			Map session = ActionContext.getContext().getSession();
			InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
			courseInfo=dao.getCourse(Integer.parseInt(updateCourseId));
			selectedFetchedSubs=courseInfo.getSubjectList();
			selectedExmTypes=courseInfo.getExamTypeList();
			fetchedAllSubjects=dao.getAllSubjects(instAdmin);
			fetchedAllExamType=dao.getExamTypes(instAdmin,false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
	public String deleteCourse(){
		try{
			Map session = ActionContext.getContext().getSession();
			InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
			dao.deleteCourse();
			fetchedAllCourse=dao.getCourses(instAdmin,false);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String showUpdateAjax(){
		try{
			System.out.println("Ajax calling...........");
			showUpdateCourse();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
/*	public String batchNavigation(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		crsInfoList=dao.getActiveCourses(instAdmin);
		return SUCCESS;
	}*/
	public String fetchStdFromCourse(){
		try{
		for(CourseInfo crsInfo:crsInfoList){
			if(crsInfoId==crsInfo.getCourseId()){
				stdInfoList=dao.getActiveStdInfoList(crsInfo);
				ArrayList<StudentInfo> delStdInfoList=new ArrayList<StudentInfo>();
				for(StudentInfo stdInfoDel:stdInfoList){
					if(stdInfoDel.getBatch_StdInfoList().size()!=0)
						delStdInfoList.add(stdInfoDel);
				}
				for(StudentInfo delStdInfo:delStdInfoList)
					stdInfoList.remove(delStdInfo);
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/*public String batchSummmaryNavigation(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		batchInfoList=dao.getActiveBatchList(instAdmin);
		return SUCCESS;
	}*/
	/*public String createBatch(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		Batch_StdInfo btch_std=new Batch_StdInfo();
		btch_std.setIsActive(true);
		try{
		for(CourseInfo crsInfo:crsInfoList){
			if(crsInfoId==crsInfo.getCourseId())
				batchInfo.setCourseInfo(crsInfo);
		}
		btch_std.setBatchInfo(batchInfo);
		batchInfo.setInstAdmin(instAdmin);
		dao.insertObject(batchInfo);
		if(!stdInfoIds.isEmpty()){
		for(Integer id:stdInfoIds){
			for(StudentInfo stdInfo:stdInfoList){
				if(stdInfo.getStdId()==id&&stdInfo.getBatch_StdInfoList().size()==0){
					btch_std.setStudentInfo(stdInfo);
					dao.insertObject(btch_std);
				}
			}
		}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}*/

/*	public String fetchStdFromBtch(){
		
		try{
			for(BatchInfo btchInfo:batchInfoList){
				if(btchInfo.getBatchId()==btchInfoId){
					stdInfoList=dao.getActiveStdFrmBtch(btchInfo);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String batchEditNavigation(){
		
		return SUCCESS;
	}*/
}

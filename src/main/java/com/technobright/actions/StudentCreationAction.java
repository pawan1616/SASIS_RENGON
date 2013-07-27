package com.technobright.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.Batch_StdInfo;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.Course_StdInfo;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.InstAdmin_StdInfo;
import com.technobright.entities.StudentInfo;
import com.technobright.entities.UserInfo;

public class StudentCreationAction extends ActionSupport implements ServletRequestAware{

	private DAOInterface dao; 
	private StudentInfo stdInfo;
	private List<CourseInfo> courseInfoList;
	private List<StudentInfo> stdInfoList;
	private int courseInfoId;
	private long btchInfoId;
	private int instAdminId;
	private boolean isUpdate;
	private boolean isSearched;
	private String searchInput;
	private String viewType;
	private String userUID;
	private HttpServletRequest request;
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

	public List<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}

	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}

	public List<StudentInfo> getStdInfoList() {
		return stdInfoList;
	}

	public void setStdInfoList(List<StudentInfo> stdInfoList) {
		this.stdInfoList = stdInfoList;
	}

	public int getCourseInfoId() {
		return courseInfoId;
	}

	public void setCourseInfoId(int courseInfoId) {
		this.courseInfoId = courseInfoId;
	}

	public long getBtchInfoId() {
		return btchInfoId;
	}

	public void setBtchInfoId(long btchInfoId) {
		this.btchInfoId = btchInfoId;
	}

	public int getInstAdminId() {
		return instAdminId;
	}

	public void setInstAdminId(int instAdminId) {
		this.instAdminId = instAdminId;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public boolean getIsSearched() {
		return isSearched;
	}

	public void setIsSearched(boolean isSearched) {
		this.isSearched = isSearched;
	}

	public String getSearchInput() {
		return searchInput;
	}

	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getUserUID() {
		return userUID;
	}

	public void setUserUID(String userUID) {
		this.userUID = userUID;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;

	}
	public String execute(){
		if(isSearched){
			Map session = ActionContext.getContext().getSession();
			InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
			this.courseInfoList=dao.getCourses(instAdmin, false);
			Course_StdInfo crsStdInfo=new Course_StdInfo();
			Batch_StdInfo btchStdInfo=new Batch_StdInfo();
			InstAdmin_StdInfo stdInstAdmin=new InstAdmin_StdInfo();
			crsStdInfo.setIsActive(true);
			btchStdInfo.setIsActive(true);
			stdInstAdmin.setIsActive(true);
			if(courseInfoList!=null&&!courseInfoList.isEmpty()){
				for(CourseInfo crsInfo:courseInfoList){
					if(crsInfo.getCourseId()==courseInfoId){
						crsStdInfo.setCourseInfo(crsInfo);
					}
				}
			}
			
			
			crsStdInfo.setStdInfo(stdInfo);
			stdInstAdmin.setInstAdmin(instAdmin);
			stdInstAdmin.setStdInfo(stdInfo);
			stdInfo.getCourse_StdInfoList().add(crsStdInfo);
			stdInfo.getBatch_StdInfoList().add(btchStdInfo);
			stdInfo.getInstAdminList().add(stdInstAdmin);
			dao.updateObject(stdInfo);
			dao.insertObject(crsStdInfo);
			dao.insertObject(stdInstAdmin);
			if(btchInfoId!=-1){
				btchStdInfo.setBatchInfo(dao.getBatchinfoById(btchInfoId));
				btchStdInfo.setStudentInfo(stdInfo);
				dao.insertObject(btchStdInfo);
			}
		}else{
			try {
				Map session = ActionContext.getContext().getSession();
				InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
				this.courseInfoList=dao.getCourses(instAdmin, false);
				UserInfo usrInfo=new UserInfo();
				usrInfo.setFirstName(stdInfo.getFirstName());
				usrInfo.setLastName(stdInfo.getLastName());
				usrInfo.setInitials(stdInfo.getInitials());
				usrInfo.setUserType("Student");
				usrInfo.setPassword("password");
				dao.insertObject(usrInfo);
				//			usrInfo=dao.getUserInfo(usrInfo.getUserName());
				Course_StdInfo crsStdInfo=new Course_StdInfo();
				Batch_StdInfo btchStdInfo=new Batch_StdInfo();
				InstAdmin_StdInfo stdInstAdmin=new InstAdmin_StdInfo();
				crsStdInfo.setIsActive(true);
				btchStdInfo.setIsActive(true);
				stdInstAdmin.setIsActive(true);
				if(courseInfoList!=null&&!courseInfoList.isEmpty()){
					for(CourseInfo crsInfo:courseInfoList){
						if(crsInfo.getCourseId()==courseInfoId){
							crsStdInfo.setCourseInfo(crsInfo);
						}
					}
				}
				btchStdInfo.setBatchInfo(dao.getBatchinfoById(btchInfoId));
				stdInfo.setCourse_StdInfoList(new ArrayList<Course_StdInfo>());
				stdInfo.getCourse_StdInfoList().add(crsStdInfo);
				stdInfo.setBatch_StdInfoList(new ArrayList<Batch_StdInfo>());
				stdInfo.getBatch_StdInfoList().add(btchStdInfo);
				stdInfo.setUserInfo(usrInfo);
				stdInfo.getInstAdminList().add(stdInstAdmin);
				crsStdInfo.setStdInfo(stdInfo);
				stdInstAdmin.setInstAdmin(instAdmin);
				stdInstAdmin.setStdInfo(stdInfo);
				dao.insertObject(stdInfo);
				dao.insertObject(crsStdInfo);
				dao.insertObject(stdInstAdmin);
				if(btchInfoId!=-1){
					btchStdInfo.setStudentInfo(stdInfo);
					dao.insertObject(btchStdInfo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	public String basicInfoNavigation(){
		isUpdate=false;
		isSearched=false;
		try{
			Map session = ActionContext.getContext().getSession();
			InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
			courseInfoList=dao.getCourses(instAdmin,false);
			btchInfoId=-1;
			courseInfoId=-1;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String getCoursesFromInst(){
		try {
			Map session = ActionContext.getContext().getSession();
			StudentInfo stdInfo=(StudentInfo) session.get("StudentInfo");
			if(stdInfo==null){
//				UserInfo usrInfo=dao.getUserInfo(userUID);
				stdInfo=dao.getStdInfoByUsr(dao.getUserInfo(userUID));
			}
			InstAdmin instAdmin=dao.getInstAdminById(instAdminId);
			this.courseInfoList=dao.getCourseInfosFromInst(instAdmin,stdInfo);
			for(CourseInfo crsInfo:courseInfoList){
				crsInfo.setBatchInfoList(null);
				crsInfo.setExamInfoList(null);
				crsInfo.setExamTypeList(null);
				crsInfo.setInstAdmin(null);
				crsInfo.setSubjectList(null);
				crsInfo.setNextCourse(null);
				crsInfo.setPreviousCourse(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
	public String updateStdRecordNavigation(){
		isUpdate=true;
		isSearched=false;
		stdInfo=(StudentInfo)request.getSession(false).getAttribute("StudentInfo");
		return SUCCESS;
	}

	public String updateStdRecord(){
		try {
			dao.updateObject(stdInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String searchStudent(){
		UserInfo usrInfo=dao.getUserInfo(searchInput.trim());
		if(usrInfo!=null&&usrInfo.getUserUID()>0){
			isUpdate=true;
			isSearched=true;
			stdInfo=dao.getStdInfoByUsr(usrInfo);
		}
		return SUCCESS;
	}
	public String instStdViewNavigation(){
		try {
			Map session = ActionContext.getContext().getSession();
			InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
			this.courseInfoList=dao.getCourses(instAdmin, false);
			List<CourseInfo> secCrsList=dao.getCourses(instAdmin, true);
			courseInfoList.addAll(secCrsList);
			for(CourseInfo crsInfo:courseInfoList){
				crsInfo.setBatchInfoList(null);
				crsInfo.setExamInfoList(null);
				crsInfo.setExamTypeList(null);
				crsInfo.setInstAdmin(null);
				crsInfo.setSubjectList(null);
				crsInfo.setNextCourse(null);
				crsInfo.setPreviousCourse(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
	public String getStdFromBatch(){
		BatchInfo btchInfo=dao.getBatchinfoById(btchInfoId);
		stdInfoList=dao.getStdFrmBtch(btchInfo);
		for(StudentInfo stdIn:stdInfoList){
			stdIn.setBatch_StdInfoList(null);
			stdIn.setCourse_StdInfoList(null);
			stdIn.setInstAdminList(null);
			stdIn.setMarksInfoList(null);
			stdIn.getUserInfo().setPassword(null);
			stdIn.getUserInfo().setUserType(null);
			stdIn.getUserInfo().setUsrRole(null);
		}
		return SUCCESS;
	}
}

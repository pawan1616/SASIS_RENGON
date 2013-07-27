package com.technobright.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javassist.compiler.ast.InstanceOfExpr;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.Batch_InstSess;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.ExamInfo;
import com.technobright.entities.ExamType;
import com.technobright.entities.GradInfo;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.InstSessionInfo;
import com.technobright.entities.MarksInfo;
import com.technobright.entities.ResultInfo;
import com.technobright.entities.StudentInfo;
import com.technobright.entities.SubjectInfo;

public class ResultInfoAction extends ActionSupport{

	private DAOInterface dao;
	private long instSessInfoId;
	private boolean isAllSession;
	private long courseInfoId;
	private long batchId;
	private boolean isCrsHistory;
	private List<InstSessionInfo> instSessInfoList;
	private List<BatchInfo> batchInfoList;
	private List<CourseInfo> courseInfoList;
	private List<ResultInfo> resultInfoList;

	public DAOInterface getDao() {
		return dao;
	}
	public void setDao(DAOInterface dao) {
		this.dao = dao;
	}
	public long getInstSessInfoId() {
		return instSessInfoId;
	}
	public void setInstSessInfoId(long instSessInfoId) {
		this.instSessInfoId = instSessInfoId;
	}
	public boolean getIsAllSession() {
		return isAllSession;
	}
	public void setIsAllSession(boolean isAllSession) {
		this.isAllSession = isAllSession;
	}

	public List<CourseInfo> getCourseInfoList() {
		return courseInfoList;
	}
	public void setCourseInfoList(List<CourseInfo> courseInfoList) {
		this.courseInfoList = courseInfoList;
	}
	public boolean getIsCrsHistory() {
		return isCrsHistory;
	}
	public void setIsCrsHistory(boolean isCrsHistory) {
		this.isCrsHistory = isCrsHistory;
	}
	public long getCourseInfoId() {
		return courseInfoId;
	}
	public void setCourseInfoId(long courseInfoId) {
		this.courseInfoId = courseInfoId;
	}
	public List<InstSessionInfo> getInstSessInfoList() {
		return instSessInfoList;
	}
	public void setInstSessInfoList(List<InstSessionInfo> instSessInfoList) {
		this.instSessInfoList = instSessInfoList;
	}
	public long getBatchId() {
		return batchId;
	}
	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}
	public List<BatchInfo> getBatchInfoList() {
		return batchInfoList;
	}
	public void setBatchInfoList(List<BatchInfo> batchInfoList) {
		this.batchInfoList = batchInfoList;
	}
	public List<ResultInfo> getResultInfoList() {
		return resultInfoList;
	}
	public void setResultInfoList(List<ResultInfo> resultInfoList) {
		this.resultInfoList = resultInfoList;
	}
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		if(isAllSession){
			List<InstSessionInfo> instSessList=dao.getInstSessions(instAdmin, false);
			for(InstSessionInfo instSess:instSessList)
				sessionEnd(instSess);
		}else{
			InstSessionInfo instSess=dao.getInstSessionById(instSessInfoId);
			sessionEnd(instSess);
		}	
		return SUCCESS;
	}



	public void sessionEnd(InstSessionInfo instSess){
		//		InstSessionInfo instSess=dao.getInstSessionById(instSessInfoId);
		List<ExamInfo> examInfoList=instSess.getExamInfoList();
		List<Batch_InstSess> btchSessList=dao.getBatchSessByInstSess(instSess);
		Set<ExamType> exmTypList=new LinkedHashSet<ExamType>();
		Map<Long, List<MarksInfo>> stdMarksMap=new HashMap<Long, List<MarksInfo>>();
		for(ExamInfo exm:examInfoList){
			if(exm.getExamType() instanceof ExamType)
				exmTypList.add(exm.getExamType());
			for(ExamType exmTyp:exmTypList){
				List<MarksInfo> marksInfoList=new ArrayList<MarksInfo>();
				for(ExamInfo exmInfo:examInfoList){
					if(exmInfo.getExamType().getExamTypeId()==exmTyp.getExamTypeId()){
						MarksInfo mrkIn=dao.getMarksInfoByExam(exmInfo);
						if(mrkIn.getMarkId()>0)
							marksInfoList.add(mrkIn);
					}
				}
				if(marksInfoList!=null&&!marksInfoList.isEmpty()){
					Set<StudentInfo> stdInfoSet=new LinkedHashSet<StudentInfo>();
					Set<SubjectInfo> subInfoSet=new LinkedHashSet<SubjectInfo>();
					for(MarksInfo marksInfo:marksInfoList){
						StudentInfo stdInfo=marksInfo.getStdInfo();
						if(stdInfo instanceof StudentInfo)
							stdInfoSet.add(stdInfo);
						if(marksInfo.getExamInfo().getSubjectInfo() instanceof SubjectInfo)
							subInfoSet.add(marksInfo.getExamInfo().getSubjectInfo());
						if(stdInfo!=null&&stdInfo.getStdId()>0){
							if(stdMarksMap.get(stdInfo.getStdId())!=null){
								stdMarksMap.get(stdInfo.getStdId()).add(marksInfo);
							}else{
								List<MarksInfo> mrksList=new ArrayList<MarksInfo>();
								mrksList.add(marksInfo);
								stdMarksMap.put(stdInfo.getStdId(),mrksList);
							}
						}
					}
				}
			}
		}

		/*calling the changes*/
		if(!stdMarksMap.isEmpty()){
			for(long stdId: stdMarksMap.keySet()){
				calculateStdResult(stdMarksMap.get(stdId), instSess, exmTypList);
			}
			instSess.setIsHistory(true);
			if(isAllSession)
				instSess.setIsAllSessionHistory(true);
			dao.updateObject(instSess);
			for(ExamInfo exmInfo:examInfoList){
				exmInfo.setIsHistory(true);
				dao.updateObject(exmInfo);
			}
		}
		for(Batch_InstSess btchSess:btchSessList){
			btchSess.setIsHistory(true);
			dao.updateObject(btchSess);
		}
	}


	public void calculateStdResult(List<MarksInfo> marksInfoList, InstSessionInfo instSess, Set<ExamType> exmTypList){

		ResultInfo resultInfo=new ResultInfo();
		List<Float> marksToCalculate=new ArrayList<Float>();
		List<Float> marksToCalculateInMain=new ArrayList<Float>();
		boolean isPercentageExist=false;
		float aggregate=0;
		float totalOfTotalMarks=0;
		for(MarksInfo marksInfo:marksInfoList){
			aggregate+=marksInfo.getMarksObtained();
			totalOfTotalMarks+=marksInfo.getExamInfo().getTotalMarks();
			ExamInfo exmInfo=marksInfo.getExamInfo();

			if(exmInfo.getIfFailAllFail()&&!marksInfo.getResult())
				resultInfo.setResult(false);

			if(!exmInfo.getIsCombineExam()){
				float markPercentage=marksInfo.getMarksObtained();
				if(exmInfo.getIsPercentWise()){
					markPercentage=(markPercentage*100)/exmInfo.getTotalMarks();
					isPercentageExist=true;
				}
				marksToCalculate.add(markPercentage);
				float mrkPercentageInMain=(markPercentage*exmInfo.getExamType().getPercentToBeContri())*100;
				marksToCalculateInMain.add(mrkPercentageInMain);
			}else{

				SubjectInfo subInfo=exmInfo.getSubjectInfo();
				List<MarksInfo> combineMarksList=new ArrayList<MarksInfo>();
				for(MarksInfo mi:marksInfoList){
					if(subInfo.getSubjectId()==mi.getExamInfo().getSubjectInfo().getSubjectId()){
						combineMarksList.add(mi);
					}
				}
				float totalMark=0;
				for(MarksInfo comMrkInfo:combineMarksList){
					if(comMrkInfo.getExamInfo().getIfFailAllCombineFail()&&!comMrkInfo.getResult())
						comMrkInfo.setCombineResult(false);
					float markPercentage=marksInfo.getMarksObtained();
					if(exmInfo.getIsPercentWise()){
						markPercentage=(marksInfo.getMarksObtained()*100)/exmInfo.getTotalMarks();
						isPercentageExist=true;
					}
					float marksObtn=(markPercentage*marksInfo.getExamInfo().getPercentToBeContri())/100;
					totalMark+=marksObtn;
				}
				marksToCalculate.add(totalMark);
				float mrkPercentageInMain=(totalMark*exmInfo.getExamType().getPercentToBeContri())*100;
				marksToCalculateInMain.add(mrkPercentageInMain);
				for(MarksInfo comMrkInfo:combineMarksList)
					dao.updateObject(comMrkInfo);
			}
			dao.updateObject(marksInfo);					
		}

		resultInfo.setMarksGained(aggregate);
		resultInfo.setInstSessInfo(instSess);
		resultInfo.setStdInfo(marksInfoList.get(0).getStdInfo());
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		resultInfo.setInstAdmin(instAdmin);
		float calculatedTotalMarks=0;
		for(float mrks:marksToCalculate){
			calculatedTotalMarks+=mrks;
		}
		float calculatedTotalMarksInMain=0;
		for(float mrks:marksToCalculateInMain){
			calculatedTotalMarksInMain+=mrks;
		}
		float percentage=0;
		if(isPercentageExist)
			percentage=calculatedTotalMarks/marksToCalculate.size();
		else
			percentage=(calculatedTotalMarks/totalOfTotalMarks)*100;
		resultInfo.setPercentage(percentage);
		if(exmTypList.size()>1){
			percentage=(calculatedTotalMarksInMain/marksToCalculateInMain.size());
		}
		List<GradInfo> gradList=dao.getGradList(instAdmin, false);
		Collections.sort(gradList);
		for(GradInfo gradInfo:gradList){
			if(gradInfo.getLowRange()<=((int)percentage)&&gradInfo.getHighRange()>=((int)percentage)){
				resultInfo.setGrade(gradInfo.getGradName());
			}
		}
		boolean finRes=false;
		for(MarksInfo marksInfo:marksInfoList){
			if(marksInfo.getResult()||(marksInfo.getCombineResult())){
				finRes=true;
			}
		}
		resultInfo.setResult(finRes);
		ResultInfo resIn=dao.getResultInfoBySessNStd(marksInfoList.get(0).getStdInfo(), instSess);
		if(resIn!=null){
			resultInfo.setResultId(resIn.getResultId());
			dao.updateObject(resultInfo);
		}else
			dao.insertObject(resultInfo);

	}
	public String resultSettingNavigation(){

		return SUCCESS;
	}
	public String instResultViewNavigation(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		courseInfoList=dao.getCourses(instAdmin, isCrsHistory);
		instSessInfoList=new ArrayList<InstSessionInfo>();
		if(courseInfoList!=null&&!courseInfoList.isEmpty()){
			instSessInfoList=dao.getInstSessionsByCourse(courseInfoList.get(0));
			if(instSessInfoList!=null&&!instSessInfoList.isEmpty()){
				resultInfoList=dao.getResultListByInstSess(instSessInfoList.get(instSessInfoList.size()-1));		
				instSessInfoId=instSessInfoList.get(instSessInfoList.size()-1).getInstSessInfoId();
			}
			courseInfoId=courseInfoList.get(0).getCourseId();
		}
		return SUCCESS;
	}
	public String fetchBatchNInstSessFromCourse(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		CourseInfo crsInfo=dao.getCourse(courseInfoId);
		batchInfoList=dao.getBatchFromCourse(crsInfo, instAdmin);
		if(batchInfoList!=null&&!batchInfoList.isEmpty()){
			for(BatchInfo batchInfo:batchInfoList){
				batchInfo.setCourseInfo(null);
				batchInfo.setBatch_stdInfoList(null);
				batchInfo.setInstAdmin(null);
			}
		}
		instSessInfoList=dao.getInstSessionsByCourse(crsInfo);
		if(instSessInfoList!=null&&!instSessInfoList.isEmpty()){
			for(InstSessionInfo instSess:instSessInfoList){
				instSess.setCourseInfo(null);
				instSess.setExamInfoList(null);
				instSess.setInstAdmin(null);
			}
		}
		return SUCCESS;
	}
	public String selectCourse(){
		Map session = ActionContext.getContext().getSession();
		InstAdmin instAdmin=(InstAdmin) session.get("InstAdmin");
		CourseInfo crsInfo=dao.getCourse(courseInfoId);
		batchInfoList=dao.getBatchFromCourse(crsInfo, instAdmin);
		instSessInfoList=dao.getInstSessionsByCourse(crsInfo);
		if(instSessInfoList!=null&&!instSessInfoList.isEmpty())
			resultInfoList=dao.getResultListByInstSess(instSessInfoList.get(instSessInfoList.size()-1));		
		return SUCCESS;
	}
	public String selectInstSess(){
		InstSessionInfo instSess=dao.getInstSessionById(instSessInfoId);
		resultInfoList=dao.getResultListByInstSess(instSess);		
		return SUCCESS;
	}
	public String selectBatch(){
		InstSessionInfo instSess=dao.getInstSessionById(instSessInfoId);
		resultInfoList=dao.getResultListByInstSess(instSess);		
		List<ResultInfo> resList=new ArrayList<ResultInfo>();
		if(batchId!=-1&&resultInfoList!=null&&!resultInfoList.isEmpty()){
			BatchInfo batchInfo=dao.getBatchinfoById(batchId);
			for(ResultInfo resInfo: resultInfoList){
				if(resInfo.getInstSessInfo().getCourseInfo().getCourseId()==batchInfo.getCourseInfo().getCourseId()){
					resList.add(resInfo);
				}
				resultInfoList=resList;
			}
			
		}
		return SUCCESS;
	}

}

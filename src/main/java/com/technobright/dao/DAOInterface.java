package com.technobright.dao;

import java.util.List;
import java.util.Map;

import com.technobright.entities.Achievement;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.Batch_InstSess;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.ExamInfo;
import com.technobright.entities.ExamType;
import com.technobright.entities.GradInfo;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.InstSessionInfo;
import com.technobright.entities.MarksInfo;
import com.technobright.entities.Page;
import com.technobright.entities.ProfilePic;
import com.technobright.entities.ResultInfo;
import com.technobright.entities.StdWorkExp;
import com.technobright.entities.StudentInfo;
import com.technobright.entities.SubjectInfo;
import com.technobright.entities.UserInfo;
import com.technobright.entities.UserPreference;
import com.technobright.entities.UserRole;
import com.technobright.entities.fee.FeeType;

public interface DAOInterface {
	public List<FeeType> feeType();

	public boolean insertUserInfo(UserInfo usrInfo);
	public UserInfo getUserInfo(String userName);
	public UserInfo getUserInfo(int id);
	public void insertCompleteEntity(Object obj);
	public List<SubjectInfo> getAllSubjects(InstAdmin instAdmin);
	
	public void insertObject(Object obj);
	public boolean updateObject(Object obj);
	public boolean insertOrUpdateObject(Object obj);
	public List getExamTypes(InstAdmin instAdmin,boolean isHistory);
	
	public List<CourseInfo> getCourses(InstAdmin instAdmin,boolean isHistory);
	public boolean updateCourseInfo(CourseInfo courseInfo);
	public CourseInfo getCourse(long pk);
	public boolean deleteCourse();
	public boolean deleteThisCourse(CourseInfo courseInfo);
	
	public List<UserPreference> getAllUsrPrefs();
	public List<Page> getAllPages();
//	public List<UserPreference> getUsrPref4mPage(List<String> strList);
	public List<UserRole> getUserRoles();
	public List<UserInfo> getAllUsers();
	public StudentInfo getStdInfoByUsr(UserInfo usrInfo);
	public StudentInfo getStdInfoById(long pk);
	public List<StudentInfo> getActiveStdInfoList(CourseInfo crsInfo);
	public InstAdmin getInstAdminByUsrId(int usrId);
	public InstAdmin getInstAdminById(int pk);
	public ExamType getExamType(int exmTypeId);
	public List<ExamInfo> getAllExamInfos(InstAdmin instAdmin);
	public List<ExamInfo> getExamInfos(InstAdmin instAdmin,boolean isHistory);
	public List<ExamInfo> getExamInfosFromCourse(CourseInfo crsInfo,boolean isHistory);
	public InstSessionInfo getInstSessionById(long pk);
	public List<InstSessionInfo> getInstSessions(InstAdmin instAdmin,boolean isHistory);
	public List<InstSessionInfo> getInstSessionsByCourse(CourseInfo crsInfo);
	public List<InstSessionInfo> getInstSessionsByCourse(CourseInfo crsInfo,boolean isHistory);
	public List<InstSessionInfo> getInstSessionsForStd(StudentInfo stdInfo,CourseInfo crsInfo);
	public BatchInfo getBatchinfoById(long pk);
	public List<Batch_InstSess> getBatchSessByInstSess(InstSessionInfo instSess);
	public List<Batch_InstSess> getBatchSessByInstSess(InstSessionInfo instSess,boolean isHistory);
	public List<BatchInfo> getBatchList(InstAdmin instAdmin,boolean isHistory);
	public GradInfo getGradById(long pk);
	public List<GradInfo> getGradList(InstAdmin instAdmin, boolean isHistory);
	public List<StudentInfo> getActiveStdFrmBtch(BatchInfo batchInfo);
	public List<StudentInfo> getStdFrmBtch(BatchInfo batchInfo);
	public ExamInfo getExamInfoById(long pk);
	public List<ExamInfo> getExamInfoFromSubject(InstAdmin instAdmin, SubjectInfo sub);
	public List<ExamInfo> getExamInfoFromSubject(InstAdmin instAdmin, SubjectInfo sub,boolean isHistory);
	public List<CourseInfo> getStdCourseList(StudentInfo stdInfo);
	public List<InstAdmin> getStdInstList(StudentInfo stdInfo);
	public List<CourseInfo> getCourseInfosFromInst(InstAdmin instAdmin,StudentInfo stdInfo);
	public List<MarksInfo> getMarksInfoByCourse(StudentInfo stdInfo,CourseInfo courseInfo);
	public List<MarksInfo> getMarksInfoByCourse(StudentInfo stdInfo,CourseInfo courseInfo,InstSessionInfo instSess);
	public MarksInfo getMarksInfoByExam(ExamInfo exmInfo);
	public MarksInfo getMarksInfoById(long pk);
	public List<StdWorkExp> getStdWorkExpList(StudentInfo stdInfo);
	public void updateCurrWorkExpFalse(StdWorkExp stdWorkExp);
	public List<CourseInfo> getProfessionalCourseList(StudentInfo stdInfo);
	public List<Achievement> getAchievementList(StudentInfo stdInfo);
	public Achievement getAchievementById(int pk);
	public ProfilePic getStdProfilePic(StudentInfo stdInfo);
	public void insertProfilePic(ProfilePic profilePic);
	public ProfilePic getDefaultPic();
	public SubjectInfo getSubjectExist(SubjectInfo subInfo);
	public boolean instSubjsExist(InstAdmin instAdmin, SubjectInfo subInfo);
	public SubjectInfo getSubjectById(long subId);
	
	public boolean deleteSubject(SubjectInfo subInfo, InstAdmin instAdmin);
	public List<BatchInfo> getBatchFromCourse(CourseInfo crsInfo,InstAdmin instAdmin);
	public boolean deleteBatch(BatchInfo batchInfo, InstAdmin instAdmin);
	
	public ResultInfo getResultInfoBySessNStd(StudentInfo stdInfo, InstSessionInfo instSess);
	public List<ResultInfo> getResultListByInstSess(InstSessionInfo sessInfo);
	public List<ResultInfo> getResultListByStdNCourse(StudentInfo stdInfo,CourseInfo crsInfo);
	public Map<Long,List<ResultInfo>> getResultListByInstSess(List<InstSessionInfo> sessInfoList);

}

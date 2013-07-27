package com.technobright.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.technobright.entities.Achievement;
import com.technobright.entities.BatchInfo;
import com.technobright.entities.Batch_InstSess;
import com.technobright.entities.Batch_StdInfo;
import com.technobright.entities.CourseInfo;
import com.technobright.entities.Course_StdInfo;
import com.technobright.entities.ExamInfo;
import com.technobright.entities.ExamType;
import com.technobright.entities.GradInfo;
import com.technobright.entities.InstAdmin;
import com.technobright.entities.InstAdmin_StdInfo;
import com.technobright.entities.InstSessionInfo;
import com.technobright.entities.Inst_Subjects;
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


public class DAODerbyImpl implements DAOInterface{
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean insertUserInfo(UserInfo usrInfo) {
		try {
			Session session=sessionFactory.openSession();
			try {
				session.beginTransaction();
				session.save(usrInfo);
				session.getTransaction().commit();
			}catch (ConstraintViolationException cve) {
				cve.printStackTrace();
				return false;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public UserInfo getUserInfo(String userName){
		UserInfo usrInfo=new UserInfo();
		try {
			Session session=sessionFactory.openSession();
			try {
				session.beginTransaction();
				List resultList=session.createCriteria(UserInfo.class)
						.add(Restrictions.like("userName", userName)).list();
				if(resultList!=null&&resultList.size()!=0){
					usrInfo=(UserInfo)resultList.get(0);
				}
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usrInfo;
	}
	public UserInfo getUserInfo(int id){
		UserInfo usrInfo=new UserInfo();
		try {
			Session session=sessionFactory.openSession();
			try {
				session.beginTransaction();
				List resultList=session.createCriteria(UserInfo.class)
						.add(Restrictions.like("userUID", id)).list();
				if(resultList.size()!=0)
					usrInfo=(UserInfo)resultList.get(0);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					session.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usrInfo;
	}
	public void insertCompleteEntity(Object obj){
		Session session=sessionFactory.openSession();
		try{
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public boolean instSubjsExist(InstAdmin instAdmin, SubjectInfo subInfo){
		boolean result=false;
		Session session=sessionFactory.openSession();
		try {			
			session.beginTransaction();
			List<Inst_Subjects> instSubList=session.createCriteria(Inst_Subjects.class)
					.add(Restrictions.eq("instAdmin", instAdmin))
					.add(Restrictions.eq("subInfo", subInfo))
					.list();
			if(instSubList!=null&&!instSubList.isEmpty())
				result=true;
			else
				result=false;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public SubjectInfo getSubjectExist(SubjectInfo subInfo){
		SubjectInfo result=new SubjectInfo();
		Session session=sessionFactory.openSession();
		try {			
			session.beginTransaction();
			List<SubjectInfo>subList=session.createCriteria(SubjectInfo.class)
					.add(Restrictions.eq("subName", subInfo.getSubName()))
					.add(Restrictions.eq("subType", subInfo.getSubType()))
					.list();
			if(subList!=null&&!subList.isEmpty())
				result=subList.get(0);
			else
				result=null;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public boolean deleteSubject(SubjectInfo subInfo, InstAdmin instAdmin){
		Session session=sessionFactory.openSession();
		int noOfDelRow=0;
		try {
			session.beginTransaction();
			noOfDelRow=session.createQuery("delete from Inst_Subjects iss where subInfo= :subInfo and instAdmin=:instAdmin").setParameter("subInfo", subInfo).setParameter("instAdmin", instAdmin).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(noOfDelRow>0)
			return true;
		else
			return false;
	}
	public boolean deleteBatch(BatchInfo batchInfo, InstAdmin instAdmin){
		Session session=sessionFactory.openSession();
		int noOfDelRow=0;
		try {
			session.beginTransaction();
			noOfDelRow=session.createQuery("delete from BatchInfo btch where batchId= :batchId and instAdmin=:instAdmin").setParameter("batchId", batchInfo.getBatchId()).setParameter("instAdmin", instAdmin).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(noOfDelRow>0)
			return true;
		else
			return false;
	}
	public SubjectInfo getSubjectById(long subId){
		SubjectInfo result=new SubjectInfo();
		Session session=sessionFactory.openSession();
		try {			
			session.beginTransaction();
			List<SubjectInfo>subList=session.createCriteria(SubjectInfo.class)
					.add(Restrictions.eq("subjectId",subId))
					.list();
			if(subList!=null&&!subList.isEmpty())
				result=subList.get(0);
			else
				result=null;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public List<SubjectInfo> getAllSubjects(InstAdmin instAdmin){
		List<SubjectInfo> subList=new ArrayList<SubjectInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			subList=session.createCriteria(Inst_Subjects.class)
					.add(Restrictions.eq("instAdmin",instAdmin))
					.add(Restrictions.eq("isActive", true))
					.setProjection(Projections.property("subInfo"))
					.list();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return subList;
	}

	public void insertObject(Object obj){
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List getExamTypes(InstAdmin instAdmin,boolean isHistory){
		List examTypeList=new ArrayList();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			examTypeList=session.createCriteria(ExamType.class)
					.add(Restrictions.isNotNull("examTypeName"))
					.add(Restrictions.eq("instAdmin", instAdmin))
					.add(Restrictions.eq("isHistory", isHistory)).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return examTypeList;
	}

	public List<CourseInfo> getCourses(InstAdmin instAdmin,boolean isHistory){
		List<CourseInfo> courseList=new ArrayList<CourseInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			courseList=session.createCriteria(CourseInfo.class)
					.add(Restrictions.isNotNull("courseName"))
					.add(Restrictions.eq("instAdmin", instAdmin))
					.add(Restrictions.eq("isHistory", isHistory))
					.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY)
					.list();
			System.out.println(courseList.size()+"............");
			for(CourseInfo crsInfo:courseList){
				for(ExamType exmTyp:crsInfo.getExamTypeList())
					exmTyp.getSubjectList();
				
				System.out.println(crsInfo.getSubjectList().size()); 
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return courseList;
	}

	public boolean updateCourseInfo(CourseInfo courseInfo){
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(courseInfo);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	public CourseInfo getCourse(long pk){
		Session session=sessionFactory.openSession();
		CourseInfo courseInfo=new CourseInfo();
		try {
			session.beginTransaction();
			courseInfo=(CourseInfo)session.createCriteria(CourseInfo.class)
					.add(Restrictions.eq("courseId", pk))
					.list().get(0);
			courseInfo.setBatchInfoList(new ArrayList<BatchInfo>());
			System.out.println(courseInfo.getSubjectList().size());
			for(ExamType exmTyp:courseInfo.getExamTypeList()){
				exmTyp.getInstAdmin();
				exmTyp.getSubjectList();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return courseInfo;
	}

	public boolean deleteCourse(){
		Session session=sessionFactory.openSession();
		int noOfDelRow=0;
		try {
			session.beginTransaction();
			session.createSQLQuery("update COURSEINFO set NEXTCOURSE=NULL, PREVIOUSCOURSE=NULL").executeUpdate();
			session.createSQLQuery("delete from COURSE_SUBJECTINFO").executeUpdate();
			session.createSQLQuery("delete from COURSE_EXAMTYPE").executeUpdate();
			noOfDelRow=session.createQuery("delete from CourseInfo").executeUpdate();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(noOfDelRow>0)
			return true;
		else
			return false;
	}

	public boolean deleteThisCourse(CourseInfo courseInfo){
		Session session=sessionFactory.openSession();
		int noOfDelRow=0;
		try {
			session.beginTransaction();
			session.createSQLQuery("update COURSEINFO set NEXTCOURSE=NULL WHERE NEXTCOURSE="+courseInfo.getCourseId()).executeUpdate();
			session.createSQLQuery("update COURSEINFO set PREVIOUSCOURSE=NULL WHERE PREVIOUSCOURSE="+courseInfo.getCourseId()).executeUpdate();
			session.createSQLQuery("delete from COURSE_SUBJECTINFO where COURSEID="+courseInfo.getCourseId()).executeUpdate();
			session.createSQLQuery("delete from COURSE_EXAMTYPE where COURSEID="+courseInfo.getCourseId()).executeUpdate();
			noOfDelRow=session.createQuery("delete from CourseInfo ci where courseId= :courseId").setParameter("courseId", courseInfo.getCourseId()).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(noOfDelRow>0)
			return true;
		else
			return false;
	}
	public BatchInfo getBatchinfoById(long pk){
		Session session=sessionFactory.openSession();
		BatchInfo batchInfo=new BatchInfo();
		try {
			session.beginTransaction();
			batchInfo=(BatchInfo)session.createCriteria(BatchInfo.class)
					.add(Restrictions.eq("batchId", pk))
					.list().get(0);
			batchInfo.getCourseInfo().getCourseId();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return batchInfo;
	}
	public List<BatchInfo> getBatchList(InstAdmin instAdmin,boolean isHistory){
		List<BatchInfo> batchList=new ArrayList<BatchInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			batchList=session.createCriteria(BatchInfo.class)
					.add(Restrictions.isNotNull("batchName"))
					.add(Restrictions.eq("instAdmin", instAdmin))
					.add(Restrictions.eq("isHistory", isHistory))
					.list();
			for(BatchInfo btch:batchList)
				btch.getCourseInfo().getCourseName();
					session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return batchList;
	}
	public List<Batch_InstSess> getBatchSessByInstSess(InstSessionInfo instSess){
		List<Batch_InstSess> batchSessList=new ArrayList<Batch_InstSess>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			batchSessList=session.createCriteria(Batch_InstSess.class)
					.add(Restrictions.eq("instSess", instSess))
					.list();
			for(Batch_InstSess btchSess:batchSessList){
				btchSess.getBatchInfo();
				btchSess.getInstSess();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return batchSessList;
	}

	public List<Batch_InstSess> getBatchSessByInstSess(InstSessionInfo instSess,boolean isHistory){
		List<Batch_InstSess> batchSessList=new ArrayList<Batch_InstSess>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			batchSessList=session.createCriteria(Batch_InstSess.class)
					.add(Restrictions.eq("instSess", instSess))
					.add(Restrictions.eq("isHistory", isHistory))
					.list();
			for(Batch_InstSess btchSess:batchSessList){
				btchSess.getBatchInfo();
				btchSess.getInstSess();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return batchSessList;
	}
	public GradInfo getGradById(long pk){
		Session session=sessionFactory.openSession();
		GradInfo gradInfo=new GradInfo();
		try {
			session.beginTransaction();
			gradInfo=(GradInfo)session.createCriteria(GradInfo.class)
					.add(Restrictions.eq("gradId", pk))
					.list().get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return gradInfo;
	}
	public List<GradInfo> getGradList(InstAdmin instAdmin, boolean isHistory){
		List<GradInfo> gradList=new ArrayList<GradInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			gradList=session.createCriteria(GradInfo.class)
					.add(Restrictions.isNotNull("lowRange"))
					.add(Restrictions.isNotNull("highRange"))
					.add(Restrictions.isNotNull("gradName"))
					.add(Restrictions.isNotNull("gradPoint"))
					.add(Restrictions.eq("instAdmin", instAdmin))
					.add(Restrictions.eq("isHistory", isHistory))
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return gradList;
	}
	public List<UserPreference> getAllUsrPrefs() {

		List<UserPreference> courseList=new ArrayList<UserPreference>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			courseList=session.createCriteria(UserPreference.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return courseList;
	}
	public List<Page> getAllPages(){
		List<Page> pageList=new ArrayList<Page>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			pageList=session.createCriteria(Page.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return pageList;
	}

	public List<UserRole> getUserRoles(){
		List<UserRole> roleList=new ArrayList<UserRole>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			roleList=session.createCriteria(UserRole.class).list();
			for(UserRole usrR:roleList){
				System.out.println(usrR.getUsrInfoList().size()+"..............................");
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return roleList;
	}

	public boolean updateObject(Object obj){
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
	public boolean insertOrUpdateObject(Object obj){
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(obj);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}
	public List<UserInfo> getAllUsers(){
		List<UserInfo> usrInfoList=new ArrayList<UserInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			usrInfoList=session.createCriteria(UserInfo.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return usrInfoList;
	}
	public StudentInfo getStdInfoById(long pk){
		Session session=sessionFactory.openSession();
		StudentInfo stdInfo=new StudentInfo();
		try {
			session.beginTransaction();
			stdInfo=(StudentInfo)session.createCriteria(StudentInfo.class)
					.add(Restrictions.eq("stdId",pk))
					.list().get(0);
			stdInfo.getBatch_StdInfoList().size();
			stdInfo.getCourse_StdInfoList().size();
			stdInfo.getInstAdminList().size();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return stdInfo;
	}
	public StudentInfo getStdInfoByUsr(UserInfo usrInfo){
		Session session=sessionFactory.openSession();
		StudentInfo stdInfo=new StudentInfo();
		try {
			session.beginTransaction();
			stdInfo=(StudentInfo)session.createCriteria(StudentInfo.class)
					.add(Restrictions.eq("userInfo", usrInfo))
					.list().get(0);
			stdInfo.getBatch_StdInfoList().size();
			stdInfo.getCourse_StdInfoList().size();
			stdInfo.getInstAdminList().size();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return stdInfo;
	}
	public List<StudentInfo> getActiveStdInfoList(CourseInfo crsInfo){
		List<StudentInfo> stdInfoList=new ArrayList<StudentInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			stdInfoList=session.createCriteria(Course_StdInfo.class)
					.add(Restrictions.eq("courseInfo",crsInfo))
					.add(Restrictions.eq("isActive", true))
					.setProjection(Projections.property("stdInfo"))
					.list();
			for(StudentInfo stdInfo:stdInfoList)
				System.out.println(stdInfo.getFirstName());
					session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return stdInfoList;
	}
	public List<BatchInfo> getBatchFromCourse(CourseInfo crsInfo,InstAdmin instAdmin){
		List<BatchInfo> btchInfoList=new ArrayList<BatchInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			btchInfoList=session.createCriteria(BatchInfo.class)
					.add(Restrictions.eq("courseInfo",crsInfo))
					.add(Restrictions.eq("instAdmin",instAdmin))
					.list();
			session.getTransaction().commit();
			for(BatchInfo btchInfo:btchInfoList){
				System.out.println(btchInfo.getBatchName());
				btchInfo.setCourseInfo(null);
				btchInfo.setInstAdmin(null);
				btchInfo.setBatch_stdInfoList(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return btchInfoList;
	}
	public List<StudentInfo> getStdFrmBtch(BatchInfo batchInfo){
		List<StudentInfo> stdInfoList=new ArrayList<StudentInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			stdInfoList=session.createCriteria(Batch_StdInfo.class)
					.add(Restrictions.eq("batchInfo",batchInfo))
					.setProjection(Projections.property("studentInfo"))
					.list();
			for(StudentInfo stdInfo:stdInfoList)
				System.out.println(stdInfo.getFirstName());
					session.getTransaction().commit();
					for(StudentInfo stdInfo:stdInfoList){
						stdInfo.setBatch_StdInfoList(null);
						stdInfo.setCourse_StdInfoList(null);
						stdInfo.setInstAdminList(null);
						stdInfo.setMarksInfoList(null);
					}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return stdInfoList;

	}
	public List<StudentInfo> getActiveStdFrmBtch(BatchInfo batchInfo){
		List<StudentInfo> stdInfoList=new ArrayList<StudentInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			stdInfoList=session.createCriteria(Batch_StdInfo.class)
					.add(Restrictions.eq("batchInfo",batchInfo))
					.add(Restrictions.eq("isActive", true))
					.setProjection(Projections.property("studentInfo"))
					.list();
			for(StudentInfo stdInfo:stdInfoList)
				System.out.println(stdInfo.getFirstName());
					session.getTransaction().commit();
					for(StudentInfo stdInfo:stdInfoList){
						stdInfo.setBatch_StdInfoList(null);
						stdInfo.setCourse_StdInfoList(null);
						stdInfo.setInstAdminList(null);
						stdInfo.setMarksInfoList(null);
					}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return stdInfoList;

	}
	public InstAdmin getInstAdminById(int pk){
		Session session=sessionFactory.openSession();
		InstAdmin instAdmin=new InstAdmin();
		try {
			session.beginTransaction();
			instAdmin=(InstAdmin)session.createCriteria(InstAdmin.class)
					.add(Restrictions.eq("adminId", pk))
					.list().get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return instAdmin;
	}
	public InstAdmin getInstAdminByUsrId(int usrId){
		Session session=sessionFactory.openSession();
		InstAdmin instAdmin=new InstAdmin();
		try {
			session.beginTransaction();
			instAdmin=(InstAdmin)session.createCriteria(InstAdmin.class)
					.add(Restrictions.eq("userId", usrId))
					.list().get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return instAdmin;
	}

	public ExamType getExamType(int exmTypeId){
		Session session=sessionFactory.openSession();
		ExamType exmType=new ExamType();
		try {
			session.beginTransaction();
			exmType=(ExamType)session.createCriteria(ExamType.class)
					.add(Restrictions.eq("examTypeId", exmTypeId))
					.list().get(0);
			for(SubjectInfo subInfo:exmType.getSubjectList()){
				subInfo.getSubjectId();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return exmType;

	}
	public List<ExamInfo> getAllExamInfos(InstAdmin instAdmin){

		List examInfoList=new ArrayList();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			examInfoList=session.createCriteria(ExamInfo.class)
					.add(Restrictions.eq("instAdmin",instAdmin))
					.add(Restrictions.isNotNull("examName"))
					.add(Restrictions.isNotNull("subjectInfo"))
					.add(Restrictions.isNotNull("examType"))
					.add(Restrictions.isNotNull("courseInfo"))
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return examInfoList;
	}
	public List<ExamInfo> getExamInfoFromSubject(InstAdmin instAdmin,SubjectInfo sub,boolean isHistory){
		List examInfoList=new ArrayList();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			examInfoList=session.createCriteria(ExamInfo.class)
					.add(Restrictions.eq("instAdmin",instAdmin))
					.add(Restrictions.isNotNull("examName"))
					.add(Restrictions.eq("subjectInfo", sub))
					.add(Restrictions.isNotNull("examType"))
					.add(Restrictions.isNotNull("courseInfo"))
					.add(Restrictions.eq("isHistory",isHistory))
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return examInfoList;
	}
	public List<ExamInfo> getExamInfoFromSubject(InstAdmin instAdmin,SubjectInfo sub){
		List examInfoList=new ArrayList();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			examInfoList=session.createCriteria(ExamInfo.class)
					.add(Restrictions.eq("instAdmin",instAdmin))
					.add(Restrictions.isNotNull("examName"))
					.add(Restrictions.eq("subjectInfo", sub))
					.add(Restrictions.isNotNull("examType"))
					.add(Restrictions.isNotNull("courseInfo"))
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return examInfoList;
	}
	public List<ExamInfo> getExamInfosFromCourse(CourseInfo crsInfo,boolean isHistory){
		List<ExamInfo> examInfoList=new ArrayList<ExamInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			examInfoList=session.createCriteria(ExamInfo.class)
					.add(Restrictions.isNotNull("examName"))
					.add(Restrictions.eq("courseInfo", crsInfo))
					.add(Restrictions.eq("isHistory", isHistory))
					.list();
			session.getTransaction().commit();
			for(ExamInfo exmInfo:examInfoList){
				exmInfo.getExamType();
				exmInfo.getInstAdmin();
				exmInfo.getSubjectInfo();
				exmInfo.getInstSess();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return examInfoList;
	}
	public List<ExamInfo> getExamInfos(InstAdmin instAdmin,boolean isHistory){
		List<ExamInfo> examInfoList=new ArrayList<ExamInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			examInfoList=session.createCriteria(ExamInfo.class)
					.add(Restrictions.eq("instAdmin",instAdmin))
					.add(Restrictions.isNotNull("examName"))
					.add(Restrictions.isNotNull("subjectInfo"))
					.add(Restrictions.isNotNull("examType"))
					.add(Restrictions.isNotNull("courseInfo"))
					.add(Restrictions.eq("isHistory", isHistory))
					.list();
			for(ExamInfo exmInfo:examInfoList){
				exmInfo.getCourseInfo();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return examInfoList;
	}
	public List<ResultInfo> getResultListByStdNCourse(StudentInfo stdInfo,CourseInfo crsInfo){
		List<ResultInfo> resultInfoList=new ArrayList<ResultInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			resultInfoList=session.createCriteria(ResultInfo.class,"resInfo")
					.add(Restrictions.eq("stdInfo",stdInfo))
					.createAlias("resInfo.instSessInfo", "instSess")
					.add(Restrictions.eq("instSess.courseInfo", crsInfo))
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultInfoList;
	}
	public Map<Long,List<ResultInfo>> getResultListByInstSess(List<InstSessionInfo> sessInfoList){
		Map<Long, List<ResultInfo>> resInfoMap=new LinkedHashMap<Long, List<ResultInfo>>();
		for(InstSessionInfo instSess:sessInfoList){
			resInfoMap.put(instSess.getInstSessInfoId(), getResultListByInstSess(instSess));
		}
		return resInfoMap;
	}
	public List<ResultInfo> getResultListByInstSess(InstSessionInfo sessInfo){
		List<ResultInfo> resultInfoList=new ArrayList<ResultInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			resultInfoList=session.createCriteria(ResultInfo.class)
					.add(Restrictions.eq("instSessInfo",sessInfo))
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultInfoList;
	}
	public ResultInfo getResultInfoBySessNStd(StudentInfo stdInfo, InstSessionInfo instSess){
		Session session=sessionFactory.openSession();
		ResultInfo resultInfo=null;
		try {
			session.beginTransaction();
			List<ResultInfo> resList=session.createCriteria(ResultInfo.class)
					.add(Restrictions.eq("stdInfo", stdInfo))
					.add(Restrictions.eq("instSessInfo", instSess))
					.list();
			if(resList!=null&&!resList.isEmpty())
				resultInfo=resList.get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultInfo;
	}
	public InstSessionInfo getInstSessionById(long pk){
		Session session=sessionFactory.openSession();
		InstSessionInfo instSessInfo=new InstSessionInfo();
		try {
			session.beginTransaction();
			instSessInfo=(InstSessionInfo)session.createCriteria(InstSessionInfo.class)
					.add(Restrictions.eq("instSessInfoId", pk))
					.list().get(0);
			instSessInfo.getCourseInfo().getExamTypeList().size();
			for(ExamInfo exmInfo:instSessInfo.getExamInfoList()){
				exmInfo.getExamType().getExamTypeId();
				exmInfo.getSubjectInfo().getSubjectId();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return instSessInfo;

	}
	public List<InstSessionInfo> getInstSessionsForStd(StudentInfo stdInfo,CourseInfo crsInfo){
		List<InstSessionInfo> instSessInfoList=new ArrayList<InstSessionInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			instSessInfoList=session.createCriteria(MarksInfo.class,"mrkInfo")
					.add(Restrictions.eq("mrkInfo.stdInfo",stdInfo))
					.createAlias("mrkInfo.examInfo", "exmInfo")
					.createAlias("exmInfo.courseInfo", "crsInfo")
					.add(Restrictions.eq("crsInfo.courseId", crsInfo.getCourseId()))
					.add(Restrictions.isNotNull("exmInfo.instSess"))
					.setProjection(Projections.property("exmInfo.instSess"))
					.list();
			for(InstSessionInfo instSess:instSessInfoList){
				instSess.getCourseInfo();
				instSess.getExamInfoList();
				instSess.getInstAdmin();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return instSessInfoList;
	}
	public List<InstSessionInfo> getInstSessionsByCourse(CourseInfo crsInfo){
		List<InstSessionInfo> instSessInfoList=new ArrayList<InstSessionInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			instSessInfoList=session.createCriteria(InstSessionInfo.class)
					.add(Restrictions.eq("courseInfo",crsInfo))
					.list();
			for(InstSessionInfo instSess:instSessInfoList){
				
				for(ExamInfo exmInfo:instSess.getExamInfoList()){
					exmInfo.getExamType().getExamTypeId();
					exmInfo.getSubjectInfo().getSubjectId();
				}
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return instSessInfoList;
	}
	public List<InstSessionInfo> getInstSessionsByCourse(CourseInfo crsInfo,boolean isHistory){
		List<InstSessionInfo> instSessInfoList=new ArrayList<InstSessionInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			instSessInfoList=session.createCriteria(InstSessionInfo.class)
					.add(Restrictions.eq("courseInfo",crsInfo))
					.add(Restrictions.eq("isHistory",isHistory))
					.list();
			for(InstSessionInfo instSess:instSessInfoList){
				
				for(ExamInfo exmInfo:instSess.getExamInfoList()){
					exmInfo.getExamType().getExamTypeId();
					exmInfo.getSubjectInfo().getSubjectId();
				}
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return instSessInfoList;
	}
	public List<InstSessionInfo> getInstSessions(InstAdmin instAdmin,boolean isHistory){
		List<InstSessionInfo> instSessInfoList=new ArrayList<InstSessionInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			instSessInfoList=session.createCriteria(InstSessionInfo.class)
					.add(Restrictions.eq("instAdmin",instAdmin))
					.add(Restrictions.eq("isHistory", isHistory))
					.list();
			for(InstSessionInfo instSess:instSessInfoList){
				for(ExamInfo exmInfo:instSess.getExamInfoList()){
					exmInfo.getExamType().getExamTypeId();
					exmInfo.getSubjectInfo().getSubjectId();
				}
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return instSessInfoList;
	}
	public ExamInfo getExamInfoById(long pk){
		Session session=sessionFactory.openSession();
		ExamInfo examInfo=new ExamInfo();
		try {
			session.beginTransaction();
			examInfo=(ExamInfo)session.createCriteria(ExamInfo.class)
					.add(Restrictions.eq("examId", pk))
					.list().get(0);
			examInfo.getCourseInfo().getCourseId();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return examInfo;

	}
	public List<CourseInfo> getStdCourseList(StudentInfo stdInfo){
		List<CourseInfo> courseInfoList=new ArrayList<CourseInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			courseInfoList=session.createCriteria(Course_StdInfo.class)
					.add(Restrictions.eq("stdInfo",stdInfo))
					.setProjection(Projections.property("courseInfo"))
					.list();
			for(CourseInfo crsInfo:courseInfoList)
				System.out.println(crsInfo.getCourseName());
					session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return courseInfoList;
	}
	public List<InstAdmin> getStdInstList(StudentInfo stdInfo){
		List<InstAdmin> instAdminList=new ArrayList<InstAdmin>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			instAdminList=session.createCriteria(InstAdmin_StdInfo.class)
					.add(Restrictions.eq("stdInfo",stdInfo))
					.setProjection(Projections.property("instAdmin"))
					.list();
			for(InstAdmin instAdmin:instAdminList)
				System.out.println(instAdmin.getInstType());
					session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return instAdminList;
	}
	public List<CourseInfo> getCourseInfosFromInst(InstAdmin instAdmin,StudentInfo stdInfo){
		List<CourseInfo> courseInfoList= new ArrayList<CourseInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			courseInfoList=session.createCriteria(Course_StdInfo.class,"crsStd")
					.add(Restrictions.eq("crsStd.stdInfo",stdInfo))
					.setProjection(Projections.property("courseInfo"))
					.list();
			List<CourseInfo> tempCourseInfoList=new ArrayList<CourseInfo>();
			for(CourseInfo courseInfo:courseInfoList){
				if(courseInfo.getInstAdmin().getAdminId()==instAdmin.getAdminId()){
					tempCourseInfoList.add(courseInfo);
				}
			}
//			courseInfoList=tempCourseInfoList;
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return courseInfoList;
		}
	}
	public List<MarksInfo> getMarksInfoByCourse(StudentInfo stdInfo,CourseInfo courseInfo){

		List<MarksInfo> marksInfoList= new ArrayList<MarksInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			marksInfoList=session.createCriteria(MarksInfo.class,"marksInfo")
					.createAlias("marksInfo.examInfo", "examInfo")
					.createAlias("examInfo.courseInfo", "courseInfo")
					.add(Restrictions.eq("marksInfo.stdInfo", stdInfo))
					.add(Restrictions.eq("courseInfo.courseId",courseInfo.getCourseId()))
					.list();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return marksInfoList;
		}
	}
	public List<MarksInfo> getMarksInfoByCourse(StudentInfo stdInfo,CourseInfo courseInfo,InstSessionInfo instSess){
		List<MarksInfo> marksInfoList= new ArrayList<MarksInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			marksInfoList=session.createCriteria(MarksInfo.class,"marksInfo")
					.createAlias("marksInfo.examInfo", "examInfo")
					.createAlias("examInfo.courseInfo", "courseInfo")
					.add(Restrictions.eq("examInfo.instSess", instSess))
					.add(Restrictions.eq("marksInfo.stdInfo", stdInfo))
					.add(Restrictions.eq("courseInfo.courseId",courseInfo.getCourseId()))
					.list();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return marksInfoList;
		}
	}
	public MarksInfo getMarksInfoById(long pk){
		MarksInfo marksInfo= null;
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<MarksInfo> marksInfoList=session.createCriteria(MarksInfo.class)
					.add(Restrictions.eq("markId", pk))
					.list();
			if(marksInfoList!=null&&!marksInfoList.isEmpty()){
				System.out.println(marksInfoList.get(0).getExamInfo().getExamId());
				marksInfo=marksInfoList.get(0);
				marksInfo.getStdInfo().getStdId();
				marksInfo.getExamInfo().getSubjectInfo();
				marksInfo.getExamInfo().getCourseInfo();
				marksInfo.getExamInfo().getInstSess();
				for(Batch_StdInfo btchStdInfo:marksInfo.getStdInfo().getBatch_StdInfoList()){
					btchStdInfo.getBatchInfo().getCourseInfo();
				}				
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return marksInfo;
		}
	}
	public MarksInfo getMarksInfoByExam(ExamInfo exmInfo){

		MarksInfo marksInfo= new MarksInfo();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<MarksInfo> marksInfoList=session.createCriteria(MarksInfo.class)
					.add(Restrictions.eq("examInfo", exmInfo))
					.list();
			if(marksInfoList!=null&&!marksInfoList.isEmpty()){
				marksInfo=marksInfoList.get(0);
				marksInfo.getStdInfo().getStdId();
				marksInfo.getExamInfo().getSubjectInfo();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return marksInfo;
		}
	}
	public List<StdWorkExp> getStdWorkExpList(StudentInfo stdInfo){
		Session session=sessionFactory.openSession();
		List<StdWorkExp> stdWorkExpList=new ArrayList<StdWorkExp>();
		try {
			session.beginTransaction();
			stdWorkExpList=session.createCriteria(StdWorkExp.class)
					.add(Restrictions.eq("stdInfo", stdInfo))
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return stdWorkExpList;
	}
	public void updateCurrWorkExpFalse(StdWorkExp stdWorkExp){
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.createSQLQuery("update WORKEXP set ISCURRENT=false where STDINFO="+stdWorkExp.getStdInfo().getStdId()).executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public List<CourseInfo> getProfessionalCourseList(StudentInfo stdInfo){
		List<CourseInfo> courseInfoList=new ArrayList<CourseInfo>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			courseInfoList=session.createCriteria(Course_StdInfo.class)
					.add(Restrictions.eq("stdInfo",stdInfo))
					.createAlias("courseInfo", "crsInfo")
					.add(Restrictions.eq("crsInfo.isProfessional", true))
					.setProjection(Projections.property("courseInfo"))
					.list();
			System.out.println(courseInfoList.size()+"*************DDFF*D**D**D*D**D**F*F*D*");			

			for(CourseInfo crsInfo:courseInfoList)
				System.out.println(crsInfo.getCourseName()+"...............................");
					session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return courseInfoList;
	}
	public List<Achievement> getAchievementList(StudentInfo stdInfo){
		List achievementList=new ArrayList();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			achievementList=session.createCriteria(Achievement.class)
					.add(Restrictions.eq("stdInfo",stdInfo))
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return achievementList;
	}
	public void insertProfilePic(ProfilePic profilePic){
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.createSQLQuery("update PROFILEPIC set ISCURRENT=false where STDINFO="+profilePic.getStdInfo().getStdId()).executeUpdate();
			session.getTransaction().commit();
			session.beginTransaction();
			insertObject(profilePic);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ProfilePic getStdProfilePic(StudentInfo stdInfo){
		Session session=sessionFactory.openSession();
		ProfilePic profPic=null;
		try {
			session.beginTransaction();

			List profPicList=session.createCriteria(ProfilePic.class)
					.add(Restrictions.eq("stdInfo",stdInfo))
					.add(Restrictions.eq("isCurrent", true))
					.list();
			if(!profPicList.isEmpty())
				profPic=(ProfilePic)profPicList.get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return profPic;
	}
	public ProfilePic getDefaultPic(){
		Session session=sessionFactory.openSession();
		ProfilePic profPic=new ProfilePic();
		try {
			session.beginTransaction();
			profPic=(ProfilePic)session.createCriteria(ProfilePic.class)
					.add(Restrictions.eq("picId", 5))
					.list().get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profPic;
	}
	public Achievement getAchievementById(int pk){
		Session session=sessionFactory.openSession();
		Achievement achieve=new Achievement();
		try {
			session.beginTransaction();
			achieve=(Achievement)session.createCriteria(Achievement.class)
					.add(Restrictions.eq("achieveId", pk))
					.list().get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achieve;
	}
	/*public List<UserPreference> getUsrPref4mPage(List<String> strList){

		Session session=sessionFactory.openSession();
		Page page=new Page();
		List<UserPreference> usrPrefList=new ArrayList<UserPreference>();
		try {
			session.beginTransaction();
			for(String str:strList){
			String [] toks=str.split("~");
			page=(Page)session.createCriteria(Page.class)
					.add(Restrictions.eq("usrPrefId", Integer.parseInt(toks[0])))
					.list().get(0);

			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return page;
	}*/

	public List<FeeType> feeType() {
		// TODO Auto-generated method stub
		return null;
	}
}

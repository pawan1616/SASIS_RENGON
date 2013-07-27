package com.technobright.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
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
import com.technobright.entities.fee.Installments;
import com.technobright.entities.fee.TotalCourseFee;


public class DAOFeeImpl  implements DAOFeeInterface{
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<FeeType> feeType(){

		List<FeeType> feeTypeList=new ArrayList<FeeType>();
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			feeTypeList=session.createCriteria(FeeType.class)
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
		return feeTypeList;
	}
	public FeeType getFeeTypeById(long pk){

		FeeType feeType=null;
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<FeeType> feeTypeList=session.createCriteria(FeeType.class)
					.add(Restrictions.eq("feeTypeId", pk))
					.list();
			if(feeType!=null&&!feeTypeList.isEmpty()){
				feeType=feeTypeList.get(0);
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
		return feeType;
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

	public void insertObject(Object obj, List<Object> objList){
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			for(Object transObj:objList){
				session.merge(transObj);
			}
			session.getTransaction().commit();
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
	
	public TotalCourseFee getActiveTotalFee(CourseInfo courseInfo) {
		List<TotalCourseFee> ttlFeeList=getTotalCourseFeeList(courseInfo, false);
		if(ttlFeeList!=null&&!ttlFeeList.isEmpty()){
			return ttlFeeList.get(0);
		}else
			return null;
		
	}

	public List<TotalCourseFee> getTotalCourseFeeList(CourseInfo courseInfo,
			boolean isHistory) {
		
		List<TotalCourseFee> totalCourseFeeList=null;
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			totalCourseFeeList=session.createCriteria(TotalCourseFee.class)
					.add(Restrictions.eq("courseInfo", courseInfo))
					.add(Restrictions.eq("isHistory", isHistory))
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
		return totalCourseFeeList;
	}
	public void insertInstallments(List<Installments> installList){
		Session session=sessionFactory.openSession();
		try {
			long groupId=1;
			session.beginTransaction();
			List<Long> listi=session.createCriteria(Installments.class)
									.setProjection(Projections.max("installmentGroupId"))
									.list();
			groupId=listi.get(0)!=null?listi.get(0)+1:1;
			session.getTransaction().commit();
			
			session.beginTransaction();
	         for ( int i=0; i<installList.size(); i++ ) {
	        	 Installments install=installList.get(i);
	        	 install.setInstallmentGroupId(groupId);
	            session.save(install);
	         	if( i % 50 == 0 ) {
	               session.flush();
	               session.clear();
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
	}
	public List<Installments> getCourseInstallments(CourseInfo courseInfo,boolean isHistory){
		
		List<Installments> installmentList=null;
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			installmentList=session.createCriteria(Installments.class)
					.add(Restrictions.eq("courseInfo", courseInfo))
					.add(Restrictions.eq("isHistory", isHistory))
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
		return installmentList;
	}
}

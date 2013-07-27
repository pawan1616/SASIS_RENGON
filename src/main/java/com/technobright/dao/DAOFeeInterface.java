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
import com.technobright.entities.fee.Installments;
import com.technobright.entities.fee.TotalCourseFee;

public interface DAOFeeInterface{
	public void insertObject(Object obj);
	public void insertObject(Object obj, List<Object> objList);
	public List<FeeType> feeType();
	public FeeType getFeeTypeById(long pk);
	public TotalCourseFee getActiveTotalFee(CourseInfo courseInfo);
	public List<TotalCourseFee> getTotalCourseFeeList(CourseInfo courseInfo, boolean isHistory);
	
	public void insertInstallments(List<Installments> installList);
	public List<Installments> getCourseInstallments(CourseInfo courseInfo,boolean isHistory);
}

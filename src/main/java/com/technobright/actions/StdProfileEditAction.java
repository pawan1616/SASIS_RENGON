package com.technobright.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.technobright.dao.DAOInterface;
import com.technobright.entities.StudentInfo;

public class StdProfileEditAction extends ActionSupport{

		private DAOInterface dao;
		private StudentInfo stdInfo;
	
		public DAOInterface getDao() {
			return dao;
		}

		public StudentInfo getStdInfo() {
			return stdInfo;
		}

		public void setDao(DAOInterface dao) {
			this.dao = dao;
		}

		public void setStdInfo(StudentInfo stdInfo) {
			this.stdInfo = stdInfo;
		}

		public String execute(){
			return SUCCESS;
		}
}

package com.yash.ppmtool.test;

import java.util.Date;

import com.yash.ppmtool.dao.ProjectDAO;
import com.yash.ppmtool.daoimpl.ProjectDAOImpl;
import com.yash.ppmtool.db.DbUtil;
import com.yash.ppmtool.domain.Project;

public class DatabaseTest extends DbUtil {

	public static void main(String[] args) {
		
		ProjectDAO projectDAO=new ProjectDAOImpl();
		Project project=new Project();
		
		project.setName("test5");
		project.setDescription("test desc");
		project.setProject_identifier("test05");
		project.setStart_date(new Date());
		project.setEnd_date(new Date());
		project.setCreated_date(new Date());
		project.setUpdated_date(new Date());
		projectDAO.save(project);
		System.out.println("project added");

	}

}

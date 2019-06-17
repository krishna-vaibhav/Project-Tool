package com.yash.ppmtool.test;

import java.util.Date;

import com.yash.ppmtool.dao.ProjectDAO;
import com.yash.ppmtool.daoimpl.ProjectDAOImpl;
import com.yash.ppmtool.domain.Project;

public class UpdateTest {

	public static void main(String[] args) {
		ProjectDAO projectDAO=new ProjectDAOImpl();
		Project project=new Project();
		project.setId(4l);
		project.setName("test4");
		project.setDescription("test desc");
		project.setProject_identifier("test04");
		project.setStart_date(new Date());
		project.setEnd_date(new Date());
		project.setCreated_date(new Date());
		project.setUpdated_date(new Date());
		projectDAO.update(project);
		System.out.println("project updated");

	}

}

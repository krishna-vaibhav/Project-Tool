package com.yash.ppmtool.test;

import java.util.Date;

import com.yash.ppmtool.domain.Project;
import com.yash.ppmtool.exception.ProjectException;
import com.yash.ppmtool.service.ProjectService;
import com.yash.ppmtool.serviceimpl.ProjectServiceImpl;

public class ProjectServiceCreateProjectTest {

	public static void main(String[] args) {
		ProjectService projectDAO=new ProjectServiceImpl();
		Project project=new Project();
		project.setName("test2");
		project.setDescription("test desc");
		project.setProject_identifier("te02");
		project.setStart_date(new Date());
		project.setEnd_date(new Date());
		project.setCreated_date(new Date());
		project.setUpdated_date(new Date());
		try {
			projectDAO.createProject(project);
			System.out.println("inserted");
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
		

	}

}

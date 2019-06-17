package com.yash.ppmtool.test;

import java.util.Date;

import com.yash.ppmtool.domain.Project;
import com.yash.ppmtool.exception.ProjectException;
import com.yash.ppmtool.service.ProjectService;
import com.yash.ppmtool.serviceimpl.ProjectServiceImpl;

public class ProjectServiceUpdateProjectTest {

	public static void main(String[] args) {
		ProjectService projectService=new ProjectServiceImpl();
		Project project=new Project();
		project.setId(4l);
		project.setName("test1");
		project.setDescription("my test");
		project.setProject_identifier("te01");
		project.setEnd_date(new Date());
		project.setUpdated_date(new Date());
		try {
			projectService.updateProject(project);
			System.out.println("project updated");
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}

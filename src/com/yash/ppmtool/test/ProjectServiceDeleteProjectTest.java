package com.yash.ppmtool.test;

import com.yash.ppmtool.exception.ProjectException;
import com.yash.ppmtool.service.ProjectService;
import com.yash.ppmtool.serviceimpl.ProjectServiceImpl;

public class ProjectServiceDeleteProjectTest {

	public static void main(String[] args) {
		ProjectService projectService=new ProjectServiceImpl();
		try {
			projectService.deleteByProjectIdentifier("TE05");
			System.out.println("project deleted");
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
		

	}

}

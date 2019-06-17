package com.yash.ppmtool.test;

import java.util.List;

import com.yash.ppmtool.domain.Project;
import com.yash.ppmtool.exception.ProjectException;
import com.yash.ppmtool.service.ProjectService;
import com.yash.ppmtool.serviceimpl.ProjectServiceImpl;

public class ProjectServiceListProjectTest {

	public static void main(String[] args) {
		ProjectService projectService=new ProjectServiceImpl();
		try {
			List<Project>list=projectService.listProjects();
			for (Project project : list) {
				System.out.println(project);
			}
		} catch (ProjectException e) {
			System.out.println(e.getMessage());
		}
		

	}

}

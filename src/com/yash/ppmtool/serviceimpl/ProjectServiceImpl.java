package com.yash.ppmtool.serviceimpl;

import java.util.Date;
import java.util.List;

import com.yash.ppmtool.dao.ProjectDAO;
import com.yash.ppmtool.daoimpl.ProjectDAOImpl;
import com.yash.ppmtool.domain.Project;
import com.yash.ppmtool.exception.ProjectException;
import com.yash.ppmtool.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {

	private ProjectDAO projectDAO = null;

	public ProjectServiceImpl() {
		projectDAO = new ProjectDAOImpl();
	}

	@Override
	public void createProject(Project project) throws ProjectException {
		// fetch all data from prjects table based on project_identifier
		Project proj = projectDAO.find(project.getProject_identifier().toUpperCase());
		System.out.println(proj);
		// if project is null, throw projectexception
		if (proj != null) {
			throw new ProjectException("project_identifier is already exist");
		}
		// otherwise project created
		else {
			project.setCreated_date(new Date());
			project.setUpdated_date(new Date());
			projectDAO.save(project);
		}
	}

	@Override
	public List<Project> listProjects() throws ProjectException {
		// fetch projects from projects table
		List<Project> projects = projectDAO.findAll();
		// if project not available then throw Project exception
		if (projects.isEmpty()) {
			throw new ProjectException("No any project available in your dashboard");
		}
		// otherwise return list of projects
		else {
			return projects;
		}
	}

	@Override
	public void deleteByProjectIdentifier(String project_identifier) throws ProjectException {

		//fetch all data from prjects table based on project_identifier
		Project proj = projectDAO.find(project_identifier.toUpperCase());
		//if project is not null, delete project
		if (proj != null) {
			projectDAO.delete(project_identifier);
		}
		//otherwise throw projectexception
		else {
			throw new ProjectException("project is not available in your dashboard");
		}

	}

	@Override
	public void updateProject(Project project) throws ProjectException {
		// fetch all data from prjects table based on project_identifier
		System.out.println("service");
		Project proj = projectDAO.find(project.getProject_identifier().toUpperCase());
		// if project created
		if(proj != null) {
			project.setCreated_date(proj.getCreated_date());
			project.setUpdated_date(new Date());
			projectDAO.update(project);
		}
		// otherwise project is null, throw projectexception
		else {
			throw new ProjectException("project_identifier is not available in your dashboard");
		}
	}

}

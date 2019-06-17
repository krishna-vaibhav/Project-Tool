package com.yash.ppmtool.service;

import java.util.List;

import com.yash.ppmtool.domain.Project;
import com.yash.ppmtool.exception.ProjectException;
/**
 * bussiness logic present in projectService
 * @author rucha.chaudhari
 *
 */
public interface ProjectService {
	/**
	 * this method insert data in projects table
	 * @param project  to be inserted
	 * @throws projectexception if project_identifier is already available
	 */
	void createProject(Project project) throws ProjectException;
	/**
	 * it give all projects from table projects
	 * @return return list of project
	 * @throws ProjectException if there is no project available in projects table
	 */
	List<Project> listProjects() throws ProjectException;

	/**
	 * this method delete the project based on project_identifier
	 * @param project_identifier o be deleted
	 * @throws ProjectException if project_identifier is not available in projects table
	 */
	void deleteByProjectIdentifier(String project_identifier) throws ProjectException;
	/**
	 * updateproject methid update the project based on project_identifier
	 * @param project to be updated
	 * @throws ProjectException if project is not available in projects table
	 */
	void updateProject(Project project) throws ProjectException;

}

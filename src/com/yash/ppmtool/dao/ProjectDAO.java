package com.yash.ppmtool.dao;

import java.util.List;

import com.yash.ppmtool.domain.Project;


/**
 * projectDAO	is interface
 * @author rucha.chaudhari
 *
 */
public interface ProjectDAO {
	/**
	 * save method for insert the project details in project table
	 * @param project parameter inserted in table
	 */
	void save(Project project);
	/**
	 * delete method for delete the project from projects table
	 * @param id delete project based on project_identifier
	 */
	void delete(String project_identifier);
	/**
	 * findAll method give list of all projects from projects table
	 * @return list of all projects if fount otherwise return null
	 */
	List<Project> findAll();
	/**
	 * find method give the project information based on id
	 * @param id find that project 
	 * @return project if find otherwise retun null
	 */
	Project find(String project_identifier);
	/**
	 * update method update the project based on project
	 * @param project update that project
	 */
	void update(Project project);

}

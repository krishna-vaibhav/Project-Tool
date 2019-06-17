package com.yash.ppmtool.domain;

import java.util.Date;

import com.yash.ppmtool.util.DateUtil;
/**
 * project model for data transfer
 * @author rucha.chaudhari
 *
 */
public class Project {
	/**
	 * id for project
	 */
	private Long id;
	/**
	 * name of the project
	 */
	private String name;
	/**
	 * short description of project
	 */
	private String description;
	/**
	 * start date of project
	 */
	private Date start_date;
	/**
	 * end date of project
	 */
	private Date end_date;
	/**
	 * project creation date
	 */
	private Date created_date;
	/**
	 * project updation date. it should be last updated date
	 */
	private Date updated_date;
	/**
	 * project_identifier is used for backlog
	 */
	private String project_identifier;
	// default constructor is mandatory in web services 
	public Project() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	

	public String getProject_identifier() {
		return project_identifier;
	}

	public void setProject_identifier(String project_identifier) {
		this.project_identifier = project_identifier;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", start_date=" + DateUtil.getDateTOString(start_date)
				+ ", end_date=" + DateUtil.getDateTOString(end_date) + ", created_date=" + DateUtil.getDateTOString(created_date) + ", updated_date=" + DateUtil.getDateTOString(updated_date)
				+ ", project_identifier=" + project_identifier + "]";
	}


}

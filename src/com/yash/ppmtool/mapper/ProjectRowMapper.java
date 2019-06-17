package com.yash.ppmtool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yash.ppmtool.domain.Project;

public class ProjectRowMapper {

	public List<Project> mapProjects(List<Project> projectList, ResultSet rs) throws SQLException {
		Project project;
		while (rs.next()) {
			project = new Project();
			project.setId(rs.getLong("id"));
			project.setName(rs.getString("name"));
			project.setDescription(rs.getString("description"));
			project.setStart_date(rs.getTimestamp("start_date"));
			project.setEnd_date(rs.getTimestamp("end_date"));
			project.setCreated_date(rs.getTimestamp("created_date"));
			project.setUpdated_date(rs.getTimestamp("updated_date"));
			project.setProject_identifier(rs.getString("project_identifier"));
			projectList.add(project);
		}
		return projectList;
	}

	public Project mapProject(Project project, ResultSet rs) throws SQLException {
		if (rs.next()) {
			project=new Project();
			project.setId(rs.getLong("id"));
			project.setName(rs.getString("name"));
			project.setDescription(rs.getString("description"));
			project.setStart_date(rs.getTimestamp("start_date"));
			project.setEnd_date(rs.getTimestamp("end_date"));
			project.setCreated_date(rs.getTimestamp("created_date"));
			project.setUpdated_date(rs.getTimestamp("updated_date"));
			project.setProject_identifier(rs.getString("project_identifier"));
		}
		
		return project;
	}
}

package com.yash.ppmtool.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.ppmtool.dao.ProjectDAO;
import com.yash.ppmtool.db.DbUtil;
import com.yash.ppmtool.domain.Project;
import com.yash.ppmtool.mapper.ProjectRowMapper;
import com.yash.ppmtool.util.DateUtil;

public class ProjectDAOImpl extends DbUtil implements ProjectDAO{
	
	private ProjectRowMapper projectRowMapper = null;
	public ProjectDAOImpl() {
		projectRowMapper = new ProjectRowMapper();
	}

	@Override
	public void save(Project project) {
		String sql="insert into projects"
				+ "(name,"
				+ "description,"
				+ "start_date,"
				+ "end_date,"
				+ "created_date,"
				+ "updated_date,"
				+ "project_identifier) values(?,?,?,?,?,?,?)";
		PreparedStatement psmt=preparedStatement(sql);
		System.out.println(sql);
		try {
			psmt.setString(1, project.getName());
			psmt.setString(2, project.getDescription());
			psmt.setTimestamp(3, DateUtil.toDate(project.getStart_date()));
			psmt.setTimestamp(4, DateUtil.toDate(project.getEnd_date()));
			psmt.setTimestamp(5, DateUtil.toDate(project.getCreated_date()));
			psmt.setTimestamp(6, DateUtil.toDate(project.getUpdated_date()));
			psmt.setString(7, project.getProject_identifier().toUpperCase());
			psmt.execute();
			System.out.println(psmt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String project_identifier) {
		String sql="delete from projects where project_identifier ='"+project_identifier+"'";
		PreparedStatement psmt=preparedStatement(sql);
		try {
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public List<Project> findAll() {
		String sql = "select * from projects";
		PreparedStatement psmt = preparedStatement(sql);
		
		List<Project> projectList = new ArrayList<Project>();
		try {
			ResultSet rs = psmt.executeQuery();
			projectList = projectRowMapper.mapProjects(projectList, rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
		
	}
	
	@Override
	public Project find(String project_identifier) {

		String sql = "select * from projects where project_identifier='"+project_identifier+"'";
		PreparedStatement psmt = preparedStatement(sql);
		Project project = null;
		try {
			ResultSet rs = psmt.executeQuery();
			project = projectRowMapper.mapProject(project, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}


	@Override
	public void update(Project project) {
		String sql = "update projects set "
				+ "name=? ,"
				+ "description=?, "
				+ "start_date=?, "
				+ "end_date=? ,"
				+ "created_date =?,"
				+ "updated_date =?, "
				+ "project_identifier =?"
				+ " where project_identifier=?";
		PreparedStatement psmt = preparedStatement(sql);
		System.out.println(sql);
		try {
			psmt.setString(1, project.getName());
			psmt.setString(2, project.getDescription());
			psmt.setTimestamp(3, DateUtil.toDate(project.getStart_date()));
			psmt.setTimestamp(4, DateUtil.toDate(project.getEnd_date()));
			psmt.setTimestamp(5, DateUtil.toDate(project.getCreated_date()));
			psmt.setTimestamp(6, DateUtil.toDate(project.getUpdated_date()));
			psmt.setString(7, project.getProject_identifier());
			psmt.setString(8, project.getProject_identifier());
			psmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

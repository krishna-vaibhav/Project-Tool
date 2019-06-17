package com.yash.ppmtool.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.yash.ppmtool.domain.Project;
import com.yash.ppmtool.exception.ProjectException;
import com.yash.ppmtool.service.ProjectService;
import com.yash.ppmtool.serviceimpl.ProjectServiceImpl;
import com.yash.ppmtool.util.DateUtil;


@WebServlet("/UpdateProjectController")
public class UpdateProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(UpdateProjectController.class);
	private ProjectService projectService= null;
    public UpdateProjectController() {
    	 projectService=new ProjectServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		Project project=new Project();
		project.setName(request.getParameter("name"));
		project.setProject_identifier(request.getParameter("project_identifier"));
		project.setDescription(request.getParameter("description"));
		Date date =DateUtil.stringToDate(request.getParameter("start_date"));
		project.setStart_date(date);
		date =DateUtil.stringToDate(request.getParameter("end_date"));
		project.setEnd_date(date);
		System.out.println(request.getParameter("project_identifier"));
		
		try {
			projectService.updateProject(project);
		} catch (ProjectException e) {
			Log.info(e.getMessage());
		}
		request.getRequestDispatcher("view/dashboard.jsp").forward(request, response);
	}
}

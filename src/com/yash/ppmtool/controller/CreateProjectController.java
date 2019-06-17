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

/**
 * Servlet implementation class CreateProjectController
 */
@WebServlet("/CreateProjectController")
public class CreateProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(CreateProjectController.class);
	private ProjectService projectService= null;
	
    public CreateProjectController() {
        projectService=new ProjectServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		Project project=new Project();
		project.setName(request.getParameter("name"));
		project.setProject_identifier(request.getParameter("project_identifier"));
		project.setDescription(request.getParameter("description"));
		Date date =DateUtil.stringToDate(request.getParameter("start_date"));
		System.out.println(date);
		project.setStart_date(date);
		date =DateUtil.stringToDate(request.getParameter("end_date"));
		System.out.println(date);
		project.setEnd_date(date);
		try {
			projectService.createProject(project);
		} catch (ProjectException e) {
			Log.info(e.getMessage());
		}
		request.getRequestDispatcher("view/dashboard.jsp").forward(request, response);
	}

}

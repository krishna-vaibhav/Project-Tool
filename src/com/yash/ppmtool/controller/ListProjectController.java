package com.yash.ppmtool.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Servlet implementation class ListProjectController
 */
@WebServlet("/ListProjectController")
public class ListProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger Log = Logger.getLogger(ListProjectController.class);
	private ProjectService projectService= null;
 
    public ListProjectController() {
    	 projectService=new ProjectServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Project> list=new ArrayList<>();
	
		try {
			 list=projectService.listProjects();
				System.out.println(list);
		} catch (ProjectException e) {
			Log.info(e.getMessage());
		}
		request.setAttribute("projectlist", list);
		request.getRequestDispatcher("view/dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

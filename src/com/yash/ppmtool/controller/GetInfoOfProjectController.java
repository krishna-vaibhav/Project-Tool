package com.yash.ppmtool.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.ppmtool.dao.ProjectDAO;
import com.yash.ppmtool.daoimpl.ProjectDAOImpl;
import com.yash.ppmtool.domain.Project;


@WebServlet("/GetInfoOfProjectController")
public class GetInfoOfProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ProjectDAO projectDAO=null;
    
    public GetInfoOfProjectController() {
      projectDAO=new ProjectDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		String project_identifier=request.getParameter("project_identifier");
		Project project= projectDAO.find(project_identifier.toUpperCase());
		request.setAttribute("project", project);
		request.getRequestDispatcher("projectUpdateForm.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

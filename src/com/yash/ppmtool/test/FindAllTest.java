package com.yash.ppmtool.test;

import java.util.List;

import com.yash.ppmtool.dao.ProjectDAO;
import com.yash.ppmtool.daoimpl.ProjectDAOImpl;
import com.yash.ppmtool.domain.Project;

public class FindAllTest {

	public static void main(String[] args) {
		
		ProjectDAO projectDAO=new ProjectDAOImpl();
		List<Project>list=  projectDAO.findAll();
		for (Project projects : list) {
			System.out.println(projects);
		}
	}

}

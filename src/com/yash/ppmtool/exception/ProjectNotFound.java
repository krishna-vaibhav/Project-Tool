package com.yash.ppmtool.exception;

public class ProjectNotFound extends Exception {
	
	public ProjectNotFound()
	{
		super();
	}
	public ProjectNotFound(String errMsg)
	{
		super(errMsg);
	}

}

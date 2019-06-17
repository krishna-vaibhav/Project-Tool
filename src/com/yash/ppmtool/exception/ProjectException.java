package com.yash.ppmtool.exception;

public class ProjectException extends Exception {
	
	/**
	 * projectException throws without error message
	 */
	public ProjectException() {
		super();
	}
	/**
	 * projectException throws with error message
	 * @param errMsg to be message for exception 
	 */
	public ProjectException(String errMsg){
		super(errMsg);
	}

}

package com.example.InterFace.Web.ExceptionHandler;

public class AccessDeniedException extends RuntimeException {
	
	
	public AccessDeniedException(String msg) {
		
		super(msg);
	}

}

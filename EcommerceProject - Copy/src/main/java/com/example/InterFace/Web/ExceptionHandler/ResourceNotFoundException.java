package com.example.InterFace.Web.ExceptionHandler;


public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}

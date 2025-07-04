package com.example.InterFace.Web.ExceptionHandler;

public class BadRequestException extends RuntimeException {
	
	
	public BadRequestException(String msg) {
		
		super(msg);
	}

}

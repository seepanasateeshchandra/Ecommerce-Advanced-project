package com.example.InterFace.Web.ResponseDTO;

public class AuthResponse {
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

	public AuthResponse(String token) {
		super();
		this.token = token;
	}

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

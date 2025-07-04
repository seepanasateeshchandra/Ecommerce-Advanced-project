package com.example.InterFace.Web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.InterFace.Web.Entity.UserDetails;
import com.example.InterFace.Web.RequestDTO.AuthRequest;
import com.example.InterFace.Web.RequestDTO.UserDTO;
import com.example.InterFace.Web.Service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody UserDTO user){
		
		System.out.println(user);	
		
		System.out.println("Request Came from AuthController: ");
		String result = authService.registerUser(user);
		
		
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
		
		
		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AuthRequest request){
		
		String token = authService.login(request);
		
		
		
		
		
		System.out.println(request);
		
		
		if(token == null) {
		
		return new ResponseEntity<String>("user Not Registered",HttpStatus.NOT_FOUND);
		
		}else {
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Authorization", token);
			
		return new ResponseEntity<String>("User Successfully Logined",responseHeaders,HttpStatus.OK);
			
		}
		
	}
	
	
	
	
	

}

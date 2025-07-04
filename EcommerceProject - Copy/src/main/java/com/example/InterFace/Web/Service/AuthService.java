package com.example.InterFace.Web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.InterFace.Web.Entity.Role;
import com.example.InterFace.Web.Entity.UserDetails;
import com.example.InterFace.Web.Repository.UserRepository;
import com.example.InterFace.Web.RequestDTO.AuthRequest;
import com.example.InterFace.Web.RequestDTO.UserDTO;
import com.example.InterFace.Web.Security.JWTToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; 

@Service
public class AuthService {
	
	@Autowired
	JWTToken jwtToken;
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	
	
	
	
	private Role mapRole(String roleString) {
	    try {
	        return Role.valueOf(roleString.toUpperCase()); // Converts "user" to Role.USER
	    } catch (IllegalArgumentException | NullPointerException ex) {
	        // Fallback to USER or throw error
	        return Role.USER;
	        // OR throw new BadRequestException("Invalid role: " + roleString);
	    }
	}

	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;

	public String registerUser(UserDTO user) {
		// TODO Auto-generated method stub
		
		UserDetails newUser = new UserDetails();
		
		
		System.out.println("request came to service: ");
		
		
		
		
		
		
		
		newUser.setEmailId(user.getEmailId());
		newUser.setName(user.getName());
		newUser.setRole(mapRole(user.getRole()));

		
		
		System.out.println(mapRole(user.getRole()));
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		newUser.setGender(user.getGender());
		newUser.setPhone(user.getPhoneNumber());
		
		userRepository.save(newUser);
		
		
		return "User Details Successfully Registered";
		
		
		
		
	}

	public String login(AuthRequest request) {
		// TODO Auto-generated method stub
		String token = null;
		
		this.doAuthenticate(request.getEmail(),request.getPassword());
		
		
		token = this.jwtToken.generateToken(request.getEmail());
		
		return token;
	}
	
	
	
	private void doAuthenticate(String emailId, String password) { 
		   
		
		UsernamePasswordAuthenticationToken authentication = new      
		UsernamePasswordAuthenticationToken(emailId, password); 
		 try { 
		  authenticationManager.authenticate(authentication); 
		 } catch (BadCredentialsException e) { 
		   throw new RuntimeException("Invalid UserName and Password"); 
		 } 
		 }
	
	
	

}

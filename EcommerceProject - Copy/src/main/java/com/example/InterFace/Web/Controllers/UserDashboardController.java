package com.example.InterFace.Web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InterFace.Web.RequestDTO.UserDashboardDTO;
import com.example.InterFace.Web.Service.UserServiceDashBoard;
import com.example.InterFace.Web.UserDashboardResponse.UserDashboardResponse;

@RequestMapping("/api/user")
@RestController
public class UserDashboardController {
	
	@Autowired
	private UserServiceDashBoard userService;
	
	@GetMapping("/dashboard/{emailId}")
	public ResponseEntity<UserDashboardResponse> getDashboardInfo(@PathVariable String emailId){
		
		
		return ResponseEntity.ok(userService.getUserDashBoard(emailId));
	}

}

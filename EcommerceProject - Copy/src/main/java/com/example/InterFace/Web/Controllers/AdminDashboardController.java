package com.example.InterFace.Web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InterFace.Web.RequestDTO.AdminDashboardResponse;
import com.example.InterFace.Web.Service.AdminDashBoardService;

@RequestMapping("/api/admin")
@RestController
public class AdminDashboardController {
	@Autowired
	private AdminDashBoardService adminService;
	
    @GetMapping("/dashboard")
	public AdminDashboardResponse getDashBoard() {
		
		return adminService.getDashboardDetails();
		
	}
	
}

package com.example.InterFace.Web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.InterFace.Web.RequestDTO.UserDTO;
import com.example.InterFace.Web.Service.UserServiceImpl;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	
	@Autowired
	private UserServiceImpl userService;
	
	
	
	
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@GetMapping("/profile")
    public ResponseEntity<UserDTO> getProfile(@AuthenticationPrincipal UserDetails user) {
    	
    	System.out.println("Request came here now");
        return ResponseEntity.ok(userService.getProfile(user.getUsername()));
    }
     
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateProfile(@AuthenticationPrincipal UserDetails user,
                                                 @Valid @RequestBody UserDTO userDetails) {
        return ResponseEntity.ok(userService.updateProfile(user.getUsername(), userDetails));
    }
    
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@AuthenticationPrincipal UserDetails user) {
        userService.deleteUser(user.getUsername());
        return ResponseEntity.ok("User deleted successfully");
    }
	

}

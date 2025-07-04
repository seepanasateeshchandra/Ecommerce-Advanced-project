package com.example.InterFace.Web.Service;

import com.example.InterFace.Web.RequestDTO.UserDTO;

public interface UserService {
	
	UserDTO getProfile(String emailId);
	
	UserDTO updateProfile(String emailId,UserDTO user);
	
	
	void deleteUser(String email);
	
	

}

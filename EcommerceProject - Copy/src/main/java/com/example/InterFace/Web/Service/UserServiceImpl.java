package com.example.InterFace.Web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.InterFace.Web.Entity.UserDetails;
import com.example.InterFace.Web.Repository.UserRepository;
import com.example.InterFace.Web.RequestDTO.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	

	@Override
	public UserDTO getProfile(String emailId) {
		// TODO Auto-generated method stub
		
		UserDetails user = userRepository.findByEmailId(emailId).orElseThrow(()->new UsernameNotFoundException("User not found"));
		
		
		return toDTO(user);
	}

	@Override
	public UserDTO updateProfile(String emailId, UserDTO user) {
		
		
		System.out.println(emailId);
		
		UserDetails ExistingUser = userRepository.findByEmailId(emailId).orElseThrow(()-> new UsernameNotFoundException("User not found"));
		
		ExistingUser.setName(user.getName());
		ExistingUser.setGender(user.getGender());
		ExistingUser.setPhone(user.getPhoneNumber());
		ExistingUser.setEmailId(user.getEmailId());
		
		System.out.println(user);
		System.out.println(user.getPassword());
		
		ExistingUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		userRepository.save(ExistingUser);
		
		return toDTO(ExistingUser);
	}

	@Override
	public void deleteUser(String email) {
		// TODO Auto-generated method stub
		
		
		UserDetails user = userRepository.findByEmailId(email).orElseThrow(()-> new UsernameNotFoundException("user Not Found"));
		
		userRepository.delete(user);
		
	}
	
	
	private UserDTO toDTO(UserDetails user) {
		
		UserDTO toUser = new UserDTO();
		
		toUser.setName(user.getName());
		toUser.setGender(user.getGender());
		toUser.setEmailId(user.getEmailId());
		
		
		toUser.setPhoneNumber(user.getPhone());
		
		toUser.setRole(user.getRole().toString());
		
		
		
		
		return toUser;
	}

}

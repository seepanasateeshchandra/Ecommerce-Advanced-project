package com.example.InterFace.Web.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.InterFace.Web.Entity.*;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;


import com.example.InterFace.Web.Repository.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
@Component
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		UserDetails user = userRepository.findByEmailId(username).orElseThrow(()-> new UsernameNotFoundException("Invalid user Name"));
		
		
		// TODO Auto-generated method stub
		
	
	
	
	 return new org.springframework.security.core.userdetails.User(
	            user.getUsername(),
	            user.getPassword(),
	            true,  // enabled
	            true,  // accountNonExpired
	            true,  // credentialsNonExpired
	            true,  // accountNonLocked ✅ THIS FIXES YOUR ERROR
	            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + ((com.example.InterFace.Web.Entity.UserDetails) user).getRole().name()))

	        );
	}

}

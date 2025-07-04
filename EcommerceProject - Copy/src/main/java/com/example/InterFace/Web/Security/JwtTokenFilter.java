package com.example.InterFace.Web.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;



import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
	
	@Autowired
	JWTToken jwtToken;
	
	@Autowired
	JwtUserDetailsService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String token = request.getHeader("Authorization");
		
		String userName = null;
		
		if(token != null) {
			
			userName = this.jwtToken.getUserNameFromToken(token);
			
			
			
			
			
			
			
		}else {
			
			System.out.println("Token is Missing. Please Come with token");
			
			
		}
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			 UserDetails  userDetails= this.userService.loadUserByUsername(userName);
			 
			 Boolean isValidToken = this.jwtToken.validateToken(token, userDetails.getUsername());
			 
			 
			 
			 if(isValidToken) {
				 
				 
				 UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				 
				 authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 
				 SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			 }
			
			
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	
	

}

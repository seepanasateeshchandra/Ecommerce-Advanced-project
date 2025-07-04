package com.example.InterFace.Web.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme; 

@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Configuration
public class JwtAppSecurityConfig {
	
	
	Logger logger = LoggerFactory.getLogger(JwtAppSecurityConfig.class);
	
	@Autowired
	JwtTokenFilter jwtTokenFilter;
	
	
	 @Bean 
	 AuthenticationManager getAuthenticationManager(AuthenticationConfiguration    
	authenticationConfiguration) throws Exception { 
	  logger.info("Initilizing Bean AuthenticationManager"); 
	  return authenticationConfiguration.getAuthenticationManager(); 
	 } 
	  
	 @Bean 
	 BCryptPasswordEncoder getBCryptPasswordEncoder() { 
	  logger.info("Initilizing Bean BCryptPasswordEncoder"); 
	  return new BCryptPasswordEncoder(); 
	 }
	 
	 private static final String[] SWAGGER_WHITELIST = {
			  "/v3/api-docs/**",
			  "/swagger-ui/**"
			};
	 
	 
	 @Bean 
	 public SecurityFilterChain getSecurityFilterChain(HttpSecurity security) throws Exception { 
	   
	  logger.info("Configuring SecurityFilterChain Layer  of URl patterns"); 
	   
	  security.csrf(csrf -> csrf.disable()) 
	   .cors(cors -> cors.disable()) 
	   .authorizeHttpRequests( auth ->  auth
	            .requestMatchers("/user/login", "/user/register").permitAll()
	            .requestMatchers(SWAGGER_WHITELIST).permitAll()
	            .requestMatchers("/api/auth/**").permitAll()
	            .requestMatchers("/api/admin/**").hasRole("ADMIN")
	            .requestMatchers("/api/cart/**").hasRole("USER")
	            .requestMatchers("/api/orders/**").hasRole("USER")
	            .requestMatchers("/api/payments/**").hasRole("USER")
	            .requestMatchers("/api/admin/dashboard").hasRole("ADMIN")
	            .requestMatchers("/api/user/**").hasAnyRole("ADMIN","USER")
	            .requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")
	            .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()

	            .anyRequest().authenticated()
	        )
	        .addFilterBefore(this.jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

	                                           
	                                          return security.build();
	 
	 

}
	 
	 
	  @Bean
	    public OpenAPI openAPI() {
	        return new OpenAPI()
	                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
	                .components(
	                    new Components()
	                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
	                            .name("Authorization")
	                            .type(SecurityScheme.Type.HTTP)
	                            .scheme("bearer")
	                            .bearerFormat("JWT")
	                        )
	                );
	    }
	 
	 
}

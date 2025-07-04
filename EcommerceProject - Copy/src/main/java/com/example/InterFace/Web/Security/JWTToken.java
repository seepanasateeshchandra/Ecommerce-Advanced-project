package com.example.InterFace.Web.Security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTToken {
	
	
	
	
	
	
	
	 private static final String SECRET_KEY = "sateesh1234567891011121314151617189469463548545454548954854587457454985784574954545743587435495435495435669648957435953895345394534575794398";
	 
	 
	 private final long JWT_TOKEN_VALIDITY = 30*60000;

	//Decoding Secret Key 
    private SecretKey getSecretKey() { 
byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); 
return Keys.hmacShaKeyFor(keyBytes); 
    }
    
    
    public String generateToken(String emailId) {
    	
    	String token = null;
    	
    	token = Jwts.builder().subject(emailId).issuedAt(new Date(System.currentTimeMillis())).expiration(new java.util.Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY)).signWith(getSecretKey()).compact();
    	
    	return token;
    	
    }
    
    
    
    public String getUserNameFromToken(String token) {
    	
    	
    	return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }
    
    
    
  public boolean isTokenExpired(String token) {
		
		Date expirtyTime = Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload().getExpiration();
		
		System.out.println("Token Expiry Time : "+expirtyTime);
		
		return expirtyTime.after(new Date());
		
	}
  
  
  public boolean validateToken(String token,String userName) {
	  
	  String userIdFromToken = getUserNameFromToken(token);
	  
	  System.out.println("User Id Retrived From Token : "+userIdFromToken);
	  
	  
	  return userIdFromToken.equalsIgnoreCase(userName) && isTokenExpired(token);
	  
	  
  }
	
	
	

}

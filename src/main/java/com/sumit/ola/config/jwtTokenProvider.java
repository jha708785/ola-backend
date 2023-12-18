package com.sumit.ola.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class jwtTokenProvider {
	SecretKey key = Keys.hmacShaKeyFor(JwtSecurityContext.JET_KEY.getBytes());

	public String generateJwtToken (Authentication authentication) 
    {
			String jwt=Jwts.builder().setIssuer("Code with jha")
					.setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+86400000))
					.claim("email", authentication.getName())
					
					.signWith(key).compact();
			
			return jwt;
	}

	
	public String getEmailFromJwt(String jwt) {


		jwt=jwt.substring(7);
		
		Claims claims=Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
		
		String email =String.valueOf(claims.get("email"));
		
		return email;
				
	}
	
	
	
}

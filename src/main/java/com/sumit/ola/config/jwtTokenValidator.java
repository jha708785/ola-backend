package com.sumit.ola.config;

import java.io.IOException;


import javax.crypto.SecretKey;


import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

public class jwtTokenValidator extends OncePerRequestFilter 
{

	@Override
	protected void doFilterInternal(HttpServletRequest 
			request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException
	{

		
		
		String jwt=request.getHeader(JwtSecurityContext.JET_HEADER);
		if(jwt!=null) {
			try {
				
				jwt=jwt.substring(7);
				SecretKey key = Keys.hmacShaKeyFor(JwtSecurityContext.JET_KEY.getBytes());
				
				Claims claims=(Claims) Jwts.parserBuilder()
						.setSigningKey(key).build().parseClaimsJws(jwt).getBody();
				
				String username=String.valueOf(claims.get("email"));
				String authoritie=(String) claims.get("authorities");
				
				List<GrantedAuthority>authorities=
						AuthorityUtils.commaSeparatedStringToAuthorityList(authoritie);
				
				Authentication authentication=
						new UsernamePasswordAuthenticationToken(username, null,authorities);
				
				
				
			} 
			catch (Exception e)
			{
				throw new BadCredentialsException("Invalid Token received....error");
			}
			
			filterChain.doFilter(request, response);
		}
		
		

		
}
	
	
		
	
	

}

package com.sumit.ola.jwt;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.User;
import com.sumit.ola.repo.DriverRepo;
import com.sumit.ola.repo.UserRepo;


@Service
public class CustomUserDetails implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private DriverRepo dRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		List<GrantedAuthority>authorities=new ArrayList<>();
		
		User user = userRepo.findByEmail(username);
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User
					(user.getEmail(),user.getPassword(),authorities);
		}
		
		Driver driver = dRepo.findByEmail(username);
		
		if(driver!=null)
		{
			return new org.springframework.security.core.userdetails.User
					(driver.getEmail(),driver.getPassword(),authorities);
		}
		throw new UsernameNotFoundException("user not found with email :"+username);
	}

	
}

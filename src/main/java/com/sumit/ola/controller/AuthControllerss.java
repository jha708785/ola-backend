package com.sumit.ola.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.ola.Exception.UserException;
import com.sumit.ola.config.jwtTokenProvider;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.User;
import com.sumit.ola.enums.UserRole;
import com.sumit.ola.jwt.CustomUserDetails;
import com.sumit.ola.jwt.JwtResponse;
import com.sumit.ola.repo.DriverRepo;
import com.sumit.ola.repo.UserRepo;
import com.sumit.ola.request.LoginRequest;
import com.sumit.ola.request.SignupRequestDriver;
import com.sumit.ola.request.SignupRequestUser;
import com.sumit.ola.service.DriverService;

@RestController
@RequestMapping("/api")
public class AuthControllerss {

	private UserRepo userRepo;
	private DriverRepo dRepo;
	private jwtTokenProvider jwt;
	
	private PasswordEncoder encoder;
	
	
	private CustomUserDetails userdetailservice;
	
	private DriverService driverService;
	
	public AuthControllerss(UserRepo userRepo,
			DriverRepo dRepo,
			CustomUserDetails userdetailservice,
			DriverService driverService,
			PasswordEncoder encoder,jwtTokenProvider jwt)
	{
		this.userRepo=userRepo;
		this.dRepo=dRepo;
		this.encoder=encoder;
		this.jwt=jwt;
		this.userdetailservice=userdetailservice;
		this.driverService=driverService;
		
	}
	
	@PostMapping("/user/signup")
	public ResponseEntity<JwtResponse>signUpHeandler(@RequestBody SignupRequestUser signreq)
	{
		String email=signreq.getEmail();
		String fullname=signreq.getFullname();
		String mobile=signreq.getMobile();
		String password=signreq.getPassword();
		
		User emailuser = userRepo.findByEmail(email);
		if(emailuser!=null) {
			
			throw new UserException("user already registred...!!");
		}
		
		String passwords = encoder.encode(password);
		User user=new User();
		user.setEmail(email);
		user.setFullName(fullname);
		user.setMobile(mobile);
		user.setPassword(passwords);
		user.setRole(UserRole.USER);
		
		User saveuser = userRepo.save(user);
		
		Authentication authentication=new
				UsernamePasswordAuthenticationToken(saveuser.getEmail(),saveuser.getPassword());
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				String jwtString=jwt.generateJwtToken(authentication);
				
				JwtResponse jwtResponse=new JwtResponse();
				
				jwtResponse.setJwt(jwtString);
				jwtResponse.setAuthenticated(true);
				jwtResponse.setError(false);
				jwtResponse.setErrordetails(null);
				jwtResponse.setRoletype(UserRole.USER);
				jwtResponse.setMessage("Account created successfully..!!"+saveuser);
		
		return new ResponseEntity<JwtResponse>(jwtResponse,HttpStatus.OK);
		
	}
	
	@PostMapping("/driver/signup")
	public ResponseEntity<JwtResponse> driverSignin(@RequestBody SignupRequestDriver driverreq)
	{
		Driver driveremail = dRepo.findByEmail(driverreq.getEmail());
		
		JwtResponse response=new JwtResponse();
		
		if(driveremail!=null) {
			
			response.setAuthenticated(false);
			response.setErrordetails("email already registred try another email");
			response.setError(true);
			
			return new ResponseEntity<JwtResponse>(response,HttpStatus.BAD_REQUEST);
		}
		
		Driver createDriver=driverService.registerDriver(driverreq);
		
		
		Authentication authentication=new
				UsernamePasswordAuthenticationToken(createDriver.getEmail(),createDriver.getPassword());
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				String jwtString=jwt.generateJwtToken(authentication);
		
		response.setJwt(jwtString);
		response.setAuthenticated(true);
		response.setError(false);
		response.setErrordetails(null);
		response.setRoletype(UserRole.DRIVER);
		response.setMessage("Account created successfully..!!"+createDriver.getName());

return new ResponseEntity<JwtResponse>(response,HttpStatus.OK);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse>signin(@RequestBody LoginRequest loginreq)
	{
		String email = loginreq.getEmail();
		String password = loginreq.getPassword();
		
		Authentication authentication=authenticate(email,password);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwtString=jwt.generateJwtToken(authentication);
		JwtResponse response=new JwtResponse();
		
		response.setJwt(jwtString);
		response.setAuthenticated(true);
		response.setError(false);
		response.setErrordetails(null);
		response.setRoletype(UserRole.USER);
		response.setMessage("Account login successfully..!!");

return new ResponseEntity<JwtResponse>(response,HttpStatus.ACCEPTED);
		
	}
	
	
	private Authentication authenticate(String email,String password)
	{
		UserDetails userDetails=userdetailservice.loadUserByUsername(email);
		if(userDetails==null) {
			throw new BadCredentialsException("invalid username & password");
		}
		
		if(!encoder.matches(password, userDetails.getPassword()))
		{
			throw new BadCredentialsException("password invalid");
			
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}
}










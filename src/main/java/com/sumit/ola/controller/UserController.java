package com.sumit.ola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.ola.entity.Ride;
import com.sumit.ola.entity.User;
import com.sumit.ola.service.UserService;

@RestController
@RequestMapping("/apis/users")
public class UserController {
	

	@Autowired
	private UserService service;
	
	
	@GetMapping("/{userId}")
	public ResponseEntity<User>findUserByIdHandler(@PathVariable Integer userId){
		
		User userById = service.findUserById(userId);
		
		return new ResponseEntity<User>(userById,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/profile")
	public ResponseEntity<User>getUserProfile(@RequestHeader("Authorization") String jwt){
		User user = service.getReqUserProfile(jwt);
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/rides/completed")
	public ResponseEntity <List<Ride>> getUserCompletedRides(@RequestHeader("Authorization") String jwt){
		User user = service.getReqUserProfile(jwt);
		List<Ride> findcompletedRide = service.findcompletedRide(user.getId());
		
		return new ResponseEntity<List<Ride>>(findcompletedRide,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
}

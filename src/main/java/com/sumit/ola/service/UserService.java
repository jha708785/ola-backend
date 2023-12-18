package com.sumit.ola.service;

import java.util.List;

import com.sumit.ola.Exception.UserException;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.entity.User;

public interface UserService {
	
	public User createUser(User user)throws UserException;
	
	public User getReqUserProfile(String jwttoken)throws UserException;
	
	public User findUserById(Integer userId)throws UserException;
	
	/*public User findUserByEmail(String email)throws UserException;
	
	public User findByToken(String token)throws UserException;*/
	
	public List<Ride>findcompletedRide(Integer userId)throws UserException;
}

package com.sumit.ola.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sumit.ola.Exception.UserException;
import com.sumit.ola.config.jwtTokenProvider;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.entity.User;
import com.sumit.ola.repo.UserRepo;
import com.sumit.ola.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private jwtTokenProvider privider;

	@Override
	public User createUser(User user) throws UserException
	{
	User useremail = userRepo.findByEmail(user.getEmail());
	if(useremail!=null)throw new UserException("Email already exist..!!");
	
		return userRepo.save(user);
	}

	@Override
	public User getReqUserProfile(String jwttoken) throws UserException {
		String emailFromJwt = privider.getEmailFromJwt(jwttoken);
	
		User user = userRepo.findByEmail(emailFromJwt);
		if(user!=null) {
			return user;
		}
		throw new UserException("invalid token");
	}

	@Override
	public User findUserById(Integer userId) throws UserException {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		throw new UserException("user id not found...!!");
	}

	@Override
	public List<Ride> findcompletedRide(Integer userId) throws UserException {
		
		//User user = findUserById(userId);
		List<Ride>completeride =userRepo.getCompletedRides(userId);
		return 	completeride;
	}
	
	
	
	

}

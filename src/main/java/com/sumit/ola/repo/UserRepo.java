package com.sumit.ola.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.sumit.ola.Exception.UserException;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.entity.User;
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {

	
	public User findByEmail(String  email);
	
	//public User findByMobile(String  mobile) throws UserException;
	
	@Query("SELECT R From Ride where R.status=COMPLETED AND R.user.id=:userId")
	public List<Ride> getCompletedRides(@Param("userId") Integer userId);
}

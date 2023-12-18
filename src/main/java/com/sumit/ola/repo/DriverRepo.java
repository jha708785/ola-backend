package com.sumit.ola.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sumit.ola.Exception.DriverException;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.Ride;


public interface  DriverRepo  extends JpaRepository<Driver, Integer>{

	public Driver findByEmail(String  email);
	
	@Query("SELECT R from Ride R WHERE R.satus=REQUESTED AND R.driver.id=:driverId ")
	public List<Ride>getAllocatedRides(@Param("driverId") Integer drivarId);
	
	@Query("SELECT R FROM Ride R WHERE R.status=COMPLETED AND R.driver.id=:driverId")
	public List<Ride>getCompletedRides(@Param("driverId") Integer drivarId);
}

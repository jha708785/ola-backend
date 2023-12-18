package com.sumit.ola.service;

import java.util.List;

import com.sumit.ola.Exception.DriverException;
import com.sumit.ola.Exception.RideException;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.enums.RideStatus;
import com.sumit.ola.request.SignupRequestDriver;

public interface DriverService {
	
	public Driver registerDriver(SignupRequestDriver driver)throws DriverException;
	
	public List<Driver>getAvalibleDriver(double pickupLatitude 
			,double pickupLongitude,double redius,Ride ride)throws DriverException,RideException;
	
	public Driver findNerestDriver(List<Driver> availableDrivers,double pickupLatitude 
			,double pickupLongitude )throws DriverException,RideException;
	
	
	
	public Driver getreqDriverProfile(String jwt)throws DriverException;
	
	public Ride getCurentRide(Integer driverId)throws DriverException;
	
	
	public List<Ride>getAllocatedRide(Integer driverId)throws DriverException;
	
	
	public Driver findDriverById(Integer driverId)throws DriverException;
	
	
	public List<Ride> completeRides(Integer driverId)throws DriverException;
	
	
	

}

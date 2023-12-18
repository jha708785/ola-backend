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

import com.sumit.ola.Exception.DriverException;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.service.DriverService;

@RestController
@RequestMapping("/apis/driver")
public class DriverController
{

	@Autowired
	private DriverService driverService;
	
	@GetMapping("/profile")
	private ResponseEntity<Driver>getReqDriverProfileHandler(@RequestHeader("Authorization")String jwt){
		
		Driver getreqDriverProfile = driverService.getreqDriverProfile(jwt);
		
		return new ResponseEntity<Driver>(getreqDriverProfile,HttpStatus.OK);
		
	}
	
	@GetMapping("/{driverId}/current_ride")
	private ResponseEntity<Ride>getDriverCurentRideHandler(@PathVariable Integer driverId) throws DriverException{
		
		Ride curentRide = driverService.getCurentRide(driverId);
		return new ResponseEntity<Ride>(curentRide,HttpStatus.OK);
		
	}
	

	@GetMapping("/{driverId}/allocated_ride")
	private ResponseEntity<List<Ride>>getAllocatedDriverRideHandler(@PathVariable Integer driverId) throws DriverException{
		
		List<Ride> allocatedRide = driverService.getAllocatedRide(driverId);
		return new ResponseEntity<List<Ride>>(allocatedRide,HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/completed")
	private ResponseEntity<List<Ride>>getComplteDriverRideHandler(@RequestHeader("Authorization")String jwt) throws DriverException{
		
		Driver driver = driverService.getreqDriverProfile(jwt);
		List<Ride> curentRide = driverService.completeRides(driver.getId());
		
		return new ResponseEntity<List<Ride>>(curentRide,HttpStatus.ACCEPTED);
		
	}
}









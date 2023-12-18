package com.sumit.ola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.ola.Exception.DriverException;
import com.sumit.ola.Exception.RideException;
import com.sumit.ola.dto.RideDto;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.entity.User;
import com.sumit.ola.halper.DtoMapper;
import com.sumit.ola.request.RideRequest;
import com.sumit.ola.request.StartRideRequest;
import com.sumit.ola.response.messageResponse;
import com.sumit.ola.service.DriverService;
import com.sumit.ola.service.RideService;
import com.sumit.ola.service.UserService;

@RestController
@RequestMapping("/apis/rides")
public class RideController 
{

	@Autowired
	private RideService rideService;
	@Autowired
	private DriverService driverService;
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/request")
	public ResponseEntity<RideDto>userrequestRideHandler(@RequestBody RideRequest 
			riderequest,@RequestHeader("Authroize")String jwt) throws DriverException, RideException
	{
		User user = userService.getReqUserProfile(jwt);
		
		Ride ride = rideService.requestRide(riderequest, user);
		
		RideDto dto=DtoMapper.toRideDto(ride);
		
		
		return new ResponseEntity<RideDto>(dto,HttpStatus.OK);
	}
	
	@PutMapping("/{rideId}/accepted")
	public ResponseEntity<messageResponse>acceptedRideHandler(@PathVariable
			Integer rideId
			) throws RideException
	{
		rideService.acceptedRide(rideId);
		messageResponse response=new messageResponse("Ride Accepted By Driver..!!");
		
		
		return new ResponseEntity<messageResponse>(response,HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/{rideId}/decline")
	public ResponseEntity<messageResponse>declineRideHandler(@RequestHeader("Authorization")String jwt,
	@PathVariable Integer rideId) throws RideException
	{
	    User user=userService.getReqUserProfile(jwt);
		rideService.declinedRide(user.getId(), rideId);
		messageResponse response=new messageResponse("Ride decline By Driver..!!");
		
		
		return new ResponseEntity<messageResponse>(response,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{rideId}/start")
	public ResponseEntity<messageResponse>startRideHandler(
			@RequestBody StartRideRequest startreq,
	@PathVariable Integer rideId) throws RideException
	{
		
	   
		rideService.startRide(rideId,startreq.getOtp());
		messageResponse response=new messageResponse("Ride started By Driver..!!");
		
		
		return new ResponseEntity<messageResponse>(response,HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/{rideId}/complete")
	public ResponseEntity<messageResponse>completeRideHandler(
			@RequestBody StartRideRequest startreq,
	@PathVariable Integer rideId) throws RideException
	{
		
	   
		rideService.completedRide(rideId);
		messageResponse response=new messageResponse("Ride started By Driver..!!");
		
		
		return new ResponseEntity<messageResponse>(response,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/{rideId}")
	public ResponseEntity<RideDto>findRideByRideIdHandler(
			@RequestHeader("Authorization")String jwt,	
	@PathVariable Integer rideId) throws RideException
	{
		
	   User user = userService.getReqUserProfile(jwt);
		Ride ride = rideService.findRideById(rideId);
		RideDto rideDto=DtoMapper.toRideDto(ride);
		return new ResponseEntity<RideDto>(rideDto,HttpStatus.ACCEPTED);
	}
	
	
}









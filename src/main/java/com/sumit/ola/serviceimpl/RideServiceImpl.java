package com.sumit.ola.serviceimpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumit.ola.Exception.DriverException;
import com.sumit.ola.Exception.RideException;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.entity.User;
import com.sumit.ola.enums.RideStatus;
import com.sumit.ola.repo.DriverRepo;
import com.sumit.ola.repo.RideRepo;
import com.sumit.ola.request.RideRequest;
import com.sumit.ola.service.Calculator;
import com.sumit.ola.service.DriverService;
import com.sumit.ola.service.RideService;

@Service
public class RideServiceImpl implements RideService{
	@Autowired
	private RideRepo rideRepo;
	@Autowired
	private DriverService driverService;
	@Autowired
	private Calculator calculate;
	@Autowired
	private DriverRepo driverRepo;

	@Override
	public Ride requestRide(RideRequest ridereq, User user) throws DriverException, RideException {
	
		String pickupArea = ridereq.getPickupArea();
		double destanationArea = ridereq.getDestanationArea();
		double distanationLatitude = ridereq.getDistanationLatitude();
		double distanationLongitude = ridereq.getDistanationLongitude();
		double pickupLatitude = ridereq.getPickupLatitude();
		double pickupLongitude = ridereq.getPickupLongitude();
		
		Ride existingRide =new Ride();
		List<Driver> avalibleDriver = driverService.getAvalibleDriver
				(pickupLatitude, pickupLongitude, 5, existingRide);
		
		Driver findNerestDriver = driverService.findNerestDriver
				(avalibleDriver, pickupLatitude, pickupLongitude);
		
		if (existingRide==null) {
			throw new DriverException("Driver not avilable...!!");
			
		}
		
		Ride createRideRequest =
				createRideRequest
				(user, findNerestDriver, pickupLongitude, pickupLatitude, 
						distanationLatitude, distanationLongitude,
						pickupArea, pickupArea);
		
		
		return createRideRequest;
	}

	
	@Override
	public Ride createRideRequest(User user, Driver neardriver, double pickupLongitude, double pickLatitude,
			double destenationLatitude, double destenationLongitude, String pickupArea, String destanationArea) {
		
		Ride ride=new Ride();
		ride.setDriver(neardriver);
		ride.setUser(user);
		ride.setPickupLatitude(pickLatitude);
		ride.setPickupLongitude(pickupLongitude);
		ride.setDestanitionLatitude(destenationLatitude);
		ride.setDestanitionLongitude(destenationLongitude);
		ride.setRideStatus(RideStatus.REQUESTED);
		ride.setPickupArea(pickupArea);
		ride.setDistenationArea(destanationArea);
		
		return rideRepo.save(ride);
	}


	@Override
	public void acceptedRide(Integer rideId) throws RideException 
	{
	   	Ride ride = findRideById(rideId);
	   	ride.setRideStatus(RideStatus.ACCEPTED);
	   	Driver driver=ride.getDriver();
	   	driver.setCurrentRide(ride);
	   	Random random=new Random();
	    int otp=random.nextInt(9000)+1000;
	    ride.setOtp(otp);
	    driverRepo.save(driver);
	    rideRepo.save(ride);
	   	
	}

	@Override
	public void declinedRide(Integer rideId,Integer driverId) throws RideException {
		Ride ride = findRideById(rideId);
	   	System.out.print(ride.getId());
	   	
	   	ride.getDeclineDrivers().add(driverId);
	   	
	   	List<Driver> avalibleDriver = driverService.getAvalibleDriver(ride.getPickupLatitude(),
	   			ride.getPickupLongitude(), 5, ride);
	   	
	   	
	   	Driver NerestDriver = driverService.findNerestDriver
	   			(avalibleDriver, ride.getPickupLatitude(), ride.getPickupLongitude());
	   	
	    ride.setDriver(NerestDriver);
	    rideRepo.save(ride);
	}

	@Override
	public void startRide(Integer rideId, int otp) throws RideException
	{
		Ride ride = findRideById(rideId);
		if(otp!=ride.getOtp()) {
			throw new RideException("Invalid OTP"+otp);
		}
		
		ride.setRideStatus(RideStatus.STARTED);
		ride.setStartrideTime(LocalDateTime.now());
		rideRepo.save(ride);
	}

	@Override
	public void completedRide(Integer rideId) throws RideException 
	{
		Ride ride = findRideById(rideId);
		ride.setRideStatus(RideStatus.COMPLETED);
		ride.setEndrideTime(LocalDateTime.now());
		double distance = calculate.calculateDistance(ride.getDestanitionLatitude(), ride.getDestanitionLongitude(),
				ride.getPickupLatitude(), ride.getPickupLongitude());
		
		LocalDateTime starTime=ride.getStartrideTime();
		LocalDateTime endrideTime = ride.getEndrideTime();
		Duration duration=Duration.between(starTime, endrideTime);
		long millisecond=duration.toMillis();
		
		
		double fare=calculate.calculateFare(distance);
		
		
		ride.setDistance(Math.round(distance*100.0)/100.0);
		ride.setFare((int)Math.round(fare));
		ride.setDuration(millisecond);
		ride.setEndrideTime(LocalDateTime.now());
		
		
		Driver driver=ride.getDriver();
		driver.getRides().add(ride);////add ride in driver
		
		driver.setCurrentRide(null);//set null because driver has already ride.
		
		Integer driverrevenueInteger=(int)(driver.getTotalRevenue()+Math.round(fare*0.8));
		
		driver.setTotalRevenue(driverrevenueInteger);
		driverRepo.save(driver);
		rideRepo.save(ride);
		
		
	}

	@Override
	public void cancelRide(Integer rideId) throws RideException {
		Ride ride = findRideById(rideId);
		ride.setRideStatus(RideStatus.CANCLED);
		rideRepo.save(ride);
	}

	@Override
	public Ride findRideById(Integer rideId) throws RideException {
		
		Optional<Ride> findById = rideRepo.findById(rideId);
		if(findById.isPresent())
		{
			return findById.get();
		}
		throw new RideException("ride is not found ");
	}



	
}

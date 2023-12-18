package com.sumit.ola.service;

import com.sumit.ola.Exception.DriverException;
import com.sumit.ola.Exception.RideException;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.Ride;
import com.sumit.ola.entity.User;
import com.sumit.ola.request.RideRequest;

public interface RideService
{
     public Ride requestRide(RideRequest ridereq,User user)throws DriverException ,RideException;
     
     public Ride createRideRequest(User user,Driver neardriver,
    		 double pickupLongitude,double pickLatitude,
    		 double destenationLatitude,	 double destenationLongitude,
    		 String pickupArea,String destanationArea);
     
     public void acceptedRide(Integer rideId)throws RideException;
     
     public void declinedRide(Integer rideId,Integer driverId)throws RideException;
     
     public void startRide(Integer rideId,int otp)throws RideException;
     
     public void completedRide(Integer rideId)throws RideException;
     
     
     public void cancelRide(Integer rideId)throws RideException;
     
     public Ride findRideById(Integer rideId)throws RideException;
     
     
     
   
     

		
}

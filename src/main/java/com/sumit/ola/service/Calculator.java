package com.sumit.ola.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

	private static final int EARTH_RADIUS=6371;
	
	public double calculateDistance(double sourceLat,double sourceLongi,double desLat,double desLng) 
	
	{
		double dLat=Math.toRadians(desLat-sourceLat);
		double dLang=Math.toRadians(desLng-sourceLongi);
		double a=Math.sin(dLat/2)*Math.sin(dLat/2)
				+Math.cos(Math.toRadians(sourceLat))*Math.cos(Math.toRadians(desLat))
				*Math.sin(dLang/2)*Math.sin(dLang/2);
		double c=2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		
		double distance=EARTH_RADIUS*c;
		return distance;
			
	}
	
	
	public long calculateDuration(LocalDateTime startTime,LocalDateTime endTime) 
	{
		java.time.Duration duration =java.time.Duration.between(startTime, endTime);
		return duration.getSeconds();
	}
	
	
	public double calculateFare(double distance)
	{
		double basefare=11;
		double totalfare=basefare*distance;
		return totalfare;
	}
}

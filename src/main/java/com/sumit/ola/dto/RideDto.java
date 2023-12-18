package com.sumit.ola.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sumit.ola.entity.Driver;
import com.sumit.ola.entity.User;
import com.sumit.ola.enums.RideStatus;



public class RideDto {

    private Integer id;
	private UserDto user;
	private DriverDto driver;
	private double pickupLatitude;
	private double pickupLongitude;
	private double destanitionLatitude;
	private double destanitionLongitude;
	private String pickupArea;
	private String distenationArea;
	private double distance;
	private long duration;
	private RideStatus rideStatus;
	private LocalDateTime startrideTime;
	private LocalDateTime endrideTime;
	private double fare;
	private int otp;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public DriverDto getDriver() {
		return driver;
	}
	public void setDriver(DriverDto driver) {
		this.driver = driver;
	}
	public double getPickupLatitude() {
		return pickupLatitude;
	}
	public void setPickupLatitude(double pickupLatitude) {
		this.pickupLatitude = pickupLatitude;
	}
	public double getPickupLongitude() {
		return pickupLongitude;
	}
	public void setPickupLongitude(double pickupLongitude) {
		this.pickupLongitude = pickupLongitude;
	}
	public double getDestanitionLatitude() {
		return destanitionLatitude;
	}
	public void setDestanitionLatitude(double destanitionLatitude) {
		this.destanitionLatitude = destanitionLatitude;
	}
	public double getDestanitionLongitude() {
		return destanitionLongitude;
	}
	public void setDestanitionLongitude(double destanitionLongitude) {
		this.destanitionLongitude = destanitionLongitude;
	}
	public String getPickupArea() {
		return pickupArea;
	}
	public void setPickupArea(String pickupArea) {
		this.pickupArea = pickupArea;
	}
	public String getDistenationArea() {
		return distenationArea;
	}
	public void setDistenationArea(String distenationArea) {
		this.distenationArea = distenationArea;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public RideStatus getRideStatus() {
		return rideStatus;
	}
	public RideDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setRideStatus(RideStatus rideStatus) {
		this.rideStatus = rideStatus;
	}
	public LocalDateTime getStartrideTime() {
		return startrideTime;
	}
	public void setStartrideTime(LocalDateTime startrideTime) {
		this.startrideTime = startrideTime;
	}
	public LocalDateTime getEndrideTime() {
		return endrideTime;
	}
	public void setEndrideTime(LocalDateTime endrideTime) {
		this.endrideTime = endrideTime;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
}

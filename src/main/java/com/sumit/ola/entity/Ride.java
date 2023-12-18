package com.sumit.ola.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sumit.ola.enums.RideStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ride")
public class Ride {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Driver driver;
	
	@JsonIgnore
	private List<Integer>declineDrivers=new ArrayList<>();
	
	private double pickupLatitude;
	private double pickupLongitude;
	private double destanitionLatitude;
	private double destanitionLongitude;
	
	
	public double getDestanitionLongitude() {
		return destanitionLongitude;
	}

	public void setDestanitionLongitude(double destanitionLongitude) {
		this.destanitionLongitude = destanitionLongitude;
	}

	private String pickupArea;
	private String distenationArea;
	
	private double distance;
	private long duration;
	
	
	public Ride() {
		super();
		// TODO Auto-generated constructor stub
	}

	private RideStatus rideStatus;
	
	private LocalDateTime startrideTime;
	private LocalDateTime endrideTime;
	
	private double fare;
	
	private int otp;
	
	@Embedded
	private PaymentDetails paymentDetails=new PaymentDetails();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public List<Integer> getDeclineDrivers() {
		return declineDrivers;
	}

	public void setDeclineDrivers(List<Integer> declineDrivers) {
		this.declineDrivers = declineDrivers;
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

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	
	
	
	
	
}

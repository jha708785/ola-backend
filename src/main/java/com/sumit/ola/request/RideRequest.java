package com.sumit.ola.request;

public class RideRequest {

	private double pickupLongitude;
	private double pickupLatitude;
	private double distanationLongitude;
	private double distanationLatitude;
	private String pickupArea;
	private double destanationArea;
	
	
	public RideRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RideRequest(double pickupLongitude, double pickupLatitude, double distanationLongitude,
			double distanationLatitude, String pickupArea, double destanationArea) {
		super();
		this.pickupLongitude = pickupLongitude;
		this.pickupLatitude = pickupLatitude;
		this.distanationLongitude = distanationLongitude;
		this.distanationLatitude = distanationLatitude;
		this.pickupArea = pickupArea;
		this.destanationArea = destanationArea;
	}
	public double getPickupLongitude() {
		return pickupLongitude;
	}
	public void setPickupLongitude(double pickupLongitude) {
		this.pickupLongitude = pickupLongitude;
	}
	public double getPickupLatitude() {
		return pickupLatitude;
	}
	public void setPickupLatitude(double pickupLatitude) {
		this.pickupLatitude = pickupLatitude;
	}
	public double getDistanationLongitude() {
		return distanationLongitude;
	}
	public void setDistanationLongitude(double distanationLongitude) {
		this.distanationLongitude = distanationLongitude;
	}
	public double getDistanationLatitude() {
		return distanationLatitude;
	}
	public void setDistanationLatitude(double distanationLatitude) {
		this.distanationLatitude = distanationLatitude;
	}
	public String getPickupArea() {
		return pickupArea;
	}
	public void setPickupArea(String pickupArea) {
		this.pickupArea = pickupArea;
	}
	public double getDestanationArea() {
		return destanationArea;
	}
	public void setDestanationArea(double destanationArea) {
		this.destanationArea = destanationArea;
	}
}

package com.sumit.ola.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Id;

public class Notification {

	@Id
	private Integer id;
	private String message;
	private Ride ride;
	
	private User user;
	private LocalDateTime time;
	public Integer getId() {
		return id;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Ride getRide() {
		return ride;
	}
	public void setRide(Ride ride) {
		this.ride = ride;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}

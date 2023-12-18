package com.sumit.ola.dto;

import com.sumit.ola.entity.Vechle;
import com.sumit.ola.enums.UserRole;

public class DriverDto {
    private Integer id;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private double reating;
	
	private double latitude;
	
	private double longitude;
	
	private UserRole role;
	
	private Vechle vechle;

	public DriverDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public double getReating() {
		return reating;
	}

	public void setReating(double reating) {
		this.reating = reating;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Vechle getVechle() {
		return vechle;
	}

	public void setVechle(Vechle vechle) {
		this.vechle = vechle;
	}
	
}

package com.sumit.ola.request;

import com.sumit.ola.entity.Licance;
import com.sumit.ola.entity.Vechle;

import jakarta.persistence.OneToOne;

public class SignupRequestDriver {

	private String name;
	
	private String email;
	
	private String mobile;
	
	private String password;
	
	private double latitude;
	
	private double longitude;
	
	//@OneToOne(mappedBy = "driver")
	private Licance licance;
	
	//@OneToOne(mappedBy = "driver")
	private Vechle vechle;


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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Licance getLicance() {
		return licance;
	}

	public void setLicance(Licance licance) {
		this.licance = licance;
	}

	public Vechle getVechle() {
		return vechle;
	}

	public void setVechle(Vechle vechle) {
		this.vechle = vechle;
	}

	public SignupRequestDriver(String name, String email, String mobile, String password, double latitude,
			double longitude, Licance licance, Vechle vechle) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.latitude = latitude;
		this.longitude = longitude;
		this.licance = licance;
		this.vechle = vechle;
	}
	
}

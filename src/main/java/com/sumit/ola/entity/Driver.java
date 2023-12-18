package com.sumit.ola.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sumit.ola.enums.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="driver")
public class Driver {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	private double reating;
	
	private double latitude;
	
	private double longitude;
	
	private UserRole role;
	
	private String password;
	
	
	
	
	
	@OneToOne(mappedBy="driver", cascade = CascadeType.ALL)
	private Licance licance;
	
	@JsonIgnore
	@OneToMany(mappedBy = "driver",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Ride>rides;
	
	@OneToOne(mappedBy = "driver",cascade = CascadeType.ALL,orphanRemoval = true)
	private Vechle vechle;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Ride currentRide;
	
	
	private Integer totalRevenue=0;


	public Driver() {
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Licance getLicance() {
		return licance;
	}


	public void setLicance(Licance licance) {
		this.licance = licance;
	}


	public List<Ride> getRides() {
		return rides;
	}


	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}


	public Vechle getVechle() {
		return vechle;
	}


	public void setVechle(Vechle vechle) {
		this.vechle = vechle;
	}


	public Ride getCurrentRide() {
		return currentRide;
	}


	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}


	public Integer getTotalRevenue() {
		return totalRevenue;
	}


	public void setTotalRevenue(Integer totalRevenue) {
		this.totalRevenue = totalRevenue;
	}


	public Driver(Integer id, String name, String email, String mobile, double reating, double latitude,
			double longitude, UserRole role, String password, Licance licance, List<Ride> rides, Vechle vechle,
			Ride currentRide, Integer totalRevenue) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.reating = reating;
		this.latitude = latitude;
		this.longitude = longitude;
		this.role = role;
		this.password = password;
		this.licance = licance;
		this.rides = rides;
		this.vechle = vechle;
		this.currentRide = currentRide;
		this.totalRevenue = totalRevenue;
	}
	
	
}

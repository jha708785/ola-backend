package com.sumit.ola.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="licance")
public class Licance {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String licencenumber;
	

	private String licenceState;

	private String licenceExpiredate;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Driver driver;

	public Licance(Integer id, String licencenumber, String licenceState, String licenceExpiredate, Driver driver) {
		super();
		this.id = id;
		this.licencenumber = licencenumber;
		this.licenceState = licenceState;
		this.licenceExpiredate = licenceExpiredate;
		this.driver = driver;
	}

	public Licance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLicencenumber() {
		return licencenumber;
	}

	public void setLicencenumber(String licencenumber) {
		this.licencenumber = licencenumber;
	}

	public String getLicenceState() {
		return licenceState;
	}

	public void setLicenceState(String licenceState) {
		this.licenceState = licenceState;
	}

	public String getLicenceExpiredate() {
		return licenceExpiredate;
	}

	public void setLicenceExpiredate(String licenceExpiredate) {
		this.licenceExpiredate = licenceExpiredate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	
	
}

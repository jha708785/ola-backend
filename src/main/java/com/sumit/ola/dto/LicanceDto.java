package com.sumit.ola.dto;

public class LicanceDto {

     private String licencenumber;
	public LicanceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLicencenumber() {
		return licencenumber;
	}
	public void setLicencenumber(String licencenumber) {
		this.licencenumber = licencenumber;
	}
	public String getLicenceExpiredate() {
		return licenceExpiredate;
	}
	public void setLicenceExpiredate(String licenceExpiredate) {
		this.licenceExpiredate = licenceExpiredate;
	}
	private String licenceExpiredate;

}

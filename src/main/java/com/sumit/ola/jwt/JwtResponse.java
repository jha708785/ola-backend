package com.sumit.ola.jwt;

import com.sumit.ola.enums.UserRole;

public class JwtResponse {

	private String jwt;
	private String message;
	private boolean isAuthenticated;
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	private boolean isError;
	private String errordetails;
	private UserRole roletype;
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getErrordetails() {
		return errordetails;
	}
	public void setErrordetails(String errordetails) {
		this.errordetails = errordetails;
	}
	public UserRole getRoletype() {
		return roletype;
	}
	public void setRoletype(UserRole roletype) {
		this.roletype = roletype;
	}
	public JwtResponse(String jwt, String message, boolean isAuthenticated, boolean isError, String errordetails,
			UserRole roletype) {
		super();
		this.jwt = jwt;
		this.message = message;
		this.isAuthenticated = isAuthenticated;
		this.isError = isError;
		this.errordetails = errordetails;
		this.roletype = roletype;
	}
}

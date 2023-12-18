package com.sumit.ola.request;

import com.sumit.ola.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignupRequestUser {

	@NotBlank(message  ="Email is required")
	@Email(message = "Email should be valid ")
	private String email;
	private String fullname;
	private String password;
	private String mobile;
	private UserRole role;
	
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public SignupRequestUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SignupRequestUser(
			@NotBlank(message = "Email is required") @Email(message = "Email should be valid ") String email,
			String fullname, String password, String mobile) {
		super();
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}

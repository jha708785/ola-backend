package com.sumit.ola.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetail {

	
	private String error;
	
	private String detail;
	
	private LocalDateTime time;


	public ErrorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetail(String error, String detail, LocalDateTime time) {
		super();
		this.error = error;
		this.detail = detail;
		this.time = time;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}

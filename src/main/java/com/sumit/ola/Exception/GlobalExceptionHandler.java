package com.sumit.ola.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetail> UserExceptionHeandler(UserException e, WebRequest web) {
		ErrorDetail error = new ErrorDetail(e.getMessage(), web.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<ErrorDetail>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DriverException.class)
	public ResponseEntity<ErrorDetail> DriverExceptionHeandler(DriverException e, WebRequest web) {
		ErrorDetail error = new ErrorDetail(e.getMessage(), web.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<ErrorDetail>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RideException.class)
	public ResponseEntity<ErrorDetail> RideExceptionHeandler(RideException e, WebRequest web) {
		ErrorDetail error = new ErrorDetail(e.getMessage(), web.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<ErrorDetail>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetail> methodExceptionHeandler(MethodArgumentNotValidException e, WebRequest web) {
		ErrorDetail error = new ErrorDetail(e.getBindingResult().getFieldError().getDefaultMessage(),
				"validation Error", LocalDateTime.now());

		return new ResponseEntity<ErrorDetail>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> AllExceptionHeandler(Exception e, WebRequest web) {
		ErrorDetail error = new ErrorDetail(e.getMessage(), web.getDescription(false), LocalDateTime.now());

		return new ResponseEntity<ErrorDetail>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}

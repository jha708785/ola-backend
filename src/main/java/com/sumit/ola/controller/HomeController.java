package com.sumit.ola.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.ola.response.messageResponse;



@RestController
@RequestMapping("/api/")
public class HomeController {

	@GetMapping("/")
	public ResponseEntity<messageResponse>homeController(){
		messageResponse message=new messageResponse("Welcome to ola");
		
	 return	new ResponseEntity<messageResponse>(message,HttpStatus.OK);
	}
}

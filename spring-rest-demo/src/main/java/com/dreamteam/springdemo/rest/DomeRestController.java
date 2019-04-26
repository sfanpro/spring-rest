package com.dreamteam.springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DomeRestController {

	// add code for the "/hello" endpoint
	@GetMapping("/hello")
	public String sayHello() {
		return "Good Morning!";
	}
}

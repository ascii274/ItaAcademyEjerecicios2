package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@GetMapping(value = "/")
	public String helloWorld() {
		return "Hello world Welcome to Spring";
	}
	

	@GetMapping("/parameter")
	public String helloParameter(@RequestParam(value = "name", defaultValue = "Joel") String name) {
	return String.format("Hello %s!", name);
	}

	

}

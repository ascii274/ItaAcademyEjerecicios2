package com.ascii274.spring_boot_initial_demo_mvn_fase_3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloMaven {
	
	@GetMapping(value="/")
	public String helloMaven() {
		return "Hello maeven";
	}
	

	
	@GetMapping(value = "/parameter")
	public String helloParameter(@RequestParam(value = "name", defaultValue = "Joel") String name) {
		return String.format("Hello %s!", name);
	}
	

	
	

}

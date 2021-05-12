package com.in.indium.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OrderRestController {
	
	@Value("${server.port}")
	private int port; 
	
	@GetMapping("/show")
	public String showData() {
		return "FORM-DATA ORDER"+port;
		
	}

}

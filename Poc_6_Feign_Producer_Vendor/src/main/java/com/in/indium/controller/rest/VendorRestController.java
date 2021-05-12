package com.in.indium.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/vendor")
public class VendorRestController {
	
	@Value("${server.port}")
	private int port; 
	
	@GetMapping("/data")
	public String getVendorData() {
		return "FORM-VENDOR"+port;
		
	}
}

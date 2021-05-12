package com.in.indium.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.indium.consumer.OrderRestConsumer;

@RestController
public class PaymentRestController {
	@Autowired
	private OrderRestConsumer consumer;
	
	
	@GetMapping("/consume")
	public String findMassage() {
		return "CONSUMER=>"+consumer.doHttpcall();
		
	}

}

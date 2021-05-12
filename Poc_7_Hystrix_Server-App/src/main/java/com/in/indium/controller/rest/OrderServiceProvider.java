package com.in.indium.controller.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest")
public class OrderServiceProvider {
	@HystrixCommand(defaultFallback ="showFallBack")
	@GetMapping("/show")
	public String showMsg() {
		System.out.println("from service");
		if(new Random().nextInt(10)<=10) {
			throw new RuntimeException("DUMMY");
			
		}
		return "FROM PROVIDER";
	}
		public String showFallBack() {
			System.out.println("from fall back");
			return "FROM FALL BACK METHOD";
			
			
		}
		
	}



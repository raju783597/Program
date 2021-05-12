package com.in.indium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class Poc7ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc7ZuulServerApplication.class, args);
	System.out.println("Zuul Api GATEWAY SERVICE IS EXECUTED");
	}

}

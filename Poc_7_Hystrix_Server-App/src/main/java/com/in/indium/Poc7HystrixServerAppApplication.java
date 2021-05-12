package com.in.indium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//@EnableCircuitBreaker
@EnableHystrix
@EnableDiscoveryClient

public class Poc7HystrixServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc7HystrixServerAppApplication.class, args);
	}

}

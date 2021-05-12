package com.in.indium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
//@EnableHystrixDashboard
public class Poc6FeignProducerVendorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc6FeignProducerVendorApplication.class, args);
	}

}

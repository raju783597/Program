package com.in.indium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaServer
/*
 * @EnableHystrix //@EnableHystrixDashboard
 */
public class Poc6FeignServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc6FeignServerApplication.class, args);
	}

}

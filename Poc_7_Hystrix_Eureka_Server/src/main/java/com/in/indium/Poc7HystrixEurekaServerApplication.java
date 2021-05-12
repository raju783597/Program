package com.in.indium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Poc7HystrixEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc7HystrixEurekaServerApplication.class, args);
	}

}

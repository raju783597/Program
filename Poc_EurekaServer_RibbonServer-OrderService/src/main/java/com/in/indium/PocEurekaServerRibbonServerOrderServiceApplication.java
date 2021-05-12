package com.in.indium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PocEurekaServerRibbonServerOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocEurekaServerRibbonServerOrderServiceApplication.class, args);
	}

}

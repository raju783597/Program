package com.in.indium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Poc6FeignConsumerContractApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc6FeignConsumerContractApplication.class, args);
	}

}

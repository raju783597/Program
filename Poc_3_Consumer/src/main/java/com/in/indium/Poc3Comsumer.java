package com.in.indium;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Poc3Comsumer {
	
 private static Logger log=Logger.getLogger(Poc3Comsumer.class);
 

	 
    public static void main(String[] args) {
  
    

    log.info("consumer starter class ");
    	
		SpringApplication.run(Poc3Comsumer.class, args);
	}

}

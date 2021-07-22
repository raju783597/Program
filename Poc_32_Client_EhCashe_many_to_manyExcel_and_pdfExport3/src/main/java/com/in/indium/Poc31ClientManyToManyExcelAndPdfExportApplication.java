package com.in.indium;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.in.indium.controller.rest.ClientRestController;
@EnableCaching
@SpringBootApplication
public class Poc31ClientManyToManyExcelAndPdfExportApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(Poc31ClientManyToManyExcelAndPdfExportApplication.class, args);
	}

}

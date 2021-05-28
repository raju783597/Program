package com.in.indium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Poc31ExcelAndPdfPieChartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(Poc31ExcelAndPdfPieChartApplication.class, args);
	
		System.out.println("TOTAL NO. OF OBJECT>>"+ctx.getBeanDefinitionCount());
	}

}

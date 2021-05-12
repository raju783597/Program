 package com.in.indium.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwagerConfig {
	//docket is complete screen
	
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				
				.select()//select rest controller
				.apis(RequestHandlerSelectors.basePackage("com.in.indium.contaroller.rest"))
				//start with rest
				.paths(PathSelectors.regex("/web.*"))
				.build()//it create  screen
				.apiInfo(getApiInfo());
		
	}

	private ApiInfo getApiInfo() {
		// TODO Auto-generated method stub
	//	return new ApiInfo(, "indium APP","3.2","",new Contact , "INDIUM LICENCE", "", new ArraysList<v>);
	
		return new ApiInfo("Ragistration-app",
				            "RAGISTRATION-DESCRIPTION-VALIDATION APP",
				            "2.3",
				            "https://www.indiumsoftware.com/" , 
				              new Contact("abc(user name)", "", "abc@gmail.com"),
				              "INDIUM LICENCE"," ",new ArrayList<VendorExtension>()) ;
	}

}

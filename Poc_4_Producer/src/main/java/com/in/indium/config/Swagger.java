package com.in.indium.config;

import javax.persistence.Basic;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
	@Basic
	public Docket myapp() {
		return new Docket(DocumentationType.SWAGGER_2)
				   .select().apis(RequestHandlerSelectors
						   .basePackage("com.in.indium.controller.rest"))
				         .paths(PathSelectors.regex("/rest.*"))
				         .build();
		
		
	}

}

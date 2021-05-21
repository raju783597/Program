package com.in.indium.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.in.indium.service.ClientService;
import com.in.indium.util.ClientUtil;

@Controller
@RequestMapping("/")
public class ClientControllerChart {
	@Autowired	
	public	ClientService service;
	
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private ClientUtil utility;
	
	//chart
		@GetMapping("/charts")
			public String generateChart() {
			List<Object[]>list=	service.getcNameCount1();
			 String location= context.getRealPath("/");
			 System.out.println("chart location is"+location);
			 
			 utility.generatePieChart(location, list);
			 
			utility.generateBarChart(location, list);
				return "Data";
				
			}
	
}

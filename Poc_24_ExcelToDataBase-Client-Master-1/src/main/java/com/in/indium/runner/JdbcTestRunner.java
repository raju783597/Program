package com.in.indium.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.dao.IClientUser;
import com.in.indium.model.ClientUser;
import com.in.indium.util.ClientUserUtil;
@Component
public class JdbcTestRunner implements CommandLineRunner {
   @Autowired
	private ClientUserUtil util;
   
   @Autowired
   private IClientUser dao;
   
   
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("start");
	List<ClientUser> list=	util.readExcelData();
	  dao.saveClient(list);
	  
	  System.out.println("end");

	}

}

package com.in.indium.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.PanCard;
import com.in.indium.repo.PanCardRepo;
@Component
public class PanCardRunner implements CommandLineRunner {
     @Autowired
	private PanCardRepo crepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		crepo.save(new PanCard(101,"DDHJU","A",new Date(System.currentTimeMillis())));
		crepo.save(new PanCard(102,"DDHJU","A",new Date(System.currentTimeMillis())));
		crepo.save(new PanCard(103,"DDHJU","A",new Date(System.currentTimeMillis())));
		crepo.save(new PanCard(104,"DDHJU","A",new Date(System.currentTimeMillis())));
				
		
	}

}

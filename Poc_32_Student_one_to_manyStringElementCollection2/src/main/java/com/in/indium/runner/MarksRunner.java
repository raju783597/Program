package com.in.indium.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Marks;
import com.in.indium.repo.MarksRepo;
@Component
public class MarksRunner implements CommandLineRunner {
   @Autowired
	MarksRepo srepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
srepo.save(
		   new Marks(101,133751008,"rakesh","c")
		  ); 
srepo.save(
		   new Marks(102,133751009,"rekha","c++")
		  ); 
srepo.save(
		   new Marks(103,133751010,"keshav","java")
		  ); 
srepo.save(
		   new Marks(104,1337510011,"golu","data science")
		  ); 



	}

}

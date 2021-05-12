package com.in.indium.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Auther;
import com.in.indium.repo.AutherRepo;
//@Component
public class AutherRunner implements CommandLineRunner {

	@Autowired
	private AutherRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
       repo.save(new Auther(104,"raj","kumar","IITJEE"));
       repo.save(new Auther(105,"raja","kuma","IIT"));
       repo.save(new Auther(105,"raju","kumar","JEE"));
	}

}

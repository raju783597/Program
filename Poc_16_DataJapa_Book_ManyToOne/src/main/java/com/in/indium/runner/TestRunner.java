package com.in.indium.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Department;
import com.in.indium.repo.DeptRepo;
@Component
public class TestRunner implements CommandLineRunner {
    
	@Autowired
	 private DeptRepo repo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        repo.save(new Department(105,"jkl","this is java"));
        repo.save(new Department(106,"jkl","this is java"));
        repo.save(new Department(107,"jkl","this is java"));
        repo.save(new Department(108,"jkl","this is java"));
        
	}

}

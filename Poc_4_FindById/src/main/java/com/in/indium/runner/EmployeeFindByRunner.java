package com.in.indium.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Employee;
import com.in.indium.repo.EmployeeRepo;
@Component
public class EmployeeFindByRunner implements CommandLineRunner{
	@Autowired
	private EmployeeRepo repo;

	@Override
	public void run(String... args) throws Exception {
       // repo.save(new Employee());
		//System.out.println( repo.findAllBynameLike("%v%"));
		System.out.println( repo.findAllBynameStartingWith("j"));
		//.forEach(System.out::println);
	
	}

}

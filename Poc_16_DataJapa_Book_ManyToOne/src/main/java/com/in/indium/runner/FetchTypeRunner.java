package com.in.indium.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Employee;
import com.in.indium.repo.EmployeeRepo;
@Component
public class FetchTypeRunner implements CommandLineRunner {
   @Autowired
	private EmployeeRepo emprepo;
	
	@Override
	public void run(String... args) throws Exception {
//select parents or child table
//select empid ,  didfk,  name,  sal,  depid, 
// code,  note from employee
//left outer join department  on didfk=depid where empid=?
				
		
		Optional<Employee>opt= emprepo.findById(2);
     System.out.println("ok");
	}

}

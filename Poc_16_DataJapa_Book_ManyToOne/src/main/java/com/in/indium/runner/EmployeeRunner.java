package com.in.indium.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Department;
import com.in.indium.model.Employee;
import com.in.indium.repo.DeptRepo;
import com.in.indium.repo.EmployeeRepo;

@Component
public class EmployeeRunner implements CommandLineRunner {
	@Autowired
	private EmployeeRepo erepo;
	@Autowired
	private DeptRepo drepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		  Employee e=new Employee(2,"cse",4567.9,new Department(105)); 
		  Employee e1=new Employee(2,"cse",4567.9,new Department(106)); 
		  Employee e2=new Employee(3,"cse",4567.9,new Department(105)); 
			/*
			 * e.setEmpid(2); e.setName("me"); e.setSal(67876.0);
			 * 
			 * 
			 * e.setDep(new Department(105));
			 *      // e.setDep( drepo.findByDepId(106) );
			 */
		  erepo.save(e);
		  erepo.save(e1);
		  erepo.save(e2);
		 
	}

}

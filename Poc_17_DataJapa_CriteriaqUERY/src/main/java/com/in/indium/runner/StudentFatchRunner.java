package com.in.indium.runner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class StudentFatchRunner implements CommandLineRunner {
//1 autowire entitymanagerfactory created in data jpa environment
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Override
	public void run(String... args) throws Exception {
//2 create criteriabuilder using entitymanagerfactory
		CriteriaBuilder cb=  emf.getCriteriaBuilder();
		
//3 create object for "criteriaquery" by spacifing result class type
//4 provide from selection (also called as root)
//5 provide select selection using method select()/multiselect
//6 create where condition using builders and query

		
//7 create executable query
//8 get result and print data		

	}

}

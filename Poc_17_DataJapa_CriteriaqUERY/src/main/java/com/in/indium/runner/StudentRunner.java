package com.in.indium.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Student;
import com.in.indium.repo.StudentRepo;
@Component
public class StudentRunner implements CommandLineRunner {
    @Autowired
	private StudentRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student s=new Student(101, "raju", "mnjh", "java","hyderabad");
		Student s1=new Student(102, "ra", "mnj", "java core","delhi");
		Student s2=new Student(103, "raj", "mjh", "java hyber","chennai");
		Student s3=new Student(104, "raju kumar", "njh", "java spring","bengaluru");
         repo.save(s);  
        repo.save(s1);  
         repo.save(s2);  
         repo.save(s3);  
	}

}

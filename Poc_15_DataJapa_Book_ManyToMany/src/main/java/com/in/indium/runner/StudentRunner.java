package com.in.indium.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Course;
import com.in.indium.model.Student;
import com.in.indium.repo.CourseRepo;
import com.in.indium.repo.Studentepo;

@Component
public class StudentRunner implements CommandLineRunner {
	
	@Autowired
	private Studentepo srepo;
	@Autowired
	private CourseRepo crepo;

	@Override
	public void run(String... args) throws Exception {
		 Student s=new Student(55,"rj","chennai",
		Arrays.asList( new Course(106)));
		  
		
	
			/*
			 * s.setCourse(Arrays.asList(crepo.findById(106)
			 * 
			 * ));
			 */
		 srepo.save(s);
	}

}

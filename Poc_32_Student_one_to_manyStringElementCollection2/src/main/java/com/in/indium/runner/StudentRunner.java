package com.in.indium.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Marks;
import com.in.indium.model.Student;
import com.in.indium.repo.MarksRepo;
import com.in.indium.repo.StudentRepo;
@Component
public class StudentRunner implements CommandLineRunner  {
  @Autowired
   StudentRepo repo;
  @Autowired
  MarksRepo mrepo;
	
	@Override
	public void run(String... args) throws Exception {
		Student s=new Student();
		s.setId(1);
		s.setName("gk");
		s.setCourse("java");
		s.setMarks(Arrays.asList(new Marks(101),
				                 new Marks(102),
				                 new Marks(103),
				                 new Marks(104)
				                 ));
		repo.save(s);
		
	}

}

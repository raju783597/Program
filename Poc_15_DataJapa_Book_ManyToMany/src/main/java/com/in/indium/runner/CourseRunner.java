package com.in.indium.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Course;
import com.in.indium.repo.CourseRepo;

//@Component
public class CourseRunner implements CommandLineRunner {
	@Autowired
	private CourseRepo crepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		crepo.save(new Course(107, "b-tech", 5690, 4));
		crepo.save(new Course(108, "b-tech", 5690, 4));
		crepo.save(new Course(100, "b-tech", 5690, 4));
		crepo.save(new Course(109, "b-tech", 5690, 4));
		crepo.save(new Course(104, "b-tech", 5690, 4)

		);

	}

}

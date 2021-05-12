package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Course;
import java.lang.Integer;
import java.util.List;
import java.util.Optional;
@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
  
	
}

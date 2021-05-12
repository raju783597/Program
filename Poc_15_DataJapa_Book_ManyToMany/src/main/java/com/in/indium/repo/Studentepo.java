package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Course;
import com.in.indium.model.Student;
@Repository
public interface Studentepo extends JpaRepository<Student , Integer> {

}

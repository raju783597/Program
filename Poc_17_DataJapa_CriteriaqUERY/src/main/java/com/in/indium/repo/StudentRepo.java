package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.indium.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}

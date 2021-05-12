package com.in.indium.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.indium.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	//SELECT * FROM EMP WHERE NAME LIKE ;
	String findAllBynameLike(String name);
	//SELECT * FROM EMP WHERE NAME LIKE<INPUT>%
	List<Employee> findAllBynameStartingWith(String name);

}

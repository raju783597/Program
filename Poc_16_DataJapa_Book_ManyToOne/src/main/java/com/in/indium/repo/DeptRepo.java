package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Department;
import java.lang.Integer;
import java.util.List;
@Repository
public interface DeptRepo extends JpaRepository<Department, Integer> {
  // Department findByDepId(Integer dipid);	
	

}

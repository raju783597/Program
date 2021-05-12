package com.in.indium.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Auther;
@Repository
public interface AutherRepo extends JpaRepository<Auther, Integer> {
	
}

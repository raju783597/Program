package com.in.indium.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Devloper;
@Repository
public interface Devloperrepo extends JpaRepository<Devloper, Integer> {
	
}

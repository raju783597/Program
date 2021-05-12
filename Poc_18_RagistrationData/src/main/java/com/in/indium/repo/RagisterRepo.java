package com.in.indium.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Ragister;
@Repository
public interface RagisterRepo extends JpaRepository<Ragister, Integer> {
    
	public Ragister findByNameAndPassward(String name,String passward);
	
}

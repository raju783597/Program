package com.in.indium.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Client;
@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
	
	@Query("select CL.cName,count(CL.cName) From Client CL GROUP BY CL.cName")
	public List<Object[]> getcNameCount();

	//public List<Object[]> getcNameCount();

}

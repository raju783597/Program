package com.in.indium.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.in.indium.model.Ragistration;

public interface RagisterRepo extends JpaRepository<Ragistration, String> {
	
	@Query("select r.startDate,r.endDate from com.in.indium.model.Ragistration r")
	public List<Object[]>getStartAndEndDate();

}

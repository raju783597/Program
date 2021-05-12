package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.indium.model.PanCard;

public interface PanCardRepo extends JpaRepository<PanCard, Integer> {

	public PanCard findByPanId(Integer panId);
              
	
}

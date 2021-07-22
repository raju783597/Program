package com.in.indium.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.indium.model.PanCard;

public interface PanCardRepo extends JpaRepository<PanCard, Integer> {

	public PanCard findByPanId(Integer panId);
//	public List<PanCard> findByPanIdGreaterThan(Integer panId);
	
              
	
}

package com.in.indium.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.indium.iservice.IPersionService;
import com.in.indium.model.PersionDetail;
import com.in.indium.repo.IPersionDetailRepo;

@Service
public class PersionDetailService implements IPersionService {
	
	@Autowired
	private IPersionDetailRepo repo;

	int initial=100;
	int finalposition=1000;
	int fare=(finalposition-initial)*5;
	@Override
@Transactional
	public Integer savePersionDetail(PersionDetail p) {

		if(p.getPickupLocation().isEmpty()
				&&p.getDropLocation().isEmpty()) {
			p.setFare(0);
		}else {

			p.setFare(fare);
		}

		Integer id=	repo.save(p).getId();

		return id;
	}
	// get all data
	@Override
	public List<PersionDetail> getAllPersionDetail() {
		return  repo.findAll();

	}
	//delete
	@Override
	public void deletePersionDetail(Integer id) {
		repo.deleteById(id);

	}
	@Override
	public boolean isPersionDetailExist(Integer id) {
		boolean b= repo.existsById(id);
		return b;

	}
	@Override
	public Optional<PersionDetail> getOneData(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);

	}
	@Override
	public Integer persionDetailUpdate(PersionDetail p) {


		int initial=100;
		int finalposition=1000;
		int fare=(finalposition-initial)*5;
		p.setFare(fare);

		Integer id= repo.save(p).getId();
		return id;

	}
	@Override
	public Page<PersionDetail> getAllPersionDetail(Pageable pageable) {

		return repo.findAll(pageable);
	}

	
	/*
	 * @Override
	 * 
	 * @Transactional(readOnly=true) public List<Object[]>
	 * persionDetailVehicelTypeCount() { // TODO return
	 * repo.persionDetailVehicelTypeCount();
	 * 
	 * }
	 */

}

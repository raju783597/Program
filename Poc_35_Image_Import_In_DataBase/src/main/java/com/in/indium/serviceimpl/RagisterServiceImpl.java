package com.in.indium.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.indium.model.Ragistration;
import com.in.indium.repo.RagisterRepo;
import com.in.indium.service.RagistersIervice;
@Service
public class RagisterServiceImpl implements RagistersIervice {
    @Autowired
	private RagisterRepo repo;
	
	@Override
	public List<Ragistration> insert(List<Ragistration> r) {
		//.repo.save(r)
		return repo.saveAll(r);
	}

}

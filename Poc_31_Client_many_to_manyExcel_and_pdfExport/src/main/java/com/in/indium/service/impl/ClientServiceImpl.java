package com.in.indium.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.in.indium.model.Client;
import com.in.indium.repo.ClientRepo;
import com.in.indium.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
     @Autowired
	 public ClientRepo repo;
	//save
     
     
	@Override
	public Integer saveClient(Client client) {
		// TODO Auto-generated method stub
		return repo.save(client).getCid();
	}

//get all
	@Override
	//@Cacheable(value = "cl")
	public List<Client> getAllData() {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>from database>>>>>>>>>>>");
		return repo.findAll();
	}

	@Override
	//@CacheEvict(value = "cl")
	public void remove(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public boolean isClientExist(Integer id) {
		
		return repo.existsById(id) ;
	}

	@Override
	public void updateDta(Client client) {
	repo.save(client);
		
	}

}

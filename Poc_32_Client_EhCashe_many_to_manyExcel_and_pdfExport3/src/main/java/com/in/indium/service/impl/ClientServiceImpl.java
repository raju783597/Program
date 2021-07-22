package com.in.indium.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.in.indium.model.Client;
import com.in.indium.repo.ClientRepo;
import com.in.indium.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
    private static Logger log=Logger.getLogger(ClientServiceImpl.class);
	
	@Autowired
	 public ClientRepo repo;
	//save
     
     
	@Override
	@Cacheable(value = "cl",key="#client.cName")
	public Integer saveClient(Client client) {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>from client database>>>>>>>>>>>");
		return repo.save(client).getCid();
	}

//get all
	@Override
	@Cacheable(value = "cl")
	public List<Client> getAllData() {
		int i=1;
		// TODO Auto-generated method stub
		System.out.println(">>>>>FROM Data Base"+">>"+i++);
	log.info("enter serviceimpl class>> getAllData()>>");
		return repo.findAll();
	}

	@Override
	//@CacheEvict(value = "cl")
	public void remove(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	@CacheEvict(value = "cl",key="'cl-cashe'+#id")
	public boolean isClientExist(Integer id) {
		
		return repo.existsById(id) ;
	}

	@Override
	public void updateDta(Client client) {
	repo.save(client);
		
	}

}

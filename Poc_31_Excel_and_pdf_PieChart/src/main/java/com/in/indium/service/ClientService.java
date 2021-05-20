package com.in.indium.service;

import java.util.List;

import com.in.indium.model.Client;

public interface ClientService {
    
	public Integer saveClient(Client client);

	public List<Client> getAllData();
	
	public void remove(Integer id);
	
	public boolean isClientExist(Integer id);

	public void updateDta(Client client);
	
	public List<Object[]> getcNameCount1();
}

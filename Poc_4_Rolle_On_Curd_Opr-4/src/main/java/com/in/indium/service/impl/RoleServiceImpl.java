package com.in.indium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.indium.irepo.IRolerepo;
import com.in.indium.iservice.IRoleService;
import com.in.indium.model.Role;
@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
	private IRolerepo repo;
	
    @Override
    @Transactional
	public Integer saveRole(Role r) {
	  r= repo.save(r);
		return r.getId();//get id from where
	}

	@Override
	@Transactional
	public void updateRole(Role r) {
		repo.save(r); 
	}

	@Override
	@Transactional
	public void deleteRole(Integer id) {
       repo.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Role> getone(Integer id) {
		//for avoiding npe use optional class
	Optional<Role> opt=repo.findById(id);
	return opt;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> getAllRole() {
   List<Role> list= repo.findAll();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id) {
       boolean exist= repo.existsById(id);
		return exist;
	}
  
	
		
	
}

package com.in.indium.iservice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.in.indium.model.Role;

public interface IRoleService {
    //save data in db
	Integer saveRole(Role r);
	    //update
	public void updateRole(Role r);
		//deletedata
	public void deleteRole(Integer id);
		//getone
	public Optional< Role> getone(Integer id);
		//getall
	public List<Role> getAllRole();
		//is exist
	public boolean isExist(Integer id);
	
}

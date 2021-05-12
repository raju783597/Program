package com.in.indium.repo;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.ClientUser;
@Repository                                                            //2nd change
public interface ClientUserRepository extends JpaRepository<ClientUser, Integer> {
	
	/*
	 * @Query(value = "SELECT DISTINCT clientuser FROM ClientUser clientuser"+
	 * "WHERE clientuser com.in.indium.model client:=client") public
	 * List<ClientUser> findByClient(Integer client);
	 */
	 
	public ClientUser findByClient(double d);
	    
		
	
}

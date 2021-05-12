package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.ClientUser;
@Repository                                                            //2nd change
public interface ClientUserRepository extends JpaRepository<ClientUser, Long> {

}

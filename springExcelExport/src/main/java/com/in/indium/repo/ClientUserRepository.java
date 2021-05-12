package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.ClientUser;
@Repository
public interface ClientUserRepository extends JpaRepository<ClientUser, Integer> {

}

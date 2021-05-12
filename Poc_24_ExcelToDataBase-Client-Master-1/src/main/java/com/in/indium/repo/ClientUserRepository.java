package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.indium.model.ClientUser;

public interface ClientUserRepository extends JpaRepository<ClientUser, Integer> {

}

package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Client;
@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

}

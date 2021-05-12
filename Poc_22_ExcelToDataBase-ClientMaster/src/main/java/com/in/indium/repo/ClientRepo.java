package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.indium.model.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {

}

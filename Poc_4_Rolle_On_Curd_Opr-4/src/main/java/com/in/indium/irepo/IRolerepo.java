package com.in.indium.irepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Role;
//@Repository
public interface IRolerepo extends JpaRepository<Role, Integer> {

}

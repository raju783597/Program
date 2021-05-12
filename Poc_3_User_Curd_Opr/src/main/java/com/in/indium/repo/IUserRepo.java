package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.User;
@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

}

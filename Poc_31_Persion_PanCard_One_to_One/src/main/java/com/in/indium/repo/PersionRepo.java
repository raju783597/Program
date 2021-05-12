package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Persion;
@Repository
public interface PersionRepo extends JpaRepository<Persion, Integer> {

}

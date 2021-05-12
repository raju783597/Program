package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Marks;
@Repository
public interface MarksRepo extends JpaRepository<Marks, Integer> {


}

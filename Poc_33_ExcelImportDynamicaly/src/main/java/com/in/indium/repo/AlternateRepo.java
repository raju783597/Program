package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Alternate;
@Repository
public interface AlternateRepo extends JpaRepository<Alternate, Long> {

}

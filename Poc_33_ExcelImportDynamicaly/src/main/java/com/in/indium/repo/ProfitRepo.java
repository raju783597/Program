package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.indium.model.Profit;
@Repository
public interface ProfitRepo extends JpaRepository<Profit, Integer> {

}

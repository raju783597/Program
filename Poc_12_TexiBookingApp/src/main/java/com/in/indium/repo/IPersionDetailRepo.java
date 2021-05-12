package com.in.indium.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.in.indium.model.PersionDetail;

@Repository
public interface IPersionDetailRepo extends JpaRepository<PersionDetail, Integer> {
	// aggrigate function

   //@Query("SELECT rideType,count(rideType) FROM PersionDetail GROUP BY rideType")
	//public List<Object[]> persionDetailVehicelTypeCount();

}

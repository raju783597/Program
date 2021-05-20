package com.in.indium.iservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.in.indium.model.PersionDetail;

public interface IPersionService {

	   //1 save
		public Integer savePersionDetail(PersionDetail p);
		//2 check data is exist or not
		public Optional<PersionDetail> getOneData(Integer id);
		//3 delete
		public void deletePersionDetail(Integer id);
		//4 select
		public List<PersionDetail> getAllPersionDetail();
         //5 is exist
		public boolean isPersionDetailExist(Integer id);
		//6 update
		public Integer persionDetailUpdate(PersionDetail p);
		//7 pagination
		public Page<PersionDetail> getAllPersionDetail(Pageable pageable);
		// for chart and graph fatch the data from db
		public List<Object[]> persionDetailVehicelTypeCount1();

}

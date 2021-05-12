package com.in.indium.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.in.indium.model.Devloper;
import com.in.indium.repo.Devloperrepo;
import com.in.indium.service.DevService;
@Service
public class DevServiceImpl implements DevService {
    @Autowired
	public Devloperrepo devrepo;  
	
		@Override
		public Integer saveDev(Devloper dev) {
			
			return devrepo.save(dev).getDevid();
		}

		//get all
	
		@Override
		public List<Devloper> getAllData() {
			// TODO Auto-generated method stub
			return devrepo.findAll();
		}

		
		@Override
		public void remove(Integer id) {
			devrepo.deleteById(id);
			
		}

		
		@Override
		public boolean isDevExist(Integer id) {
			
			return devrepo.existsById(id) ;
		}

	
		@Override
		public void updateDta(Devloper div) {
		devrepo.save(div);
			
		}

	
}

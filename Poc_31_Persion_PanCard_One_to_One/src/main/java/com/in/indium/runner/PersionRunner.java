package com.in.indium.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Persion;
import com.in.indium.repo.PanCardRepo;
import com.in.indium.repo.PersionRepo;
@Component
public class PersionRunner implements CommandLineRunner {
   
	@Autowired
	PersionRepo prepo;
	
	@Autowired
	PanCardRepo crepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Persion p1=new Persion();
		p1.setPerid(2);
		p1.setPerGender("male");
		p1.setPerName("kumar");
		p1.setPerAdd("hyd");
		p1.setCard(crepo.findByPanId(101));
		prepo.save(p1);
		
		Persion p2=new Persion();
		p2.setPerid(3);
		p2.setPerGender("male");
		p2.setPerName("kumar");
		p2.setPerAdd("hyd");
		p2.setCard(crepo.findByPanId(102));
		prepo.save(p2);
		
		Persion p3=new Persion();
		p3.setPerid(4);
		p3.setPerGender("male");
		p3.setPerName("kumar");
		p3.setPerAdd("hyd");
		p3.setCard(crepo.findByPanId(103));
		
		prepo.save(p3);
		
		//prepo.deleteById(2);
		

		
	}

}

package com.in.indium.runner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Ragistration;
import com.in.indium.repo.RagisterRepo;
@Component
public class MyRunner implements CommandLineRunner {
   @Autowired
	private RagisterRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		/*// TODO Auto-generated method stub
		Ragistration r=new Ragistration();
		
		r.setName("raju");
       r.setStartDate(new Date());
       r.setEndDate(new Date());*/
       
       List<Ragistration>list=Arrays.asList(
    		       new Ragistration("raju",new Date(),new Date()),
    		       new Ragistration("raj",new Date(),new Date()),
    		       new Ragistration("kumar",new Date(),new Date()),
    		       new Ragistration("rahul",new Date(),new Date()),
    		       new Ragistration("rakesh",new Date(),new Date())
    		   
    		          );
       
       repo.saveAll(list);
	}

}

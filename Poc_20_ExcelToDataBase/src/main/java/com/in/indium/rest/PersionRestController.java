package com.in.indium.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.indium.model.PersionDetail;
import com.in.indium.repo.PersionDetailRepo;
import com.in.indium.util.PersionExcelUtil;

@RestController
public class PersionRestController implements CommandLineRunner {
     @Autowired
    private PersionDetailRepo repo; 
	
     
     @Autowired  
    private PersionExcelUtil util;
   List<PersionDetail> list= util.readFromExce();
@Override
public void run(String... args) throws Exception {
	System.out.println("start");
	repo.saveAll(list);
	System.out.println("end");
}
     

	
    
    
}
    
    
    
     


package com.in.indium.contaroller.rest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.catalina.startup.ListenerCreateRule.OptionalListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.in.indium.model.Ragister;
import com.in.indium.repo.RagisterRepo;
import com.in.indium.service.IRagisterService;

import net.bytebuddy.asm.Advice.Exit;
import net.bytebuddy.implementation.bytecode.Throw;

@RestController
@RequestMapping("rest/user")//controll+httpmethod
public class RagisterControllerRest {
	@Autowired
	private IRagisterService service;

	@Autowired
	private RagisterRepo repo;

	//1.save one recode
	@PostMapping("/save")
	public ResponseEntity<String>save(
			@RequestBody Ragister ragister
			){
		ResponseEntity<String>resp=null;
		Integer id=service.saveRagisterData(ragister);
		try {
			resp=new ResponseEntity<String>("SAVED '"+id+"'WITH RAGISTER",HttpStatus.CREATED);

		} catch (Exception e) {

			resp=new ResponseEntity<String>("UNABLE TO SAVE",HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}
	//2.getAll recode
	@GetMapping("/all")
	public ResponseEntity<List<Ragister>>getAllData() throws JsonGenerationException, JsonMappingException, IOException
	{
		//one row of data of db convert in list>>list.get(0)
		//2nd row of data of db convert in list>>list.get(1)
		List<Ragister>list=service.getAllRagisterData();
		/*
		 * System.out.println("allllllllllllll>>>"+list.size());
		 * System.out.println(list);
		 * System.out.println(list.get(0)+">>>>>>???????"+list.get(1));
		 */
		return new ResponseEntity<List<Ragister>>(list,HttpStatus.OK);

	}


	//3.getone  recode

	@PostMapping("/one") public
	ResponseEntity<String>getNameAndPwd(
		
			@RequestBody  Ragister ragister) throws JsonGenerationException,
	
	                                      JsonMappingException, IOException
     	{
		
	//	ResponseEntity<String> res=null;
		
	      Ragister list=repo.findByNameAndPassward(ragister.getName(), ragister.getPassward());
	          if(list!=null) {
	    	  return  new ResponseEntity<String>(list.getName().toUpperCase()+"<<<<SUCCESSFULLY LOGIN >>>>",HttpStatus.OK); 
	           }
	
	          return new  ResponseEntity<String>(" INVALID USER ",HttpStatus.BAD_REQUEST);
		  

	}
	

	@GetMapping("/one/{id}") 
	public
	       ResponseEntity<?>getOneData(
			@PathVariable Integer id

			)
				throws JsonGenerationException,
	                   JsonMappingException, IOException
	{
          //get the dat from db
           Optional<Ragister> opt =  repo.findById(id);
           
           ResponseEntity<?> resp=null;
           
       //if id is present
           if(opt.isPresent()) {
        	   //responseentity have two things body+header(status) 
        	   //get() if data is there then it return value otherwise
        	   //it return  throw new NoSuchElementException("No value present"
        	   resp= new ResponseEntity<Ragister>(opt.get(),HttpStatus.OK); 
           } else {
        	   //string+400>>>badrequest
        	   resp=new ResponseEntity<String>(" DATA NOT FOUND ",HttpStatus.BAD_REQUEST);
           }
		 
	
		return  resp; 

	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> DeleteById(
		          @PathVariable Integer id
			){
		//boolean exist= repo.existsById(id);
	      ResponseEntity<?> resp=null;
		
		if(repo.existsById(id)) {
			   repo.deleteById(id);
			   resp= new ResponseEntity<String>("DATA DELRTED",HttpStatus.OK); 
		}
		else {
			resp=new ResponseEntity<String>(" DATA NOT FOUND ",HttpStatus.BAD_REQUEST);
			
		}
		return resp;
		
	}

}
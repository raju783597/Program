package com.in.indium.controller.rest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.in.indium.model.User;
import com.in.indium.service.IUserService;

@RestController
@RequestMapping("rest/user")
public class UserRestController {
	@Autowired
	private IUserService service;
   //1.getAll recode
	@GetMapping("/all")
	public ResponseEntity<List<User>>getAll() throws JsonGenerationException, JsonMappingException, IOException
	  {
		
		List<User>list=service.getAllUser();
		//ok() set the body and return http-Status
	                           //return ResponseEntity.ok(list);
		/*
		 * //store in pdf ObjectMapper om=new ObjectMapper(); File f=new
		 * File("D:/abc.json"); om.writeValue(f,list);
		 */
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
		
	}
	
	
	//2.get one recode
	@GetMapping("/one/{id}")
	public ResponseEntity getOne(
	     @PathVariable Integer id )
	  {
	Optional<User> opt= service.getOneUser(id);
	ResponseEntity<?>resp=null;
	if(opt.isPresent()) {
	resp=new ResponseEntity<User>(opt.get(),HttpStatus.OK);
	}else {
		resp=new ResponseEntity<>("data not found",HttpStatus.BAD_REQUEST);		
	    }
	return resp;
	  }
	
	//3.delete one recode
	@DeleteMapping("/remove/{id}")
	 public ResponseEntity<String>delete(
			 @PathVariable Integer id )
	 {
		 ResponseEntity<String> resp =null;
		if(service.isExistUser(id)) {
			 service.deleteUser(id);
			 resp =new ResponseEntity<String>("USER DELETED" ,HttpStatus.OK );
		 }else {
			 
			 resp=new ResponseEntity<String>("USER DATA NOT EXIST" ,HttpStatus.NOT_FOUND);
		 }
		return resp;
		 
		 
	 }
	//4.save one recode
	@PostMapping("/insert")
	public ResponseEntity<String>save(
			@RequestBody User user
			){
		ResponseEntity<String>resp=null;
		Integer id=service.saveUser(user);
		try {
			resp=new ResponseEntity<String>("SAVED '"+id+"'WITH USER",HttpStatus.CREATED);
			
		} catch (Exception e) {
	
			resp=new ResponseEntity<String>("UNABLE TO SAVE",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resp;
		
	}
	
	//5.update one recode
	
	@PutMapping("/modify")
	public ResponseEntity<?>update(
			@RequestBody User user
			)  {
		ResponseEntity<?>resp=null;
		Integer id=service.saveUser(user);
		
		if(!service.isExistUser(id)) {
			
			resp=new ResponseEntity<String>
			           ("UNABLE TO UPDATE",HttpStatus.NOT_FOUND);
		}else {
			service.updateUser(user);
			resp=new ResponseEntity<String>
			           ("UPDATED"+id+"'WITH USER",
			        		   HttpStatus.RESET_CONTENT);
		}

		
		return resp;
		     
	    }
	
}

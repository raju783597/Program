package com.in.indium.controller.rest;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in.indium.Poc4Producer;
import com.in.indium.iservice.IRoleService;
import com.in.indium.model.Role;

@RestController
@RequestMapping("/rest/role")
public class RoleRestController {  
	
	//private static Logger log=Logger.getLogger(RoleRestController.class);

	@Autowired
	private IRoleService service;
	
	//1 get all recodes from data
	@GetMapping("/all") 
	public ResponseEntity<List<Role>> getAll(){
		//Layout layout=null;
		//Appender app=new ConsoleAppender();
		
		List<Role>list= service.getAllRole();
		return ResponseEntity.ok(list);
	}
	
	  //2.get one recode
	  
	  @GetMapping("/one/{id}") public ResponseEntity <?> getOne(
	  
	  @PathVariable Integer id ) { Optional<Role> opt= service.getone(id);
	  ResponseEntity<?>resp=null; if(opt.isPresent()) { resp=new
	  ResponseEntity<Role>(opt.get(),HttpStatus.OK); }else { resp=new
	  ResponseEntity<String>("data not found",HttpStatus.BAD_REQUEST); } return
	  resp; }
	 
	
	//3.delete one recode
		@DeleteMapping("/remove/{id}")
		 public ResponseEntity<String>delete(
				 @PathVariable Integer id )
		 {
			 ResponseEntity<String> resp =null;
			if(service.isExist(id)) {
				 service.deleteRole(id);
				 resp =new ResponseEntity<String>("ROLE DELETED" ,HttpStatus.OK );
			 }else {
				 
				 resp=new ResponseEntity<String>("ROLE DATA NOT EXIST" ,HttpStatus.NOT_FOUND);
			 }
			return resp;
			 
			 
		 }
		//4.save one recode
		@PostMapping("/insert")
		public ResponseEntity<String>save(
				@RequestBody Role role
				){
			ResponseEntity<String>resp=null;
			Integer id=service.saveRole(role);
			try {
				resp=new ResponseEntity<String>("SAVED '"+id+"'WITH ROLE",HttpStatus.CREATED);
				
			} catch (Exception e) {
		
				resp=new ResponseEntity<String>("UNABLE TO SAVE",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return resp;
			
		}
		
		//5.update one recode
		
		@PutMapping("/modify")
		public ResponseEntity<?>update(
				@RequestBody Role role
				)  {
			ResponseEntity<?>resp=null;
			Integer id=service.saveRole(role);
			
			if(!service.isExist(id)) {
				
				resp=new ResponseEntity<String>
				           ("UNABLE TO UPDATE",HttpStatus.NOT_FOUND);
			}else {
				service.updateRole(role);
				resp=new ResponseEntity<String>
				           ("UPDATED WITH ROLE  " +id,
				        		   HttpStatus.RESET_CONTENT);
			}

			
			return resp;
			     
	
}
}

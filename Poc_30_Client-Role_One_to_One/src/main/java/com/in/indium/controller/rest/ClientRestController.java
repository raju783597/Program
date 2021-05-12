package com.in.indium.controller.rest;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.in.indium.model.Client;
import com.in.indium.service.ClientService;
import com.in.indium.service.DevService;

@RestController
@RequestMapping("/rest")
public class ClientRestController {
@Autowired	
public	ClientService service;
//@Autowired
//public DevService devservice;
    //save
	@PostMapping("/client/insert")
	//@requestBody get the jsondata and convert in to object
	public ResponseEntity<String>SaveData(@RequestBody Client client){
		
		ResponseEntity<String> resp=null;
		try {
		Integer id=	service.saveClient(client);
			
			resp=new ResponseEntity<String>("save with>>"+id,HttpStatus.CREATED);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>("<<not save>>",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return resp;
		
	}
	
	//get all
	@GetMapping("/all")
	public ResponseEntity<List<Client>>getAll(){
	 List<Client>  list	=service.getAllData();
		return ResponseEntity.ok(list);
		
	}
	//delete
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		if(service.isClientExist(id)) {
			
			try {
				service.remove(id);
				resp=new ResponseEntity<String>("<<deleted with>>>"+id,HttpStatus.OK);
				
			} catch (Exception e) {
				// TODO: handle exception
				resp=new ResponseEntity<String>("<<cant be deleted use by another integrity>>>"+id,HttpStatus.BAD_REQUEST);
			}
			
		}
		else {
			
			resp=new ResponseEntity<String>("<<not found >>"+id,HttpStatus.NOT_FOUND);
		}
		return resp;
		
	}
	//update
	@PutMapping("/modify")
	public ResponseEntity<String> update(
			@RequestBody Client client
			){
		ResponseEntity<String> resp=null;
		if(client.getCid()==null||!service.isClientExist(client.getCid())) {
			resp=new ResponseEntity<String>("<<<not updated>>>>",HttpStatus.NOT_FOUND);
		}else {
			service.updateDta(client);
			resp=new ResponseEntity<String>("<<<updated with>>"+client.getCid(),HttpStatus.RESET_CONTENT);
		}
		
		return resp;
		
	}
	

}

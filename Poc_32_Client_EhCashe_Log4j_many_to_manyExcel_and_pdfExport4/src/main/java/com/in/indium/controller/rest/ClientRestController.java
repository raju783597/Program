package com.in.indium.controller.rest;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;
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
import org.springframework.web.servlet.ModelAndView;

import com.in.indium.model.Client;
import com.in.indium.model.Devloper;
import com.in.indium.repo.Devloperrepo;
import com.in.indium.service.ClientService;
import com.in.indium.service.DevService;
import com.in.indium.view.ClientExcelView;
import com.in.indium.view.ClientPdfView;


@RestController
@RequestMapping("/rest")
public class ClientRestController {
	Logger log=Logger.getLogger(ClientRestController.class);
	//1.create layout
		//	Layout layout=new PatternLayout("%d{dd-MM-yy hh:mm} %p--- [%M]%c %L %m %n");
	//2. createlayout+ link layout
		//	Appender app1=new ConsoleAppender(layout);
		
	   		
		

	@Autowired	
	public	ClientService service;
	@Autowired
	public DevService devservice;


	@GetMapping("/excelexport")
	public ModelAndView exportToExcel(){
		log.info("start exportToExcel() ");
		ModelAndView   m=new ModelAndView();

		//Layout layout=new PatternLayout();
		List<Client> list =service.getAllData(); 
		 log.info("call the service layer from exportToExcel()");
		m.setView(new ClientExcelView());
		m.addObject("obj",list); 
		log.info("add the obj to model");
		//dev service
		List<Devloper> dev= devservice.getAllData();
		m.addObject("dev",dev);

		log.info("end exportToExcel()");
		return m; //return ResponseEntity.ok(list);
	}

	@GetMapping("/pdfexport")
	public ModelAndView exportPdfAll() {
		ModelAndView m=new ModelAndView();
		m.setView(new ClientPdfView());
		List<Client> list1 =service.getAllData(); 
		m.addObject("obj1",list1); 

		List<Devloper> dev1= devservice.getAllData();
		m.addObject("dev",dev1);

		return m;

	}


	//save
	@PostMapping("/client/insert")
	//@requestBody get the json data and convert in to object
	public ResponseEntity<String>SaveData(@RequestBody Client client
			//  @RequestBody Devloper developer
			){
		log.info("entered into save method");
		    ResponseEntity<String> resp=null;
		try {
			// client.setDev(devloper);
			Integer id=	service.saveClient(client);

			
			log.debug("save with>>"+id);

			//3 link appender with  logger
		//	log.
			//Integer id1=devservice.saveDev(devloper);		
			//Object id=service.saveClient(client.getDev(devloper));

			resp=new ResponseEntity<String>("save with>>"+id,HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("unable to save"+e.getMessage());
			resp=new ResponseEntity<String>("<<not save>>",HttpStatus.INTERNAL_SERVER_ERROR);
		}
log.info("back to ui");
		return resp;

	}
	

	//get all
	@GetMapping("/all")
	public ResponseEntity<List<Client>>getAll() throws IOException{
	
		log.info(">>>>>>>>>enter in restController>>>getAll() <<<<<<<<<");
		List<Client>  list	=service.getAllData(); 
		log.info(">>>>>>>>>enter in restController>>>getAll() <<<<<<<<<"+list.size());
		log.info(">>>>>>>>>fatching the data from serviceimpl by getAll()<<<<<<<<<");
		log.info(">>>>>>>>>end of getAll()<<<<<<<<<");
		
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

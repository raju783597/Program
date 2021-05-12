package com.in.indium.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.in.indium.excel.ClientExcelImporter;
import com.in.indium.model.ClientUser;
import com.in.indium.repo.ClientUserRepository;

@RestController
@RequestMapping("/web")
public class ClientController {
   // @Autowired
	//private ClientExcelImporter excelImporter;

	@Autowired
	private ClientUserRepository clientRepo;


	@RequestMapping("/import")
	@ResponseBody
	public String importFromExcel() {
		ClientExcelImporter excelImporter=new ClientExcelImporter();
		List<ClientUser> list= excelImporter.excelImport();
		
		
		clientRepo.saveAll(	list.stream()
				               .filter(C->C.getClient()>0)
                               .collect(Collectors
               		                     .toList()
               		                    )
                           );
                               
		
		
		return "Import Successfully_2";
	}
	
	// 2.getAll recode
		@GetMapping("/all")
		public ResponseEntity<List<ClientUser>>getAllData() throws JsonGenerationException, JsonMappingException, IOException
		{
			//List<ClientUser>list=clientRepo.findAll();
			
			List<ClientUser>list1=(clientRepo.findAll().stream()
		                         .filter(C->C.getClient()>0)
                                 .collect(Collectors
    		                     .toList()
    		                       )
                                );
			
       long list2=list1.stream().filter(c->c.getClient()>0).count();
        
       System.out.println(">>>>>>>>count the data>>>>>"+list2);                         

		return new ResponseEntity<List<ClientUser>>(list1,HttpStatus.OK);

		}
		//3
		@PostMapping("/fileimport")
		public String fileRead() {
			
			return"Home";
			
		}

}

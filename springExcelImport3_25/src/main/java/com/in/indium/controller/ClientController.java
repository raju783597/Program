package com.in.indium.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.in.indium.excel.UserExcelImporter;
import com.in.indium.model.ClientUser;
import com.in.indium.repo.ClientUserRepository;

@RestController
@RequestMapping("/web")
public class ClientController {
    @Autowired
	private UserExcelImporter excelImporter;

	@Autowired
	private ClientUserRepository clientRepo;


	@RequestMapping("/import")
	@ResponseBody
	public String importFromExcel() {
		//UserExcelImporter excelImporter=new UserExcelImporter();
		List<ClientUser> list= excelImporter.excelImport();
		clientRepo.saveAll(list);
		return "Import Successfully_3";
	}
	// 2.getAll recode
		@GetMapping("/all")
		public ResponseEntity<List<ClientUser>>getAllData() throws JsonGenerationException, JsonMappingException, IOException
		{
			//one row of data of db convert in list>>list.get(0)
			//2nd row of data of db convert in list>>list.get(1)
			List<ClientUser>list=clientRepo.findAll();
			/*
			 * System.out.println("allllllllllllll>>>"+list.size());
			 * System.out.println(list);
			 * System.out.println(list.get(0)+">>>>>>???????"+list.get(1));
			 */
			//body+status >>>OK(200, Series.SUCCESSFUL, "OK"),
			return new ResponseEntity<List<ClientUser>>(list,HttpStatus.OK);

		}

}

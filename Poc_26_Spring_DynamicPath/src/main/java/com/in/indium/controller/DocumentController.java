package com.in.indium.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.in.indium.excel.ClientExcelImporter;
import com.in.indium.iservice.IDocumentService;
import com.in.indium.model.ClientUser;
import com.in.indium.model.Document;
import com.in.indium.repo.ClientUserRepository;

@Controller
@RequestMapping("/documents")
public class DocumentController {
	@Autowired
     private IDocumentService service;
	
	@Autowired
	private ClientExcelImporter excel;
	
	@Autowired
	private ClientUserRepository clientrepo;

	@GetMapping("/all")
	public String showUploadPage() {
		return "Documents";
		
	}
	//
	@PostMapping("/save")
	public String upload(@RequestParam Integer fileId,
			             @RequestParam MultipartFile fileObj,
			             
			             Model model
			             
			             ) {
		 // String path = System.getProperty("path");
		
		if(fileObj!=null && fileId!=null) {
			
			Document doc=new Document();
			
			doc.setDocId(fileId);
			doc.setDocName(fileObj.getOriginalFilename());
			try {
				doc.setDocData(fileObj.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 */
			//excel.fileNameDynamic(fileObj.getOriginalFilename());
			//excel.fileNameDynamic(path);
			
			 List<ClientUser>list=excel.excelImport();
			 clientrepo.saveAll(list);
		
			 
			 
			 service.saveDocument(doc);			
		}
		return "Documents";
		
	}
}

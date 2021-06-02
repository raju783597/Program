package com.in.indium.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hpsf.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.in.indium.iservice.IAlternateService;
import com.in.indium.model.Alternate;
import com.in.indium.model.Profit;
import com.in.indium.repo.AlternateRepo;
import com.in.indium.repo.ProfitRepo;
@Service
public class AlternateServiceImpl implements IAlternateService {


	@Autowired
	private AlternateRepo repo;
	
	@Autowired
	private ProfitRepo prepo;

	@Override
	public List<Alternate> findAll() {

		return null;
	}

	@Override
	public boolean saveDataFromUploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		boolean isFlag=false;
		String extention=FilenameUtils.getExtension(file.getOriginalFilename());
		System.out.println(">>>>>>>"+extention);
		
	     if(extention.equalsIgnoreCase("xls")||extention.equalsIgnoreCase("xlsx")) {
			isFlag=readDataFromExcel(file);
			System.out.println(">>>>"+isFlag);
		}
		return isFlag;
	}
	
	
	private boolean readDataFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		System.out.println("from service>>>>file name"+file.getOriginalFilename());
		System.out.println("from service>>>>file size"+file.getSize());
		try {
			System.out.println("from service>>>>file size"+file.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Workbook workbook=getWorkBook(file);
		//getting the sheet at index zero
		Sheet sheet=workbook.getSheetAt(0);	
		Iterator<Row>rows=sheet.iterator();
		rows.next();
		while(rows.hasNext()) {
			Row row=rows.next();
			
			Alternate clientUser=new Alternate();
               Profit profit=new Profit();
				try {
                    //a
					clientUser.setA(row.getCell(0).getStringCellValue());
					//b
					clientUser.setB(row.getCell(1).getStringCellValue());
					
					//c
					 clientUser.setC(row.getCell(2).getStringCellValue());
               	    
               	   
				
				} catch (Exception e) {
					// TODO: handle exception
					 Cell cell = row.getCell(0,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				     clientUser.setA(cell.toString());
				     
				 cell =
					    row.getCell(1,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
							  clientUser.setB(cell.toString());
				//c	
				cell = row.getCell(2,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
							    clientUser.setC(cell.toString()) ; 
							    
				
							    
				     }
			
				System.out.println(">>>>>AA>>"+clientUser.getA()); 
			    System.out.print(">>B>>>"+clientUser.getB());
				System.out.print(">>C>>>"+clientUser.getC());
			
		
			
			  profit.setNarration(clientUser.getB());//narator			  
			  profit.setDate(clientUser.getC());//
			  profit.setBalance((clientUser.getC()));
			  profit.setStrategyName("Alternate/EAF"); 
			  
			 // List<String>list=Arrays.asList(clientUser.getC());
			//  list.stream().filter(list->"a".equalsIgnoreCase(null)) ;
			  
		//	  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+list);
			  
			// Predicate<String>p1=n->n.startsWith("A");
			  
		//	repo.save(clientUser); 
			prepo.save(profit);

			clientUser.setFiletype(file);
		}//while



		return true;
	}

	private Workbook getWorkBook(MultipartFile file) {
		// TODO Auto-generated method stub
		Workbook workbook=null;

		String extention=FilenameUtils.getExtension(file.getOriginalFilename());
		try {
			if(extention.equalsIgnoreCase("xlsx")) {
				workbook=new  XSSFWorkbook(file.getInputStream() );

			}else if(extention.equalsIgnoreCase("xls"))  {

				workbook=new  HSSFWorkbook(file.getInputStream() );
				System.out.println("workbook from service getWorkbook>>>>>>"+workbook); 
				System.out.println("workbook service getWorkbook >>>>>>"+workbook.getActiveSheetIndex()); 
				System.out.println("workbook service getWorkbook >>>>>>"+workbook.getFirstVisibleTab()); 
				System.out.println("workbook service getWorkbook >>>>>>"+workbook.getAllNames()); 
				System.out.println("workbook service getWorkbook >>>>>>"+workbook.getNumberOfNames()); 
				System.out.println("workbook service getWorkbook >>>>>>"+workbook.getNumCellStyles()); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return workbook;

	}
	

}

package com.in.indium.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hpsf.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.in.indium.iservice.IAlternateService;
import com.in.indium.model.Alternate;
import com.in.indium.model.Profit;
import com.in.indium.repo.AlternateRepo;
import com.in.indium.repo.ProfitRepo;

import javassist.bytecode.stackmap.BasicBlock.Catch;
@Primary
@Service
public class AlternateServiceImpl2 implements IAlternateService {


	@Autowired
	private AlternateRepo repo;
	
	@Autowired
	private ProfitRepo prepo;

	//@Override
	//public List<Alternate> findAll() {

	//	return null;
	//}
	
static	MultipartFile file1;

	@Override
	public boolean saveDataFromUploadFile(MultipartFile file) {
		this.file1=file;
		// TODO Auto-generated method stub
		boolean isFlag=false;
		//check file extention
		String extention=FilenameUtils.getExtension(file.getOriginalFilename());
		System.out.println(">>>>>>>"+extention);
		
	     if(extention.equalsIgnoreCase("xls")||extention.equalsIgnoreCase("xlsx")) {
			//read file data
	    	 isFlag=readDataFromExcel(file);
			System.out.println(">>>>"+isFlag);
		}
		return isFlag;
	}
	
	
	//get cell data
	public static String readcellData(int vrow,int vcol) {
		String value=null;
		Integer no=0;
		Workbook wb=null;
		//get workbook 
		wb=getWorkBook(file1);
		//getting the sheet at index zero
		Sheet sheet=wb.getSheetAt(0);
		Row r=sheet.getRow(vrow);
		Cell cell=r.getCell(vcol);	
		
		try {
			value=cell.getStringCellValue();
			
		} catch (Exception e) {
			// TODO: handle exception
			 Date date=new Date();
		value=	 cell.getLocalDateTimeCellValue().toString();
			//no=(int) cell.getNumericCellValue();
		 // value=String.valueOf(no);
		}
		

		return value;
		
	}
	
	
	
	private boolean readDataFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		System.out.println("from service>>>>file name"+file.getOriginalFilename());
		System.out.println("from service>>>>file size"+file.getSize());
		try {
			//file.getInputStream() read content of file in stream
			System.out.println("from servicefile.getInputStream()>>>>"+file.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//get workbook
		Workbook workbook=getWorkBook(file);
		//getting the sheet at index zero
		Sheet sheet=workbook.getSheetAt(0);	//
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
				//setting excelsheet data to profit class
			      profit.setNarration(clientUser.getB());//narator 
				
			      /* allValues=lines.flatMap(Pattern.compile(" *")::splitAsStream)
                                      .filter(s -> s.matches("[0-9]+"))
                                      .map(Integer::valueOf)
                                       .collect(Collectors.toList());
					   
					*/ 
					 Pattern p=Pattern.compile("\\w+([0-9]+)");
				     Matcher matcher = p.matcher(clientUser.getC().toString());
					 if( matcher.find()) {
						 
						 profit.setBalance(clientUser.getC());
					 }
				  
				  //row,col
				  for(int i=2;i<3;i++) {
 
					  for(int j=2;j<3;j++) {
						  profit.setStrategyName(readcellData(j, i)); //22
						  j++;
						  profit.setDate(readcellData(j, i)); //32
					  }

				  }
					/*
					 * profit.setStrategyName(readcellData(2, 2)); profit.setDate("25/4/2002");
					 * profit.setDate(readcellData(3, 2));
					 */
		           
			prepo.save(profit);

			clientUser.setFiletype(file);
		}//while



		return true;
	}
//creating workbook
	private static Workbook getWorkBook(MultipartFile file) {
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

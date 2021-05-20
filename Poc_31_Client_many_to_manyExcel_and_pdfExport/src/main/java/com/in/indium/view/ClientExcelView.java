package com.in.indium.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.in.indium.model.Client;
import com.in.indium.model.Devloper;
import com.in.indium.service.DevService;

public class ClientExcelView  extends AbstractXlsxView{
	
	@Autowired
	public DevService devservice;
	  
	


	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			                                   Workbook workbook,
			                            HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	//download+filename
	response.addHeader("Content-Disposition", "attachment;filename=Client-Role-Data.xlsx");	  
	//read data from controller
	@SuppressWarnings("unchecked")
	 List<Client>list=  (List<Client>) model.get("obj");
	List<Devloper>dev=  (List<Devloper>) model.get("dev");
	

	
	Sheet sheet=  workbook.createSheet("client-role");
	
	setHead(sheet);
	setBody(sheet,list,dev);
	
	//2nd sheet
    Sheet sheet2=workbook.createSheet("Role");
	
	setHeadIndev(sheet2);
	setBodyIndev(sheet2,dev);
	}



//in roll sheet heading
	private void setHeadIndev(Sheet sheet2) {
Row r1=sheet2.createRow(0);
r1.createCell(5).setCellValue("DEV_ID"); 
r1.createCell(6).setCellValue("DEV_NAME");
r1.createCell(7).setCellValue("DEV_ROLE");
	}

	private void setBodyIndev(Sheet sheet2, List<Devloper> dev1) {
		Row r=null;
		int rowdev=1;
	for(Devloper d:dev1) {
		
		
	       r=sheet2.createRow(rowdev);
				  r.createCell(5).setCellValue(d.getDevid());
				  r.createCell(6).setCellValue(d.getDevName());
				  r.createCell(7).setCellValue(d.getDevRole());
	     
	rowdev++;
		}
		
	}
//set heding in client
	private void setHead(Sheet sheet) {
  Row r=sheet.createRow(0);	
  r.createCell(0).setCellValue("C_ID");
  r.createCell(1).setCellValue("C_LOCATION");
  r.createCell(2).setCellValue("C_NAME");
  r.createCell(3).setCellValue("CPROJ_NAME");
  r.createCell(4).setCellValue("  ");
 
  r.createCell(5).setCellValue("DEV_ID"); 
  r.createCell(6).setCellValue("DEV_NAME");
  r.createCell(7).setCellValue("DEV_ROLE");
	}
	//body
	private void setBody(Sheet sheet, List<Client> list,List<Devloper> dev) {
	int rowNum=1;

	Row r=null;
		for(Client cl:list) {
			 r=sheet.createRow(rowNum);
		
			  r.createCell(0).setCellValue(cl.getCid());
			  r.createCell(1).setCellValue(cl.getCLocation());
			  r.createCell(2).setCellValue(cl.getCName());
			  r.createCell(3).setCellValue(cl.getCprojName());
			  r.createCell(4).setCellValue(" ");
				/*
				 * dev.forEach( (d)-> {
				 * 
				 * r.createCell(5).setCellValue(d.getDevid());
				 * r.createCell(6).setCellValue(d.getDevName());
				 * r.createCell(7).setCellValue(d.getDevRole()); } );
				 */
			  
			  rowNum++;
	     	}
			
			  for(Devloper d:dev) { 
				  int row=rowNum++; //int row=1;
			  
			  r=sheet.createRow(row);
			  r.createCell(5).setCellValue(d.getDevid());
			  r.createCell(6).setCellValue(d.getDevName());
			  r.createCell(7).setCellValue(d.getDevRole());
			  
			  row++;
			  }
			 
			  
			
		}
		
	
     		
	}



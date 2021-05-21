package com.in.indium.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.in.indium.model.Client;
import com.in.indium.model.Devloper;
import com.in.indium.service.DevService;



public class ClientExcelView  extends AbstractXlsxView{
	
	@Autowired
	public DevService devservice;

	/*  AbstractXlsxView  is class which extends AbstractXlsView  in this  
	 *  buildExcelDocument() is define  for building the xlsx	
	 * Application-provided subclasses must implement this method to populate
	 * the Excel workbook document, given the model.
	*/
	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			                                   Workbook workbook,
			                            HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		//download+filename
		/*
		 * Adds a response header with the given name and value. This method allows
         * response headers to have multiple values.
         *
		 */
	response.addHeader("Content-Disposition", "attachment;filename=Client-Role-Data.xlsx");	  
	
	//read client object data from controller
	@SuppressWarnings("unchecked")
	 List<Client>list=  (List<Client>) model.get("obj");
	
	//read Devloper object data from controller
	List<Devloper>dev=  (List<Devloper>) model.get("dev");
	

	//creating of sheet
	Sheet sheet=  workbook.createSheet("client-role");
	//setHeader() to set head of sheet
	setHead(sheet);
	//setBody() to set body of sheet
	setBody(sheet,list,dev);
	
	//2nd sheet creating 
    Sheet sheet2=workbook.createSheet("Role");
	
	setHeadIndev(sheet2);
	setBodyIndev(sheet2,dev);
	}

//in roll sheet heading
	private void setHeadIndev(Sheet sheet2) {
  //creating row 
 Row r1=sheet2.createRow(0);
//creating cell from cell no5  of row for header
r1.createCell(5).setCellValue("DEV_ID"); 
r1.createCell(6).setCellValue("DEV_NAME");
r1.createCell(7).setCellValue("DEV_ROLE");
	}

	private void setBodyIndev(Sheet sheet2, List<Devloper> dev1) {
		Row r=null;
		int rowdev=1;
	for(Devloper d:dev1) {
		//creating row 
	       r=sheet2.createRow(rowdev);
	    //setting data in cell on cell no. 5 on ward   
				  r.createCell(5).setCellValue(d.getDevid());
				  r.createCell(6).setCellValue(d.getDevName());
				  r.createCell(7).setCellValue(d.getDevRole());
	     
	rowdev++;
		}
		
	}
//set heding in client
	private void setHead(Sheet sheet) {
	//creating row 	
  Row r=sheet.createRow(0);	
  //setting header data to cell
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
			//creating row
			 r=sheet.createRow(rowNum);
		 //setting data in cell no, 0 onward
			  r.createCell(0).setCellValue(cl.getCid());
			  r.createCell(1).setCellValue(cl.getCLocation());
			  r.createCell(2).setCellValue(cl.getCName());
			  r.createCell(3).setCellValue(cl.getCprojName());
			  r.createCell(4).setCellValue(" ");
			 

			  rowNum++;
	     	}
		for(Devloper d:dev) {
			int row=rowNum++;
			//int row=1;
			
		       r=sheet.createRow(row);
					  r.createCell(5).setCellValue(d.getDevid());
					  r.createCell(6).setCellValue(d.getDevName());
					  r.createCell(7).setCellValue(d.getDevRole());
		     
		row++;
			}
			
			  
			
		}
		
	
     		
	}



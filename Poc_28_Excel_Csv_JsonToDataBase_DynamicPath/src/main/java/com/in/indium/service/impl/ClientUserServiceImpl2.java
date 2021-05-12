package com.in.indium.service.impl;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hpsf.Date;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.in.indium.iservice.IClientUserService;
import com.in.indium.model.ClientUser;
import com.in.indium.repo.ClientUserRepository;

@Service
@Transactional
@Primary
public class ClientUserServiceImpl2 implements IClientUserService {
    @Autowired
	private ClientUserRepository repo;

	@Override
	public List<ClientUser> findAll() {
		
		return repo.findAll();
	}

	@Override
	public boolean saveDataFromUploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		boolean isFlag=false;
		String extention=FilenameUtils.getExtension(file.getOriginalFilename());
		System.out.println(">>>>>>>"+extention);
		if(extention.equalsIgnoreCase("json")) {
			isFlag=readDataFromJson(file);
		}
		if(extention.equalsIgnoreCase("csv")) {
			isFlag=readDataFromcsv(file);
		}else if(extention.equalsIgnoreCase("xls")||extention.equalsIgnoreCase("xlsx")) {
			isFlag=readDataFromExcel(file);
			System.out.println(">>>>"+isFlag);
		}
		
		
		return isFlag;
	}
		
	//from excel
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
		Sheet sheet=workbook.getSheetAt(0);
		Iterator<Row>rows=sheet.iterator();
			//System.out.println("row read data from excel"+Row.getPhysicalNumberOfCells());
		rows.next();
	    while(rows.hasNext()) {
	    	Row row=rows.next();
	    	ClientUser clientUser=new ClientUser();
	    	
			/*
			 * if(row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) { String
			 * Client=NumberToTextConverter.toText(row.getCell(0).getNumericCellValue());
			 * clientUser.setClient((int) row.getCell(0).getNumericCellValue());
			 * 
			 * }
			 */
			
			  if(row.getCell(0).getCellType() !=null) {
			  clientUser.setClient((int) row.getCell(0).getNumericCellValue());
			  System.out.println(">>>>>"+clientUser.getClient());
			  }
			  
			  if(row.getCell(1).getCellType() !=null) {
			  clientUser.setName(row.getCell(1).getStringCellValue());;
			  System.out.print(">>name>>>"+clientUser.getName());
			  
			  } if(row.getCell(2).getCellType() !=null) {
			  clientUser.setCliCode(row.getCell(2).getStringCellValue());;
			  System.out.print(">>code>>>"+clientUser.getCliCode());
			  
			  } if(row.getCell(3).getCellType() !=null) {
			  clientUser.setCliType(row.getCell(3).getStringCellValue());;
			  System.out.print(">>client type>>>"+clientUser.getCliType());
			  
			  }if(row.getCell(4).getCellType() !=null) {
			  clientUser.setAccType(row.getCell(4).getStringCellValue());;
			  System.out.print(">>account type>>>"+clientUser.getAccType());
			  
			  }if(row.getCell(5).getCellType() !=null) {
				  try {
					  Date date=new Date();
					   // date.getLocalDateTimeCellValue();
					  clientUser.setDate(row.getCell(5).getLocalDateTimeCellValue().toString());
					 // clientUser.setDate(row.getCell(5).getStringCellValue());;
					  System.out.print(">>date type>>>"+clientUser.getDate());
					
				} catch (Exception e) {
					
					
				}
			  
			  }if(row.getCell(6).getCellType() !=null) {
			  clientUser.setINameType(row.getCell(6).getStringCellValue());;
			  System.out.print(">>intermediate name>>>"+clientUser.getINameType());
			  
			  }if(row.getCell(7).getCellType() !=null) {
			  clientUser.setSchName(row.getCell(7).getStringCellValue());;
			  System.out.print(">>schame name>>>"+clientUser.getSchName());
			  
			  }if(row.getCell(8).getCellType() !=null) {
			  clientUser.setRegMgName(row.getCell(8).getStringCellValue());;
			  System.out.print(">>regnal manager name>>>"+clientUser.getRegMgName());
			  
			  }if(row.getCell(9).getCellType() !=null) {
			  clientUser.setBillGroup(row.getCell(9).getStringCellValue());;
			  System.out.print(">>billgroup>>>"+clientUser.getBillGroup());
			  
			  }if(row.getCell(10).getCellType()!=null) {
				  try {
					  clientUser.setShare(row.getCell(10).getStringCellValue());
					  System.out.print(">>share>>>"+clientUser.getShare());
					
				} catch (Exception e) {
					// TODO: handle exception
					clientUser.setShare( String.valueOf(row.getCell(10).getNumericCellValue()));
				}
			  
			  }
	
// MultipartFile multipartFile = new MultipartFile(file.getOriginalFilename());
			  repo.save(clientUser); 
	clientUser.setFiletype(file);	    	
	    }
		return true;
	}
//check slx or xlsx file
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

	//csv file method
	private boolean readDataFromcsv(MultipartFile file) {
		// TODO Auto-generated method stub
		return false;
	}


	


//json
	private boolean readDataFromJson(MultipartFile file) {
		// TODO Auto-generated method stub
		return false;
	}
}

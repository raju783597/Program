package com.in.indium.service.impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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

import com.in.indium.iservice.IClientUserService;
import com.in.indium.model.ClientUser;
import com.in.indium.repo.ClientUserRepository;

@Service
@Transactional
//@Primary
public class ClientUserServiceImpl implements IClientUserService {
    
	Integer client;
	String name="";    String code=""; 
	String cliType=""; String accType="";
	String date="";    String iNameType="";
	String schName=""; String RegMgName="";
	String billGroup="";
	String share="";
	
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
		if(extention.equalsIgnoreCase("json")) {
			isFlag=readDataFromJson(file);
		}
		if(extention.equalsIgnoreCase("csv")) {
			isFlag=readDataFromcsv(file);
		}else if(extention.equalsIgnoreCase("xls")||extention.equalsIgnoreCase("xlsx")) {
			isFlag=readDataFromExcel(file);
		}
		
		
		return isFlag;
	}
		
	//from excel
	private boolean readDataFromExcel(MultipartFile file) {
		// TODO Auto-generated method stub
		List<ClientUser> list=new ArrayList<>();
		//create the workbook
		ClientUser clientUser=new ClientUser();
		
		Workbook workbook=new HSSFWorkbook();
		//create sheet
		Sheet firstSheet=workbook.getSheetAt(0);
		//row iterator  is use for get object one by one
		Iterator<Row> rowIterator=firstSheet.iterator();
		rowIterator.next();
		//if next row is there then go 
		while(rowIterator.hasNext()) {
			
			Row nextRow = rowIterator.next();
			
			Iterator<Cell> cellIterator=nextRow.cellIterator();
			while(cellIterator.hasNext()) {
				Cell nextCell=cellIterator.next();

				int columnIndex=nextCell.getColumnIndex();
				System.out.println(">>>>>>>>"+columnIndex+">>>");
				switch (columnIndex) {
				case 0:
					client=(int)nextCell.getNumericCellValue();
					
					System.out.println("client-id>>"+client);
					break;
				case 1:
					name=nextCell.getStringCellValue();
					System.out.print("name>>"+name);
					break;

				case 2:
					code=nextCell.getStringCellValue();
					System.out.print("client code>>"+code);
					break;
				case 3:
					cliType=nextCell.getStringCellValue();
					System.out.print("clienttype>>"+cliType);
					break;
				case 4:
					accType=nextCell.getStringCellValue();
					System.out.print("acctype>>"+accType);
					break;
				case 5:

					try {
						//DateFormatter df=new DateFormatter("MM-dd-yyyy");
						date= nextCell.getLocalDateTimeCellValue().toString();
						System.out.print("date>>"+date);

					} catch (Exception e) {
						// TODO: handle exception
						//	e.printStackTrace();
						continue;
					}

					break;
				case 6:
					iNameType=nextCell.getStringCellValue();
					System.out.print("intermediary-name>>"+iNameType);
					break;
				case 7:
					schName=nextCell.getStringCellValue();
					System.out.print("scheme>>"+schName);
					break;
				case 8:
					RegMgName=nextCell.getStringCellValue();
					System.out.print("reg manger name+phone no>>"+RegMgName);
					break;
				case 9:
					billGroup=nextCell.getStringCellValue();
					System.out.print("billgroup>>"+billGroup);
					break;
				case 10:
					try {
						share=nextCell.getStringCellValue();
						System.out.print("% share>>"+share);	
					}catch (Exception e) {
						share=String.valueOf(nextCell.getNumericCellValue());
						continue;
					}

					System.out.println("................................................");
					break;
				
				}list.add(new ClientUser(client,
						name,
						code,
						cliType,
						accType,
						date,
						iNameType,
						schName,
						RegMgName,
						billGroup,
						share
                     
						));
				
			}
		}
	//	clientUser.setFiletype();
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
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

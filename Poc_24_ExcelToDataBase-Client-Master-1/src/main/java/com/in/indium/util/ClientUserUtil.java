package com.in.indium.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.in.indium.model.ClientUser;

@Component
public class ClientUserUtil {
	
	
	public List<ClientUser> readExcelData(){
		String excelfile="D:\\Client-Master.xls";
	    List<ClientUser> client=null;
	    InputStream file=null;
		try {
			client=new ArrayList<ClientUser>();
			//read file
		//Inputfi	File file=new File();
		 file=new FileInputStream(excelfile);
			Workbook book=new HSSFWorkbook(file);
			
			//read sheet
		Sheet s	=book.getSheet("Sheet1");
		//read row
		Iterator<Row> itr= s.iterator();
		while(itr.hasNext()) {
			Row r=itr.next();
			if(r.getRowNum()==0)
				continue;
			client.add(new ClientUser(
					(int)r.getCell(0).getNumericCellValue(),
					r.getCell(1).getStringCellValue(),
					r.getCell(2).getStringCellValue(),
					r.getCell(3).getStringCellValue(),
					r.getCell(4).getStringCellValue(),
					r.getCell(5).getStringCellValue(),
					r.getCell(6).getStringCellValue(),
					r.getCell(7).getStringCellValue(),
					r.getCell(8).getStringCellValue(),
					r.getCell(9).getStringCellValue()
					
					
					                  ));
			
		}
		book.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return client;
	}
	
	

}

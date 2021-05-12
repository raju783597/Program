package com.in.indium.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in.indium.model.PersionDetail;
import com.in.indium.repo.PersionDetailRepo;


@Component
public class PersionExcelUtil {
	@Autowired
	private PersionDetailRepo repo;
	
	public void readFromExce() throws InvalidFormatException, IOException{
		
		List<PersionDetail> prs=null;
	
		
			//read excel file
			File file=new File("D:\\ParsonDetail.xlsx");
			Workbook book=new XSSFWorkbook(file);
			//read sheet
			Sheet s=book.getSheet("Parson-Detail");
			//read row
			Iterator<Row> itr=s.iterator();
			
			for(Row row:s) {
				Integer i=(int) row.getCell(0).getNumericCellValue();	
				String n=row.getCell(1).getStringCellValue();	
				String g=row.getCell(2).getStringCellValue();	
				String pl=row.getCell(3).getStringCellValue();	
				String dl=row.getCell(4).getStringCellValue();	
				Integer f=(int) row.getCell(5).getNumericCellValue();	
				String ride=row.getCell(6).getStringCellValue();
				
				PersionDetail p=new PersionDetail();
				p.setName(n);
				p.setGender(g);
				p.setPickupLocation(pl);
				p.setDropLocation(dl);
				p.setFare(f);
				p.setRideType(ride);
				
				repo.save(p);
				System.out.println(">>>>>>>"+row.getCell(0).getNumericCellValue());
				}

			
			//close
			book.close();
	
	}

}

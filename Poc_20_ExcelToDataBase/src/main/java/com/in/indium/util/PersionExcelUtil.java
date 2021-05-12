package com.in.indium.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.in.indium.model.PersionDetail;



@Component
public class PersionExcelUtil {
	public List<PersionDetail>readFromExce(){
		String excelFile=".\\data\\ParsonDetail.Xlsx";
		
		List<PersionDetail> prs=null;
		try {
			prs=new ArrayList<>();
			//read excel file
			File file=new File("ecxelFile");
			Workbook book=new XSSFWorkbook(file);
			//read sheet
			Sheet s=book.getSheet("Parson-Detail");
			//read row
			Iterator<Row> itr=s.iterator();
			while(itr.hasNext()) {
				Row r=itr.next();
				//read data from one row>>>persion obj
				if(r.getRowNum()==0)
					continue;
				prs.add(new PersionDetail(
					   (int)  r.getCell(0).getNumericCellValue(),
					      r.getCell(1).getStringCellValue(),
					      r.getCell(2).getStringCellValue(),
					      r.getCell(3).getStringCellValue(),
					      r.getCell(4).getStringCellValue(),
					    (int)	r.getCell(5).getNumericCellValue(),
				         r.getCell(6).getStringCellValue()
				         )
				
						);
				
			}
			//close
			book.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(">>>>>>>>>>"+prs);
		return prs;
		
	}

}

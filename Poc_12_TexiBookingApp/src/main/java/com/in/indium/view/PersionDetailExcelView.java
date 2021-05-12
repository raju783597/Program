package com.in.indium.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.in.indium.model.PersionDetail;

public class PersionDetailExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			                                  Workbook workbook, 
			                                   HttpServletRequest request,
		                                       	HttpServletResponse response
		                                       	) throws Exception {
		// TODO Auto-generated method stub
		response.addHeader("content-Disposition",
				            "attachment;filename=ParsonDetail.xlsx");
		//create sheet
		Sheet s=workbook.createSheet("Test");
	    //read data from controller
		@SuppressWarnings("unchecked")
		List<PersionDetail>list=(List<PersionDetail>) model.get("list");
	    Sheet sheet=workbook.createSheet("Persion-Detail");
	    setHead(sheet);
		setBody(sheet,list);
		
	}
    
	// row 0
	private void setHead(Sheet sheet) {
		// TODO Auto-generated method stub
		//create row
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("GENDER");
		row.createCell(3).setCellValue("PICKUP LOC");
		row.createCell(4).setCellValue("DROP LOC");
		row.createCell(5).setCellValue("VEHICEL");
		row.createCell(6).setCellValue("FARE");
		
	}

	private void setBody(Sheet sheet, List<PersionDetail> list) {
		// TODO Auto-generated method stub
		int rowNum=1;
		for(PersionDetail per:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(per.getId().toString());
			row.createCell(1).setCellValue(per.getName());
			row.createCell(2).setCellValue(per.getGender());
			row.createCell(3).setCellValue(per.getPickupLocation());
			row.createCell(4).setCellValue(per.getDropLocation());
			row.createCell(5).setCellValue(per.getRideType().toString());
			row.createCell(6).setCellValue(per.getFare().toString());
			
		}

	}

}

package com.in.indium.excel;

import java.io.FileInputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;

import com.in.indium.model.ClientUser;
@Component
public class ClientExcelImporter {
	Integer client;
	String name="";    String code=""; 
	String cliType=""; String accType="";
	String date="";    String iNameType="";
	String schName=""; String RegMgName="";
	String billGroup="";
	String share="";
	public List<ClientUser> excelImport(){

		List<ClientUser> list=new ArrayList<>();

		String excelFilePath="D:\\Client-Master.xls";		
		//long start = System.currentTimeMillis();

		FileInputStream inputStream;
		try {
			//take the file
			inputStream = new FileInputStream(excelFilePath);
			//create the workbook
			Workbook workbook=new HSSFWorkbook(inputStream);
			//create sheet
			Sheet firstSheet=workbook.getSheet("sheet1");
			//row iterator               is use for get object one by one
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
					}

					list.add(new ClientUser(client,
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

			workbook.close();

		} catch (Exception e) {
			

			e.printStackTrace();
		}

		return list;
	}

}

package com.in.indium.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.in.indium.model.Client;
import com.in.indium.model.Devloper;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfDate;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ClientPdfView extends AbstractPdfView {
	/*buildPdfMetadata is predefine  method in AbstractPdfView class
	 *  
	 * To add meta fields such as title, subject, author, creator, keywords
	*/
	@Override
	protected void buildPdfMetadata(Map<String, Object> model, 
		                           	Document document,
		  
		                           	HttpServletRequest request) {
		/*HeaderFooter(Phrase before, Phrase after) use for header and footer the page  file
		 * Phase is a class which is use for mention of title and font
		*/
		
		HeaderFooter header=new HeaderFooter(new Phrase("GENERATED BY RAJU KUMAR"), false);
		HeaderFooter footer=new HeaderFooter(new Phrase(new Date().toString() +  " | PAGE NUMBER#"), new Phrase("."));
	// Setting the alignment.
		header.setAlignment(1);
		//setting the boder in botom of page
		header.setBorder(Rectangle.BOTTOM);
	
		// Setting the alignment.
		footer.setAlignment(1);
		footer.setBorder(Rectangle.TOP);
		
		document.setHeader(header);
	    document.setFooter(footer);
	
	}
	
	
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			                               Document document, 
			                               PdfWriter writer,
		                          	HttpServletRequest request,
		                          	HttpServletResponse response) throws Exception {
	Image image=Image.getInstance(
			//get the image link
			new ClassPathResource("/static/images/indium.png").getURL()
			
			
			);
	image.setAlignment(Image.ALIGN_MIDDLE);
	//mention boder around image
	image.enableBorderSide(Rectangle.BOTTOM+Rectangle.TOP+Rectangle.LEFT+Rectangle.RIGHT);
	image.scaleAbsolute(200.f,50.0f);
	//add the image in pdf page	
	document.add(image);
		//download document name
		response.addHeader("Content-Disposition", "attachment;filename=Client-Role-Data.pdf");		
	//create element paragraph
		Font font=new Font(Font.HELVETICA,15,Font.BOLD,Color.BLUE);
	  
	  Paragraph p=new Paragraph("CLIENT DATA ",font);
	  p.setAlignment(Element.ALIGN_CENTER);
	  //add element to document
	  document.add(p);
	  //document.setMargins(1.0f, 1.0f, 1.0f, 1.0f);
		 @SuppressWarnings("unchecked")
		List<Client>list1=  (List<Client>) model.get("obj1");
		 PdfPTable table=new PdfPTable(4);//no. of table
		 table.setTotalWidth(new float[] {2.0f,4.0f, 3.0f, 4.0f});
		 table.addCell(new Phrase("C_ID",font) );
		 table.addCell(new Phrase("C_LOCATION",font));
		 table.addCell(new Phrase("C_NAME",font) );
		 table.addCell( new Phrase("CPRO_NAME",font));
		 
		 for(Client c:list1) {
			 table.addCell(c.getCid().toString());
			 table.addCell(c.getCLocation());
			 table.addCell(c.getCName());
			 table.addCell(c.getCprojName());
			
		 }
		 
		 document.add(table);
		 
		 
		  Paragraph p1=new Paragraph("ROLE DATA ",font);
		  p1.setAlignment(Element.ALIGN_CENTER);
	     document.add(p1);
	     //read the data from controller
	 @SuppressWarnings("unchecked")
	List<Devloper>list2=  (List<Devloper>) model.get("dev");
	 //create no. of column
	 PdfPTable tabledev=new PdfPTable(3);//no. of table
	 tabledev.setTotalWidth(new float[] {2.0f,3.0f, 3.0f});
	
	 
	// table.addCell("*...*");
	 tabledev.addCell(new Phrase("D_ID",font) );
	 tabledev.addCell(new Phrase("D_NAME",font) );
	 tabledev.addCell(new Phrase("D_ROLE",font) );

	 for(Devloper d:list2) {
		 tabledev.addCell(d.getDevid().toString());
		 tabledev.addCell(d.getDevName());
		 tabledev.addCell(d.getDevRole());
	 }
	 document.add(tabledev);
	 
	// document.add(new Phrase(new PdfDate().toString()));
	 
	}

}

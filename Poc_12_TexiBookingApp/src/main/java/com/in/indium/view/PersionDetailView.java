package com.in.indium.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.in.indium.model.PersionDetail;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class PersionDetailView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document,
			PdfWriter writer,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {



		//image insert
		Image image=Image.getInstance(
				new ClassPathResource("/static/images/indium.png")
				.getURL());
		
		image.setAlignment(Image.MIDDLE);
		image.scaleAbsolute(300.0f,80.0f);
		image.setBorder(2);
		image.setBorderWidth(2.0f);
		image.enableBorderSide(15);
		
		//add image
		document.add(image);
		
		//add header 
		HeaderFooter head=new HeaderFooter(new Phrase("PERSION_DETAIL_REPORT"),false);
		document.setHeader(head);

		//add footer
		HeaderFooter footer=new HeaderFooter(new Phrase("PAGE NUMBER#"),new Phrase("."));
		document.setFooter(footer);

		//download document in custom file name 
		response.addHeader("Content-Disposition","attachment;filename=PersionDetail.pdf");
		//create element

		head.setAlignment(1);
		head.setBorder(Rectangle.BOTTOM);

		footer.setAlignment(2);
		footer.setBorder(Rectangle.TOP);

		//provide custom font detail object
		Font font=new Font(Font.HELVETICA,20,Font.BOLD,new Color(222, 161,20));
		Paragraph p=new Paragraph("WELCOME TO PERSION DETAIL", font);
		p.setAlignment(Element.ALIGN_CENTER);
		//add element to document
		document.add(p);

		//read thr data
		@SuppressWarnings("unchecked")
		List<PersionDetail>list=(List<PersionDetail>) model.get("list");
		//create table
		PdfPTable table=new PdfPTable(7);//no. of coloumn
		//table.setHeaderRows(1);
		table.setSpacingBefore(4.0f);

		table.setTotalWidth(new float[] {1.0f,1.5f,2.0f,2.5f,2.5f,2.0f,2.0f});
		//add data to coloumn using addcell method
		
		// add 6 cell done then it will change row autometicaly 
		table.addCell("ID");
		table.addCell("NAME");
		table.addCell("GENDER");
		table.addCell("PICKUP LOC");
		table.addCell("DROP LOC");
		table.addCell("VEHICEL");
		table.addCell("FARE");

		//add list data to table
		for(PersionDetail per:list) {
			table.addCell(per.getId().toString());
			table.addCell(per.getName());
			table.addCell(per.getGender());
			table.addCell(per.getPickupLocation());
			table.addCell(per.getDropLocation());
			table.addCell(per.getRideType().toString());
			table.addCell(per.getFare().toString());
		}

		//add table to document
		document.add(table);
		document.add(new Phrase(new Date().toString()));

	}

}

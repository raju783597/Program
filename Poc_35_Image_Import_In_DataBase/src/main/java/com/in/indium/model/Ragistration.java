package com.in.indium.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@Table(name="ragister_tab_image")
public class Ragistration {
	@GeneratedValue
	@Id
	private Integer id;
	@NonNull
	private String name; 
	
	@NonNull
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@NonNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@NonNull
	@Lob//blob
	private byte[] img;
	
	@NonNull
	@Lob//clob
	private char[] resume;
	
	
	//private 
		
	

}

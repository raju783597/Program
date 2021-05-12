package com.in.indium.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="doc_type_tab")
@Data
public class Document {
	@Id
	private Integer docId;
	private String docName;
	@Lob //b
	private byte[] docData;
	

}

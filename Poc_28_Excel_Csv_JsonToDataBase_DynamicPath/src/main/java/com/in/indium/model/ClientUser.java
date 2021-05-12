package com.in.indium.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="User_dynamic_path_Tab_3")
public class ClientUser {
   
	@GeneratedValue//(strategy=GenerationType.AUTO) 	
	@Id
   	private long id;
     	
  @NonNull
	//@Column(name="CLIENT")
		private Integer client;
	
	// @Column(name="CLIENTNAME")
	@NonNull
		private String name;
	
	@NonNull
	// @Column(name="CLIENTCODE")
	private String cliCode;
		
	// @Column(name="CLIENTTYPE")
	@NonNull
		private String cliType;
	
	// @Column(name="ACCOUNTTYPE")
	@NonNull
		private String accType;
	@NonNull
	//@Column(name="ACCOUNT OPEN DATE")
		private String date;
	//@Column(name="INTERMEDIARYNAME")
	@NonNull
		private String iNameType;
	//@Column(name="SCHEMENAME")
	@NonNull
		private String schName;
//	@Column(name="RELMGRNAME")
	@NonNull
		private String RegMgName;
//	@Column(name="BILLGROUP")
	@NonNull
		private String billGroup;
	//@Column(name="% Share")
	@NonNull
		private String share;
	
	@Transient
	//@NotNull
	private MultipartFile filetype;
}

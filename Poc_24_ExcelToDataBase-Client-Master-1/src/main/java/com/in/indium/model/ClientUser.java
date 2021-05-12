package com.in.indium.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
//@AllArgsConstructor
@Entity
public class ClientUser {
	
	/*
	 * //@NonNull
	 * 
	 * @Id
	 * 
	 * @GeneratedValue private Integer id;
	 */
	@Id
	 @NonNull
		private Integer client;
	
	@NonNull
		private String name;
		
	@NonNull
		private String cliType;
	
	@NonNull
		private String accType;
	@NonNull
		private String date;
	@NonNull
		private String iNameType;
	@NonNull
		private String schName;
	@NonNull
		private String RegMgName;
	@NonNull
		private String billGroup;
	@NonNull
		private String share;
}

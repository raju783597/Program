package com.in.indium.model;






import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class ClientUser {

	//@Column(name="CLIENTID")
	 @NonNull
	 @Id
		private Integer client;
	
	// @Column(name="CLIENTNAME")
	@NonNull
		private String name;
	
	@NonNull
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
	//@Column(name="RELMGRNAME")
	@NonNull
		private String RegMgName;
	//@Column(name="BILLGROUP")
	@NonNull
		private String billGroup;
	//@Column(name="% Share")
	@NonNull
		private String share;
}

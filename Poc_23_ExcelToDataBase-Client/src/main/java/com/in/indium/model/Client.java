package com.in.indium.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="Client_Master_Tab")
public class Client {
	/*
	 * @GeneratedValue
	 * 
	 * @Column(name="sno")
	 * 
	 * @Id private Integer id;
	 */
 @NonNull
   @Column(name="client_code")
	private Integer client;
	
 @NonNull
   @Column(name="client_type")
	private String cliType;
 @NonNull
   @Column(name="account_type")
	private String accType;
 @NonNull
   @Column(name="account_open_date")
	private Date date;
 @NonNull
   @Column(name="inter_mediary_name")
	private String iNameType;
 @NonNull
   @Column(name="scheme_name")
	private String schName;
 @NonNull
   @Column(name="regnal_mng_name")
	private String RegMgName;
 @NonNull
   @Column(name="bill_group")
	private String billGroup;
 @NonNull
   @Column(name="%_shere")
	private String share;
	
	
	
}

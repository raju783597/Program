package com.in.indium.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="Client_Master_Tab")
@AllArgsConstructor
@NoArgsConstructor
public class Client {
   @Id
   @Column(name="client_code")
	private Integer id;
	
   @Column(name="client_type")
	private String cliType;
   @Column(name="account_type")
	private String accType;
   @Column(name="account_open_date")
	private Date date;
   @Column(name="inter_mediary_name")
	private String iNameType;
   @Column(name="scheme_name")
	private String schName;
   @Column(name="regnal_mng_name")
	private String RegMgName;
   @Column(name="bill_group")
	private String billGroup;
   @Column(name="%_shere")
	private String share;
	
	
	
}

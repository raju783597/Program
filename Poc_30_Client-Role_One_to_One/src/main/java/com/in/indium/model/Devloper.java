package com.in.indium.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dev_tab")
public class Devloper {
    @GeneratedValue
   @Id
	private Integer devid;
	private String devName;
	private String devRole;
	
}

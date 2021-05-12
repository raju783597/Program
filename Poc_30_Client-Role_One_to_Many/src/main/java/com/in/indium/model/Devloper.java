package com.in.indium.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="dev_tab_many")
@ToString
public class Devloper {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private Integer devid;
	private String devName;
	private String devRole;
	
}

package com.in.indium.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="emp_tab")
public class Employee {
	@GeneratedValue(generator = "emp_seq")
	@Id
	private Integer id;
	private String name;
	private String address;
	private String degignation;
	

}

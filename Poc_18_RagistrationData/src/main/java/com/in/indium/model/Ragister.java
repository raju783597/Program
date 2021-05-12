package com.in.indium.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="reg_tab")
public class Ragister {
@Id
@GeneratedValue
 private Integer id;
@Column(name="name_col")
 private String name;

@Column(name="last_name_col")
private String lastName;

@Column(name="gender_col")
private String gender;

@Column(name="phono_col")
private Double phoNo;

@Column(name="email_col")
 private String email;

@Column(name="dob_col")
 private String dob;

@Column(name="pass_col")
private String passward;

@Column(name="conf_pass_col")
private String conformPassward;
 
 
	
}

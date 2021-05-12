package com.in.indium.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="role_tab")
public class Role {
	@Id
	@GeneratedValue(generator = "rol_seq")
	private Integer id;
	@Column(name = "rname")
	private String name;
	@Column(name = "rtype")
	private String type;
	

}

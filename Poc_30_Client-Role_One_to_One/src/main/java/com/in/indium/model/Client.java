package com.in.indium.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="client_tab_1")
public class Client {
   
	@GeneratedValue
	@Id
	private Integer cid;
	private String cName;
	private String cprojName;
	private String cLocation;
	
//	@ManyToOne//1...1
	/*
	 * @JoinColumn(name="devidFK" ,unique = true )//optional
	 */
	//private Devloper dev;//child is collection type so we took list if child is many then we took collection type
}

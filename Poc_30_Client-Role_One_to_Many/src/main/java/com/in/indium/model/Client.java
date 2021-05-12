package com.in.indium.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name="client_tab_many")
@ToString
public class Client {
   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer cid;
	private String cName;
	private String cprojName;
	private String cLocation;
	
	//@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)//one to one
	
	@OneToMany(cascade = CascadeType.ALL)//one to one
	@JoinColumn(name="CIDFK" ,referencedColumnName ="cid")
     private List<Devloper> dev;
}

package com.in.indium.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data

@Table(name="client_tab_many_to_many")
@ToString
public class Client {
   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer cid;
	private String cName;
	private String cprojName;
	private String cLocation;
	
	//@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)//one to one
   //@OneToOne////default value is fetch = FetchType.eager
	//@ManyToOne
	
	//@Embedded
	
	  @ManyToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)//default value is fetch =  FetchType.LAZY
	  @JoinTable(name="client_role_join_tab", 
	             joinColumns = {@JoinColumn(name="client_tab_fk" ) },	                                                                       
	             inverseJoinColumns = { @JoinColumn(name= "role_tab_fk")})
	  
	  private List<Devloper> dev;
	  
	
}

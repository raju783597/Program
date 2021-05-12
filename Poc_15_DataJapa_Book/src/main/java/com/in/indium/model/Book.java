package com.in.indium.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Book {
@Id
	private Integer id;
	private String name;
	private Double cost;
	
	  @OneToMany 
	  @JoinColumn(name="bidfk") 
	  private List <Auther> auth;
	  
	 
}

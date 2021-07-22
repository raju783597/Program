package com.in.indium.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="dev_tab_many_to_many")
@ToString
public class Devloper {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private Integer devid;
	private String devName;
	private String devRole;
	
//	      @ManyToMany( cascade = CascadeType.ALL, 
//			           mappedBy ="dev")
//			           //  fetch = FetchType.EAGER)//if it is eager then it fach all data parents and child deta
	 @JsonIgnore
	 @ManyToMany( cascade = CascadeType.ALL, 
	             mappedBy ="dev",
	                fetch = FetchType.EAGER)
	private List<Client>client;
	 
	

	
}

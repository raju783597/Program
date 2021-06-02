package com.in.indium.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="User_profile_tab")
public class Profit {
	
	@GeneratedValue//(strategy=GenerationType.AUTO) 	
	@Id
	private Integer clientCode;
	
	private String strategyName;
	private String narration;
	private String date;
	private String balance;

}

package com.in.indium.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
//@Table
@AllArgsConstructor
@NoArgsConstructor
public class PanCard {
    @Id
   // @NonNull
	private Integer panId;
	private String panCardNumber;
	private String panHolderName;
	  @Temporal(TemporalType.DATE) 
	  private Date issueDate;
	 
	
	
}

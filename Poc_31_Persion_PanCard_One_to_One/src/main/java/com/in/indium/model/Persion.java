package com.in.indium.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persion {
	@Id
private Integer perid;
private String perName;
private String perGender;
private String perAdd;

  @ManyToOne
  @JoinColumn( name ="CARDIDFK", unique = true ) 
  private PanCard card;
 

}

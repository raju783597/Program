package com.in.indium.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="per_Detail_tab")
public class PersionDetail {
	@Id
	@GeneratedValue

	private Integer id;
	@Column(name ="name_col")
	private String name;
	
	@Column(name ="gender_col")
	private String gender;
	
	@Column(name ="picup_col")
	private String pickupLocation;
	
	@Column(name ="drop_col")
	private String dropLocation;
	
	@Column(name ="fare_col")
	private Integer fare;

	@Column(name ="vehical_type_col")
	@ElementCollection
	private List<String>rideType;
	
	

}

package com.in.indium.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="per_Detail_tab_Excel_Db")
@Entity
public class PersionDetail {
	
	@NonNull
	private Integer id;
	
	@NonNull
	@Column(name ="name_col")
	private String name;
	
	@NonNull
	@Column(name ="gender_col")
	private String gender;
	
	@NonNull
	@Column(name ="picup_col")
	private String pickupLocation;
	
	@NonNull
	@Column(name ="drop_col")
	private String dropLocation;
	
	@NonNull
	@Column(name ="fare_col")
	private Integer fare;

	@NonNull
	@Column(name ="vehical_type_col")
	//@ElementCollection
	//@ManyToOne
	//@JoinColumn(name="fk")
	private String rideType;

	

	
	}
	
	



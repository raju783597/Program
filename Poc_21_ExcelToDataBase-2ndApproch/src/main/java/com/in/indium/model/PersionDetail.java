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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="per_Detail_tab_Excel_Db_2")
public class PersionDetail {
	
	@Id
	@GeneratedValue
	@NonNull
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
	private String rideType;
	
	

}

package com.in.indium.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Employee {
	@Id
	@NonNull
	private Integer empid;
	private String name;
	private Double sal;
	
	@ManyToOne
	@JoinColumn(name="didfk")
	private Department  dep;
	

}

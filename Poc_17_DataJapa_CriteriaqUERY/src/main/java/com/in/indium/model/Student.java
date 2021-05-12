package com.in.indium.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Student {
	@Id
	private Integer stdId;
	private String stdName;
	private String stdCode;
	private String stdCourse;
	private String stdAdd;
	

}

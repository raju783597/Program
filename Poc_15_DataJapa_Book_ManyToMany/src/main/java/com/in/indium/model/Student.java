package com.in.indium.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
public class Student {	
	@Id
	//@NonNull
 private Integer stdid;
 private String name;
 private String add;
	
	  @JoinTable( name = "cid_sid_tab", 
	  joinColumns = @JoinColumn(name="cidfk"),
	  inverseJoinColumns =@JoinColumn(name="sidfk")
	  )
	  @ManyToMany
	  private List<Course> course;
	  //  private List<Optional<Course>> course;
	 
}

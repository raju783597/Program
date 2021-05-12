package com.in.indium.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.core.annotation.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Student {
	@Id
private Integer id;
private String name;
private String course;

@OneToMany
@JoinColumn(name="sidfk")
private List<Marks> marks;
}

package com.in.indium.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="user_tab")
public class User {
@Id	

@GeneratedValue(generator ="user_seq")
private int id;
@Column(name="uname_col")
private String userName;
@Column(name="udnation_col")
private String userDegigNation;

//private Role role;

}

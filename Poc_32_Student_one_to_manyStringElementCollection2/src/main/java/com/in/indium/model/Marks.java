package com.in.indium.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="marks_tab_2")
public class Marks {
   @Id
   @NonNull
	private Integer id;
	private Integer roleNo;
	private String name;
	@ElementCollection
	private List<String> subject;
}

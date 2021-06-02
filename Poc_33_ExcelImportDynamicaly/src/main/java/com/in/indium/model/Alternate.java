package com.in.indium.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name="User_Alternate")
public class Alternate {
	@GeneratedValue//(strategy=GenerationType.AUTO) 	
	@Id
   	private long id;
	
	 @NonNull
	  private String a;
	 @NonNull
	  private String b;
	 @NonNull
	  private String c;
	
	 @Transient
		//@NotNull
		private MultipartFile filetype;


}

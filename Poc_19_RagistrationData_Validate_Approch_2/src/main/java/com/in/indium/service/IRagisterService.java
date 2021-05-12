package com.in.indium.service;

import java.util.List;

import com.in.indium.model.Ragister;

public interface IRagisterService {
  //insert data in db
public Integer saveRagisterData(Ragister rag);

   public  List<Ragister>  getAllRagisterData();
  //fatch name and pwd 
 // public  List<Ragister> findByNameAndPwd(String name,Integer pwd);
  
	//public List<Ragister> findByNameAndPwd(String name,String pwd);
}

package com.in.indium.iservice;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.in.indium.model.Alternate;

public interface IAlternateService {
	//List<Alternate> findAll();

	boolean saveDataFromUploadFile(MultipartFile file);

}

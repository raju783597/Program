package com.in.indium.iservice;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.in.indium.model.ClientUser;

public interface IClientUserService {

	List<ClientUser> findAll();

	boolean saveDataFromUploadFile(MultipartFile file);
}

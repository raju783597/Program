package com.in.indium.service;

import java.util.List;

import com.in.indium.model.Devloper;

public interface DevService {

	Integer saveDev(Devloper dev);

	List<Devloper> getAllData();

	void remove(Integer id);

	boolean isDevExist(Integer id);

	void updateDta(Devloper div);

	
}

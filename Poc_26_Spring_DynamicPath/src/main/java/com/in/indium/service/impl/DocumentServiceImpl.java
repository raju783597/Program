package com.in.indium.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.indium.iservice.IDocumentService;
import com.in.indium.model.Document;
import com.in.indium.repo.DocumentReo;
@Service
public class DocumentServiceImpl implements IDocumentService {
 @Autowired
	private DocumentReo repo;
	
	@Override
	public void saveDocument(Document doc) {
		// TODO Auto-generated method stub
		repo.save(doc);

	}

}

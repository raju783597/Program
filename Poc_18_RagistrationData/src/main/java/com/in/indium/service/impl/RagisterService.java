package com.in.indium.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.indium.model.Ragister;
import com.in.indium.repo.RagisterRepo;
import com.in.indium.service.IRagisterService;
@Service
public class RagisterService implements IRagisterService {
@Autowired
 private RagisterRepo repo;
	
	@Override
	public Integer saveRagisterData(Ragister rag) {
	return	repo.save(rag).getId();
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ragister> getAllRagisterData() {
		// TODO Auto-generated method stub
	       List<Ragister> list=repo.findAll();
		
	return list;
		
		
		
	}

	
	/*
	 * @Override public List< Ragister> findByNameAndPwd(String name, String pwd) {
	 * // List<Ragister> list= repo.findByNameAndPassward(name, pwd);
	 * 
	 * return "";//list; }
	 */

	/*
	 * @Override public List<Ragister> findByNameAndPwd(String name, Integer pwd) {
	 * List<Ragister> list= repo.findByNameAndPassward(name, pwd); return list; }
	 */
	/*
	 * @Override public List<Ragister> findByNameAndPwd(String name,Integer pwd); {
	 * List<Ragister> list= repo.findByNameAndPassward(); return list; }
	 */

}

package com.in.indium.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.indium.model.User;
import com.in.indium.repo.IUserRepo;
import com.in.indium.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	//linking the object like has-a relation
	@Autowired
	private IUserRepo repo;
	
//non select opr. required @transitional=commit+rollback
	@Transactional
	@Override
	public Integer saveUser(User us) {
	Integer id=	repo.save(us).getId();
		return id;
	}

	@Transactional
	@Override
	public void updateUser(User us) {
		repo.save(us);		
	}

	@Transactional
	@Override
	public void deleteUser(Integer id) {
      repo.deleteById(id);		
	}

	/*
	 *  select opration not required commit or rollback so
	 * @transitional(read=true)
	 */
	/*optional is a class it has isPresent()
	 *  if id present then give {@true} else give {@false}
	*/
	@Transactional(readOnly = true)
	@Override
	public Optional<User> getOneUser(Integer id) {
	Optional<User>opt=	repo.findById(id);

		
		return opt;
	

	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUser() {
       List<User> list=repo.findAll();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExistUser(Integer id) {
        boolean exit=  repo.existsById(id);
		return exit;
	}

}

package com.in.indium.service;

import java.util.List;
import java.util.Optional;

import com.in.indium.model.User;

public interface IUserService {
      Integer  saveUser(User us);
       void  updateUser(User us);
      void  deleteUser(Integer id);
      Optional<User>  getOneUser(Integer id);
     
      List<User>  getAllUser();
      boolean isExistUser(Integer id);
} 

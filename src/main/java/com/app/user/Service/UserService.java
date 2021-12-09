package com.app.user.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.user.Model.User;
import com.app.user.Repository.UserRepository;

@Service
public class UserService {
	
  @Autowired
  UserRepository userrepository;
  
  public void adduser(User user) {
	  userrepository.save(user);
  }
  
//  public List<User> getalluserrecords(){
//	  return (List<User>) userrepository.findAll();
//  }
//  
//  public User getuserrecord(int id) {
//	  return userrepository.getById(id);
//  }
//  
//  public void deleteuserrecord(int id) {
//	  userrepository.deleteById(id);
//  }
}

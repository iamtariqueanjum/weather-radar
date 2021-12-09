package com.app.user.Repository;

import org.springframework.data.repository.CrudRepository;

import com.app.user.Model.User;

public interface UserRepository extends CrudRepository<User,Integer>{

}

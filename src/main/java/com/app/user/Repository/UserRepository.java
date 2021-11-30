package com.app.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.user.Model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}

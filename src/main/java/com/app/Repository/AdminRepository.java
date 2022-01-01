package com.app.Repository;

import com.app.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    List<Admin> findByUsernameAndPassword(String username, String password);

}

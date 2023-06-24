package com.cybersoft.demosrpingboot.repository;

import com.cybersoft.demosrpingboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>{
    Users findUsersByEmailAndPassword(String email, String password);

    Users findByEmail(String email);
}

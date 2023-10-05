package com.cybersoft.demosrpingboot.repository;

import com.cybersoft.demosrpingboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String>{
    Users findUsersByEmailAndPassword(String email, String password);
    Optional<Users> findByEmail(String email);

    Users findByUsername(String userName);
}

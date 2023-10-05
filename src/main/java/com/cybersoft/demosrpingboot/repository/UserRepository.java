package com.cybersoft.demosrpingboot.repository;

import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, String>{
    Users findUsersByEmailAndPassword(String email, String password);
    Optional<Users> findByEmail(String email);

    Users findByUsername(String userName);
}

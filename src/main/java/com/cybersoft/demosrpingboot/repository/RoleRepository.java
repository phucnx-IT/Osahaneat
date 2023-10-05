package com.cybersoft.demosrpingboot.repository;

import com.cybersoft.demosrpingboot.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Roles, String> {
    Roles findByRoleName(String roleName);
}

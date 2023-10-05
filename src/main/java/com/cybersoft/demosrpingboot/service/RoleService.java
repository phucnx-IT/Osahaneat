package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.entity.Roles;
import com.cybersoft.demosrpingboot.mapping.RoleMapper;
import com.cybersoft.demosrpingboot.payload.RegisterRole;
import com.cybersoft.demosrpingboot.repository.RoleRepository;
import com.cybersoft.demosrpingboot.service.imp.RoleServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService implements RoleServiceImp {
    private final RoleRepository roleRepository;

    @Override
    public void createNewRole(RegisterRole role) {
        Roles roles = RoleMapper.INSTANCE.roleRegisterToRoles(role);
        roleRepository.save(roles);
    }

    @Override
    public RegisterRole findRoleByName(String roleName) {
        Roles roles = roleRepository.findByRoleName(roleName);
        return RoleMapper.INSTANCE.roleToRoleRegister(roles);
    }
}

package com.cybersoft.demosrpingboot.service.imp;

import com.cybersoft.demosrpingboot.payload.RegisterRole;

public interface RoleServiceImp {
    void createNewRole(RegisterRole role);

    RegisterRole findRoleByName(String roleName);
}

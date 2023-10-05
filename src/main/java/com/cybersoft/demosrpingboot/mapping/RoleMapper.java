package com.cybersoft.demosrpingboot.mapping;

import com.cybersoft.demosrpingboot.entity.Roles;
import com.cybersoft.demosrpingboot.payload.RegisterRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RoleMapper{
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
    Roles roleRegisterToRoles(RegisterRole roleDto);

    RegisterRole roleToRoleRegister(Roles roles);
}

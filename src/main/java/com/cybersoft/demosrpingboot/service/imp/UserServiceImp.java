package com.cybersoft.demosrpingboot.service.imp;

import com.cybersoft.demosrpingboot.dto.UserDto;

import java.util.List;

public interface UserServiceImp {
    List<UserDto> getAllUsers();


    UserDto addRoleToUser(String userName, String roleName);

    UserDto findUserByName(String name);
}

package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.entity.Users;
import com.cybersoft.demosrpingboot.mapping.UserMapper;
import com.cybersoft.demosrpingboot.repository.UserRepository;
import com.cybersoft.demosrpingboot.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDto> getAllUsers() {
        List<Users> usersList = userRepository.findAll();
        if (usersList.size() > 0) {
            return usersList.stream().map(users -> UserMapper.INSTANCE.userToUserDTO(users)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}

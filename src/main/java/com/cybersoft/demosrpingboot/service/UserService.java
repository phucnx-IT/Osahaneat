package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.entity.Roles;
import com.cybersoft.demosrpingboot.entity.Users;
import com.cybersoft.demosrpingboot.mapping.UserMapper;
import com.cybersoft.demosrpingboot.repository.RoleRepository;
import com.cybersoft.demosrpingboot.repository.UserRepository;
import com.cybersoft.demosrpingboot.service.imp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Optionals;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceImp {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public List<UserDto> getAllUsers() {
        List<Users> usersList = userRepository.findAll();
        if (usersList.size() > 0) {
            return usersList.stream().map(users -> UserMapper.INSTANCE.userToUserDTO(users)).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public UserDto addRoleToUser(String userName, String roleName) {
        Users user = userRepository.findByUsername(userName);
        Roles role = roleRepository.findByRoleName(roleName);
        if (Optionals.isAnyPresent(Optional.of(user)) && Optionals.isAnyPresent(Optional.of(role))){
            user.setRoleToUser(role);
            userRepository.save(user);
            return UserMapper.INSTANCE.userToUserDTO(user);
        }
        return null;
    }

    @Override
    public UserDto findUserByName(String name) {
        Users users = userRepository.findByUsername(name);
        return UserMapper.INSTANCE.userToUserDTO(users);
    }
}

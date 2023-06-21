package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.entity.Users;
import com.cybersoft.demosrpingboot.mapping.UserMapper;
import com.cybersoft.demosrpingboot.payload.PayloadRequest;
import com.cybersoft.demosrpingboot.repository.UserRepository;
import com.cybersoft.demosrpingboot.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto checkLogin(String username, String password) {
        Optional<Users> user = Optional.ofNullable(userRepository.findUsersByUsernameAndPassword(username, password));
        if (user.isPresent()){
            return UserMapper.INSTANCE.userToUserDTO(user.get());
        }
        return null;
    }

    @Override
    public Boolean checkSignup(PayloadRequest payloadRequest) {
        Users user = UserMapper.INSTANCE.payloadRequestToUsers(payloadRequest);
        try {
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.entity.Users;
import com.cybersoft.demosrpingboot.mapping.UserMapper;
import com.cybersoft.demosrpingboot.payload.PayloadRequest;
import com.cybersoft.demosrpingboot.repository.UserRepository;
import com.cybersoft.demosrpingboot.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto checkLogin(String email, String password) {
        Optional<Users> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())){
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

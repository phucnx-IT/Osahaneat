package com.cybersoft.demosrpingboot.common.configure.security;

import com.cybersoft.demosrpingboot.entity.Users;
import com.cybersoft.demosrpingboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = Optional.of(userRepository.findByEmail(email)).orElseThrow(
                () -> new UsernameNotFoundException("Email is not found")
        );
        return new User(email,user.getPassword(),new ArrayList<>());
    }
}

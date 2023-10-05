package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.common.configure.jwt.JwtUltilites;
import com.cybersoft.demosrpingboot.dto.AuthenticationResponse;
import com.cybersoft.demosrpingboot.entity.Users;
import com.cybersoft.demosrpingboot.mapping.UserMapper;
import com.cybersoft.demosrpingboot.payload.AuthenticationRequest;
import com.cybersoft.demosrpingboot.payload.RegisterRequest;
import com.cybersoft.demosrpingboot.repository.UserRepository;
import com.cybersoft.demosrpingboot.service.imp.AuthenticationImp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationImp {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUltilites jwtUltilites;

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        Users user = UserMapper.INSTANCE.payloadRequestToUsers(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return AuthenticationResponse.builder().token("Created new account").build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userDetailsService.loadUserByUsername(request.getEmail());
        var role = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        var jwtToken = jwtUltilites.generateTokens(Map.of("Role", role), (Users) user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}

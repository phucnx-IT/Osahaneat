package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.payload.AuthenticationRequest;
import com.cybersoft.demosrpingboot.payload.RegisterRequest;
import com.cybersoft.demosrpingboot.repository.UserRepository;
import com.cybersoft.demosrpingboot.service.AuthenticationService;
import com.cybersoft.demosrpingboot.service.UserService;
import com.cybersoft.demosrpingboot.service.imp.UserServiceImp;
import io.jsonwebtoken.lang.Strings;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final UserServiceImp userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
    return ResponseHelper.getResponse(authenticationService.register(request), HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseHelper.getResponse(authenticationService.authenticate(request), HttpStatus.OK);
    }

    @PutMapping("/addroletouser/{role}/{username}")
    public ResponseEntity<?> addRoleToUser(@PathVariable("role") String role, @PathVariable("username") String username){
        if(Strings.hasText(role) && Strings.hasText(username)){
            UserDto userDto = userService.addRoleToUser(username, role);
            return ResponseHelper.getResponse(userDto, HttpStatus.OK);
        }
        return ResponseHelper.getError("Missing role or username", HttpStatus.BAD_REQUEST);
    }
}

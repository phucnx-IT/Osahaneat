package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.payload.PayloadRequest;
import com.cybersoft.demosrpingboot.service.imp.LoginServiceImp;
import com.cybersoft.demosrpingboot.common.configure.jwt.JwtUltilites;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@CrossOrigin("http://127.0.0.1:5500")
@RestController()
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceImp loginServiceImp;
    @Autowired
    private JwtUltilites jwtUltilites;

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
        UserDto userDto = loginServiceImp.checkLogin(email,password);
        if (Objects.nonNull(userDto)) {
            String jwt = jwtUltilites.generateTokens(email);
            return ResponseHelper.getResponse(jwt,HttpStatus.OK);
        }else {
            return ResponseHelper.getResponse("Username or password is incorrect", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody PayloadRequest payloadRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseHelper.getError(bindingResult, HttpStatus.BAD_REQUEST);
        }
        if (loginServiceImp.checkSignup(payloadRequest)){
            return ResponseHelper.getResponse("Created", HttpStatus.CREATED);
        }
        return ResponseHelper.getResponse("Username has created",HttpStatus.BAD_REQUEST);
    }
}

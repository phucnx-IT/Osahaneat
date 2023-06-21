package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.payload.PayloadRequest;
import com.cybersoft.demosrpingboot.service.imp.LoginServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController()
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginServiceImp loginServiceImp;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){
        UserDto userDto = loginServiceImp.checkLogin(username,password);
        if (Objects.nonNull(userDto)) {
            return ResponseHelper.getResponse(userDto,HttpStatus.OK);
        }else {
            return ResponseHelper.getResponse("Username or password is incorrect", HttpStatus.NOT_FOUND);
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

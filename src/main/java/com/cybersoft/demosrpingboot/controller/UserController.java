package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @GetMapping()
    public ResponseEntity<?> getAllUsers(){
        List<UserDto> userDtoList = userServiceImp.getAllUsers();
        if (userDtoList.size() > 0) {
            return ResponseHelper.getResponse(userDtoList, HttpStatus.OK);
        }else {
            return ResponseHelper.getError("There are no user", HttpStatus.NO_CONTENT);
        }
    }
}

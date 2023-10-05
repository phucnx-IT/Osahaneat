package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.service.imp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImp userServiceImp;

    @GetMapping()
    public ResponseEntity<?> getAllUsers() {
        List<UserDto> userDtoList = userServiceImp.getAllUsers();
        if (userDtoList.size() > 0) {
            return ResponseHelper.getResponse(userDtoList, HttpStatus.OK);
        } else {
            return ResponseHelper.getError("There are no user", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findUserByName(@PathVariable String name){
        UserDto userDto = userServiceImp.findUserByName(name);
        if(Optionals.isAnyPresent(Optional.of(userDto))){
            return ResponseHelper.getResponse(userDto, HttpStatus.OK);
        }
        return ResponseHelper.getError("Can not find any user has name" + name, HttpStatus.BAD_REQUEST);
    }

}

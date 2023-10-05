package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.payload.RegisterRole;
import com.cybersoft.demosrpingboot.service.imp.RoleServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleServiceImp roleServiceImp;

    @PostMapping("/create")
    public ResponseEntity<?> createNewRole(@Valid @RequestBody RegisterRole registerRole, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return  ResponseHelper.getError(bindingResult, HttpStatus.BAD_REQUEST);
        }else {
            roleServiceImp.createNewRole(registerRole);
            return  ResponseHelper.getResponse("Create new role", HttpStatus.CREATED);
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> getRoleByName(@PathVariable("name") String name){
        RegisterRole registerRole = roleServiceImp.findRoleByName(name);
        if(Optionals.isAnyPresent(Optional.of(registerRole))){
            return ResponseHelper.getResponse(registerRole, HttpStatus.OK);
        }
        return ResponseHelper.getError("Can not find any role" + name, HttpStatus.BAD_REQUEST);
    }
}

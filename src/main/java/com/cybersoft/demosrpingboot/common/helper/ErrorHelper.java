package com.cybersoft.demosrpingboot.common.helper;

import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

public class ErrorHelper {
    public static List<String> getAllErrors(BindingResult bindingResult){
       return bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
    }
}

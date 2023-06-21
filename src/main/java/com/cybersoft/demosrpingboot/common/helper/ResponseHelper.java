package com.cybersoft.demosrpingboot.common.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHelper {
    public static ResponseEntity<Object> getResponse(Object obj, HttpStatus status){
        Map<String,Object> map = new HashMap<>();
        map.put("hasErros",false);
        map.put("content",obj);
        map.put("error", "");
        map.put("timeStamp", LocalDateTime.now());
        map.put("status", status);
        return new ResponseEntity<>(map,status);
    }
    public static ResponseEntity<Object> getResponse(String message, HttpStatus status){
        Map<String,Object> map = new HashMap<>();
        map.put("hasErros",false);
        map.put("content",message);
        map.put("error", "");
        map.put("timeStamp", LocalDateTime.now());
        map.put("status", status);
        return new ResponseEntity<>(map,status);
    }

    public static ResponseEntity<Object> getError(BindingResult bindingResult, HttpStatus status){
        Map<String,Object> map = new HashMap<>();
        map.put("hasErros",true);
        map.put("content",ErrorHelper.getAllErrors(bindingResult));
        map.put("error", "");
        map.put("timeStamp", LocalDateTime.now());
        map.put("status", status);
        return new ResponseEntity<>(map,status);
    }

    public static ResponseEntity<Object> getError(String message, HttpStatus status){
        Map<String,Object> map = new HashMap<>();
        map.put("hasErros",true);
        map.put("content",message);
        map.put("error", "");
        map.put("timeStamp", LocalDateTime.now());
        map.put("status", status);
        return new ResponseEntity<>(map,status);
    }
}

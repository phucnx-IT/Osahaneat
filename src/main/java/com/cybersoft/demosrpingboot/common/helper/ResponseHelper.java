package com.cybersoft.demosrpingboot.common.helper;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseHelper {

    public static ResponseEntity<Object> getResponse( Object obj, HttpStatus status){
        Map<String, Object> map = getObjectMap(false, obj, status);
        return new ResponseEntity<>(map,status);
    }
    public static  ResponseEntity<Object> getResponse( String message, HttpStatus status){
        Map<String, Object> map = getObjectMap(false, message, status);
        return new ResponseEntity<>(map,status);
    }

    public static ResponseEntity<Object> getError( BindingResult bindingResult, HttpStatus status){
        Map<String, Object> map = getObjectMap(true, bindingResult, status);
        return new ResponseEntity<>(map,status);
    }

    public static ResponseEntity<Object> getError(String message, HttpStatus status){
        Map<String, Object> map = getObjectMap(true, message, status);
        return new ResponseEntity<>(map,status);
    }

    private static Map<String, Object> getObjectMap(boolean value, Object object, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("hasErros", value);
        map.put("content", object);
        map.put("error", "");
        map.put("timeStamp", LocalDateTime.now());
        map.put("status", status);
        return map;
    }
}

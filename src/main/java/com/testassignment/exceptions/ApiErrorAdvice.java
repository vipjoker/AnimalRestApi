package com.testassignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiErrorAdvice {

    @ResponseBody
    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Map<String,String > exceptionHandler(ApiException exception){
        Map<String, String> map = new HashMap<>();
        map.put("Message", exception.getMessage());
        return map;
    }

}
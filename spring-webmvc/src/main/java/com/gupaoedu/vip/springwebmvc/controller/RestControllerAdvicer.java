package com.gupaoedu.vip.springwebmvc.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class RestControllerAdvicer {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Object pageNotFound( Throwable t){
        Map<String ,Object> data = new HashMap<>();
        data.put("message",t.getMessage());
        return data;
    }

}

package com.gupao.vip.springwebmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestControllerAdvicer {

    @ExceptionHandler(NoHandlerFoundException.class)
    public Object pageNotFound(HttpStatus status,
                               HttpServletRequest request,Throwable throwable){

        Map<String,Object> errors = new HashMap<>();
        errors.put("statusCode",request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestUri",request.getAttribute("javax.servlet.error.request_uri"));
        return errors;

    }

    @ExceptionHandler(NullPointerException.class)
    public Object handleNPE(Throwable throwable){
        return throwable.getMessage();
    }

}

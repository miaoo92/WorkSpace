package com.imooc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/9/10
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language")String acceptLanguage){
        return acceptLanguage;
    }

    @ModelAttribute("jsessiodId")
    public String message( @CookieValue(value = "JSESSIONID" ,required = false) String jsessiodId){
        return jsessiodId;
    }

    @ModelAttribute("message")
    public String message(){
        return "Hello,xiaomage";
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable){
        return ResponseEntity.ok(throwable.getMessage());
    }
}

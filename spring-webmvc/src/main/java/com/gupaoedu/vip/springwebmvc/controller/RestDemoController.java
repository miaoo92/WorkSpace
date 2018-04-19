package com.gupaoedu.vip.springwebmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestDemoController {

    @GetMapping("/index")
    public String index(){
        return "hello world;";
    }

    @GetMapping("/npe")
    public String getNpe(){
       throw new NullPointerException("故意抛异常");
    }

    @RequestMapping("/data")
    public Map<String ,Object> data(){
        Map<String ,Object> data = new HashMap<>();
        data.put("name","xiaomage");
        data.put("password","123");
        return data;
    }

    /**
     * 处理页面找不到的情况
     * @param httpStatus
     * @param request
     * @param t
     * @return
     */
    @GetMapping("/404.html")
    public Object pageNotFound(HttpStatus httpStatus, HttpServletRequest request , Throwable t){

        Map<String ,Object> errors = new HashMap<String ,Object>();
        errors.put("statusCode",request.getAttribute("javax.servlet.error.status_code"));  //javax.servlet.error.status_code参见servlet标准
        errors.put("requestUri",request.getAttribute("javax.servlet.error.request_uri"));
        errors.put("message",request.getAttribute("javax.servlet.error.message"));

        return errors;
    }

}

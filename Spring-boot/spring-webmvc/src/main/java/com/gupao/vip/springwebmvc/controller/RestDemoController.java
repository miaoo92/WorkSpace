package com.gupao.vip.springwebmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestDemoController {

    @GetMapping("/index")
    public String index(){
        return "Hello World";
    }

    /**
     * 处理页面找不到的逻辑
     * @param status
     * @param request
     * @param throwable
     * @return
     */
    @GetMapping("/404.html")
    public Object handlePageNotFound(HttpStatus status,
                                     HttpServletRequest request, Throwable throwable){

        Map<String,Object> errors = new HashMap<>();
        errors.put("statusCode",request.getAttribute("javax.servlet.error.status_code"));
        errors.put("requestUri",request.getAttribute("javax.servlet.error.request_uri"));
        return errors;

    }

    @GetMapping("/npe")
    public String npe(){
        throw new NullPointerException("故意抛异常");
    }

}

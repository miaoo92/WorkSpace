package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloWorldController{@link Controller}
 *
 * @author miaoo
 * @since 2018/9/12
 */
@Controller
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello-World";
    }

    @ModelAttribute("message")
    public String message(){
        return "Hello,xiaomage";
    }

    @RequestMapping("/")
    public String index(@RequestParam(defaultValue = "11", required = false) int value){
        return "index";
    }


}

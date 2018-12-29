package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/9/6
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String index(@RequestParam int value){
        return "index";
    }

}

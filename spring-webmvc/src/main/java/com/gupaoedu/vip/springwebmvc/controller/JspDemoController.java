package com.gupaoedu.vip.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspDemoController {

    @RequestMapping("/index1")
    public String index(Model model){
        model.addAttribute("message","miaomiaomiao???");
        return "jspIndex";

    }
}

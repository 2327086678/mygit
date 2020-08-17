package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/fail")
    //@ResponseBody
    public String fail(){
        return "login";
    }


    @RequestMapping("/success")
    public String succes(){
        return "home";
    }
}

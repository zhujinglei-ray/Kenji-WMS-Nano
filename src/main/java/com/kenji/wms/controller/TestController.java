package com.kenji.wms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/404")
    public String errorPage(){
        return "404";
    }

    @RequestMapping("/login")
    public String loginTest(){
        return "login";
    }

    @RequestMapping("/tables")
    public String loginTable(){
        return "tables";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}

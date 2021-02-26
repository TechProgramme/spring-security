package com.springsecurity.demospringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("myController")
public class MyController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello world";
    }
}

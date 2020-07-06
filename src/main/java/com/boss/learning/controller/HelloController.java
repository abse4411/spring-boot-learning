package com.boss.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
    @GetMapping("sayHello")
    public String sayHello(){
        String str = "Hello world!" + new Date();
        return str;
    }
}

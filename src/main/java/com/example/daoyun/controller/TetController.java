package com.example.daoyun.controller;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TetController {

    @RequestMapping("test")
    public String test(){
        return "hello";
    }
}

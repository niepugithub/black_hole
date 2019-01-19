package com.example.skill.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 16:28
 **/
@RestController
public class HelloController {

    @RequestMapping("/index")
    public String hello(){
        return "hello,springboot";
    }
}

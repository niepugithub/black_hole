package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制登录注册页面跳转流程控制器
 *
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/12 15:36
 **/
@Controller
public class LoginController {

    @RequestMapping("/test/thymeleaf_test")
    public String index(Model model) {
        model.addAttribute("name","hello,world");
        //注意是否/问题，看看前缀是如果/templates/有没有加前缀，要对应
        return "test/thymeleaf_test";
    }
}

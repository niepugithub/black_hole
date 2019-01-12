package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 为了让页面进行展示，就不用rest了，否则put和delete方法弄起来麻烦
 *
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/12 17:23
 **/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/list")
    public String getUsers(Model model) {
        List<User> userList = userService.queryUsers(null);
        model.addAttribute("userList", userList);
        return "/user/user_list";
    }

    @RequestMapping(value = "/user/del/{userId}")
    public String deleteByPrimaryKey(@PathVariable("userId") long userId) {
        userService.deleteByPrimaryKey(userId);
        return "redirect:/user/list";
    }

}

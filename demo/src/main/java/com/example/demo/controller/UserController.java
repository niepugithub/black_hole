package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 用户的crud控制器
 * @author:niepu
 * @version:1.0
 * @date:2019/1/10 22:15
 **/
@RestController
@RequestMapping("/demo")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public int insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers(User user) {
        return userService.queryUsers(user);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable("id") long id){
        return userService.deleteByPrimaryKey(id);
    }
}

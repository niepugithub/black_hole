package com.example.skill.controller;

import com.example.skill.domain.User;
import com.example.skill.service.UserService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 16:49
 **/
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user")
    public List<User> getAllUsers(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex,
                                  @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<User> users = userService.getAllUsers();
        return users;
    }

    @PostMapping("/user")
    public String insertUser(@RequestBody User user) {
        log.info(user.toString());
        return userService.insertUser(user) == 1 ? "success" : "fail";
    }

    @DeleteMapping("/user/{id}")
    public int deleteUserById(@PathVariable("id") long id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("/user")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}

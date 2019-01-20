package com.example.skill.controller;

import com.example.skill.common.aop.param.ParamLog;
import com.example.skill.common.result.AjaxResult;
import com.example.skill.common.result.CodeMsg;
import com.example.skill.domain.User;
import com.example.skill.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @ParamLog
    @GetMapping("/user/{id}")
    public AjaxResult getUserById(@PathVariable("id") long id) {
        User user = userService.getUserById(id);
        return AjaxResult.SUCCESS(user);
    }

    @ParamLog
    @GetMapping("/user")
    public AjaxResult getAllUsers(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex,
                                  @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<User> users = userService.getAllUsers();
        //使用pageInfo包装查询后的结果，封装了详细的查询数据，其中参数5,（users后面可以再加个参数）是页码导航连续显示的页数
        PageInfo pageInfo = new PageInfo(users);
        return AjaxResult.SUCCESS(users, pageInfo.getTotal());
    }

    @ParamLog
    @PostMapping("/user")
    public AjaxResult insertUser(@RequestBody User user) {
        return userService.insertUser(user) == 1 ? AjaxResult.SUCCESS() : AjaxResult.ERROR(CodeMsg.INSERT_USER_FAIL);
    }

    @ParamLog
    @DeleteMapping("/user/{id}")
    public AjaxResult deleteUserById(@PathVariable("id") long id) {
        return userService.deleteUserById(id) == 1 ? AjaxResult.SUCCESS() : AjaxResult.ERROR(CodeMsg.DELETE_USER_FAIL);
    }

    @ParamLog
    @PutMapping("/user")
    public AjaxResult updateUser(@RequestBody User user) {
        return userService.updateUser(user) == 1 ? AjaxResult.SUCCESS() : AjaxResult.ERROR(CodeMsg.UPDATE_USER_FAIL);
    }
}

package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/10 23:20
 **/
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User selectByPrimaryKey(long id) {
        return userMapper.selectByPrimaryKey(id);
    }


}

package com.example.skill.service;

import com.example.skill.dao.UserMapper;
import com.example.skill.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 16:49
 **/
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User getUserById(long id) {
        return userMapper.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Transactional
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteUserById(long id) {
        return userMapper.deleteUserById(id);
    }
}

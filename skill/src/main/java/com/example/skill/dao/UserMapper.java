package com.example.skill.dao;

import com.example.skill.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 16:38
 **/
@Mapper
public interface UserMapper {

    List<User> getAllUsers();

    User getUserById(long id);

    Integer deleteUserById(long id);

    Integer updateUser(User user);

    Integer insertUser(User user);
}

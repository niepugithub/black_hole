package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserExample;
import com.example.demo.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    @Autowired
    private UserService userService;

    public User selectByPrimaryKey(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Transactional
    public List<User> queryUsers(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user!=null){
            // 暂时没找到好的方法，只能死拼凑查询条件
            if (StringUtils.isNotBlank(user.getAddress())) {
                // 注意模糊查询的百分号问题
                criteria.andAddressLike("%" + user.getAddress() + "%");
            }
            if (null != (user.getBirth())) {
                criteria.andBirthEqualTo(user.getBirth());
            }
            if (null != user.getId()) {
                criteria.andIdEqualTo(user.getId());
            }
            if (StringUtils.isNotBlank(user.getPhone())) {
                criteria.andPhoneLike("%" + user.getPhone() + "%");
            }
            if (StringUtils.isNotBlank(user.getUsername())) {
                criteria.andUsernameLike("%" + user.getUsername() + "%");
            }
        }
        List<User> users = userMapper.selectByExample(example);
        return users;
    }

    @Transactional
    public int deleteByPrimaryKey(long id){
        return userMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public int updateByPrimaryKeySelective(User user){
        User u = userService.selectByPrimaryKey(user.getId());
        if (u.getUsername().equals("postman")) {
            // 休息一分钟，先获取满足修改条件，然后让其他事务修改，让条件不满足
            // 看看这个事务是否还能否执行成功
            // 在这里真是见鬼了，陷入死循环了，不知道是个什么诡异的问题
            System.out.println("进入条件");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("u.getUsername===="+u.getUsername());
            return userService.updateByPrimaryKeySelective(user);
        }
        return -1;
    }
}

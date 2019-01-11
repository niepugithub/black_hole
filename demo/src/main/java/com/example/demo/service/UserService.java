package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserExample;
import com.example.demo.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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

    public User selectByPrimaryKey(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public List<User> queryUsers(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
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
        List<User> users = userMapper.selectByExample(example);
        return users;
    }
}

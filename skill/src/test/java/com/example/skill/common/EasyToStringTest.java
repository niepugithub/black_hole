package com.example.skill.common;

import com.example.skill.domain.User;
import org.junit.Test;

import java.util.Date;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 21:25
 **/
public class EasyToStringTest {

    @Test
    public void test1() {
        User u = new User();
        u.setUsername("张三");
        u.setAddress("杭州");
        u.setBirth(new Date());
        u.setPhone("12345");
        u.setId(1L);
        System.out.println(u);
    }
}

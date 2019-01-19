package com.example.skill.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 16:33
 **/
@Setter
@Getter
public class User {
    private Long id;

    private String username;

    private String phone;

    private String address;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", locale = "zh")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                '}';
    }
}

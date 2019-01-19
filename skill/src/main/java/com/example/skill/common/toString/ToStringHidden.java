package com.example.skill.common.toString;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不想打印某某个字段，可以使用该注解隐藏
 *
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 21:19
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ToStringHidden {

}

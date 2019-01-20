package com.example.skill.common.aop.param;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/20 11:44
 **/
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamLog {
    // 是否打印参数
    boolean showParam() default true;
}

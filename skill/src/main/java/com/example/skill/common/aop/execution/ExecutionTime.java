package com.example.skill.common.aop.execution;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/20 15:20
 **/
public @interface ExecutionTime {
    boolean executionTime() default true;
}

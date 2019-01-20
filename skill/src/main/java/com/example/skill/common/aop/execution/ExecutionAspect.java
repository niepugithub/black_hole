package com.example.skill.common.aop.execution;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/20 15:20
 **/
@Aspect
@Component
@Slf4j
public class ExecutionAspect {

    // 配置织入点
    @Pointcut("@annotation(com.example.skill.common.aop.execution.ExecutionTime)")
    public void executionPointCut() {
    }

    @Around("executionPointCut()")
    public Object doAroundService(ProceedingJoinPoint pjp) throws Throwable {

        long begin = System.nanoTime();

        Object obj = pjp.proceed();

        long end = System.nanoTime();

        log.info("调用方法：{}，参数：{}，执行耗时：{}纳秒，耗时：{}毫秒",
                pjp.getSignature().toString(), Arrays.toString(pjp.getArgs()), (end - begin), (end - begin) / 1000000);

        return obj;
    }

}

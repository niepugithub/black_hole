package com.example.skill.common.aop.param;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 参数打印切面
 *
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/20 11:48
 **/
@Slf4j
@Component
@Aspect
public class ParamAspect {
    // 配置织入点
    @Pointcut("@annotation(com.example.skill.common.aop.param.ParamLog)")
    public void logPointCut() {
    }

    /**
     * 前置通知 用于拦截操作
     * AfterReturning增强处理可以访问到方法的返回值，但它不可以改变目标方法的返回值
     *
     * @param joinPoint 切点
     */
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        handleLog(joinPoint, null);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e) {
        try {
            // 获得注解
            ParamLog paramLog = getAnnotationLog(joinPoint);
            if (paramLog == null) {
                return;
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            if (paramLog.showParam()) {
                log.error(className + ":" + methodName + "的参数是{}", JSON.toJSONString(joinPoint.getArgs()));
            }
        } catch (Exception exp) {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private ParamLog getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(ParamLog.class);
        }
        return null;
    }
}

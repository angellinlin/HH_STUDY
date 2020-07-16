package com.weihongyu.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/16 19:09
 * @Description:注解开发的切面类
 */

@Aspect
public class LogInfo {

    @Pointcut("execution(* com.weihongyu.spring.aspect.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("-----aspect log1------");
        Object ret = joinPoint.proceed();

        return ret;

    }
    @Around("pointCut()")
    public Object aroundLog2(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("-----aspect log2------");
        Object ret = joinPoint.proceed();

        return ret;

    }
}

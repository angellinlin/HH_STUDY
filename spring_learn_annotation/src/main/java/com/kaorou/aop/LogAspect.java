package com.kaorou.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/27 09:50
 * @Description:
 */

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.kaorou.anno.UserServiceImpl.*(..))")
    public void pc1(){}

    @Pointcut("execution(* com.kaorou.anno.TestJDKProxy.*(..))")
    public void pc2(){}

    @Around("pc1()")
    public Object Log(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("---------AOP log 测试前------------");

        Object ret = joinPoint.proceed();

        System.out.println("---------AOP log 测试后------------");
        return ret;
    }

    @Around("pc2()")
    public Object Log22(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("---------AOP log 测试------------");
        Object ret = joinPoint.proceed();
        return ret;
    }
}

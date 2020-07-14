package com.weihongyu.spring.proxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/14 21:38
 * @Description:增强方法类，以日志为例
 */
public class BeforeLog implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("------method before log--------");
    }
}

package com.weihongyu.spring.JDK;

import com.weihongyu.spring.proxy.User;
import com.weihongyu.spring.proxy.UserService;
import com.weihongyu.spring.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/15 17:59
 * @Description:测试JDK自带的动态代理
 */
public class TestJDKProxy {

    public static void main(String[] args) {
        //1. 创建原始对象
        UserService userService = new UserServiceImpl();

        //2. proxy动态代理
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-----JDKProxy log-----");
                Object ret = method.invoke(userService, args);

                return ret;
            }
        };

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                invocationHandler);

        userServiceProxy.register(new User());
        userServiceProxy.login("kaorou", "123456");
    }
}

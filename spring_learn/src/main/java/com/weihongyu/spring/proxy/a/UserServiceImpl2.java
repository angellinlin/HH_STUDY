package com.weihongyu.spring.proxy.a;

import com.weihongyu.spring.proxy.User;
import com.weihongyu.spring.proxy.UserService;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/15 23:07
 * @Description:
 */
public class UserServiceImpl2 implements UserService2 {

    @Override
    public void login() {
        System.out.println("UserServiceImpl2.login222222");
    }
}

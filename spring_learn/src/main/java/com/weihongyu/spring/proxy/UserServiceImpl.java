package com.weihongyu.spring.proxy;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/14 21:28
 * @Description:核心业务功能实现
 */
public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }
}

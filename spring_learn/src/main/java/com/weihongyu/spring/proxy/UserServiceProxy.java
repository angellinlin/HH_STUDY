package com.weihongyu.spring.proxy;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/14 21:29
 * @Description:静态代理实现=目标类+增强功能+实现同一接口。以日志记录为例
 *
 */
public class UserServiceProxy implements UserService{

    private UserService userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        System.out.println("-----log-----");
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("-----log-----");
        return userService.login(name, password);
    }
}

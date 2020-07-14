package com.weihongyu.spring.proxy;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/14 21:26
 * @Description:
 */
public interface UserService {

    public void register(User user);

    public boolean login(String name, String password);
}

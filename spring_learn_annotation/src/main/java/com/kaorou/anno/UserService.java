package com.kaorou.anno;

import com.kaorou.entity.User;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/27 09:06
 * @Description:
 */

public interface UserService {

    public void save(User user);

    public void login(String name, String password);
}

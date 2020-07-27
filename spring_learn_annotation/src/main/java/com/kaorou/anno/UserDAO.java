package com.kaorou.anno;

import com.kaorou.entity.User;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/27 09:08
 * @Description:
 */
public interface UserDAO {

    public void save(User user);

    public void login(String name, String password);

}

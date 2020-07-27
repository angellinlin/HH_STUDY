package com.kaorou.anno;

import com.kaorou.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/27 09:07
 * @Description:
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.save(user);
        System.out.println("UserServiceImpl.save");
        //throw new RuntimeException("测试异常");
    }

    @Override
    public void login(String name, String password) {
        userDAO.login(name, password);
    }
}

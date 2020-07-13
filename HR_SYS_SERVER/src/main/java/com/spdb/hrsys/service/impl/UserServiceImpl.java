package com.spdb.hrsys.service.impl;

import com.spdb.hrsys.mbg.mapper.UserMapper;
import com.spdb.hrsys.mbg.model.User;
import com.spdb.hrsys.mbg.model.UserExample;
import com.spdb.hrsys.service.UserService;
import com.spdb.hrsys.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public User register(User user) {
        //查看是否重名
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0)
            return null;
        //密码加密
        String encodePwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePwd);
        userMapper.insert(user);
        return user;

    }

    @Override
    public String login(String username, String password) {
        String token = null;
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if (users != null && users.size() > 0){
            if (!passwordEncoder.matches(password, users.get(0).getPassword())){
                return null;
            }
            token = jwtTokenUtil.generateToken(username);
        }
        return token;
    }
}

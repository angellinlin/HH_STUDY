package com.spdb.hrsys.service;

import com.spdb.hrsys.mbg.model.User;

public interface UserService {
    User register(User user);
    String login(String username, String password);
}

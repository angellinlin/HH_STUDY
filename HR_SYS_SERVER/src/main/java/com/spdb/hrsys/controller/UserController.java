package com.spdb.hrsys.controller;

import com.spdb.hrsys.common.api.CommonResult;
import com.spdb.hrsys.dto.UserLoginParam;
import com.spdb.hrsys.mbg.model.User;
import com.spdb.hrsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public CommonResult<User> register(@RequestBody User userParam){
        User user = userService.register(userParam);
        if (user == null)
            return CommonResult.failed();
        return CommonResult.success(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public CommonResult<?> login(@RequestBody UserLoginParam userLoginParam){
        String token = userService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        if (token == null)
            return CommonResult.failed();
        return CommonResult.success(token);
    }
}

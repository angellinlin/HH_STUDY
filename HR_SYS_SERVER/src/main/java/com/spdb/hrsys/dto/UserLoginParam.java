package com.spdb.hrsys.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 *用户登录参数
 */
@Data
public class UserLoginParam {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;

}

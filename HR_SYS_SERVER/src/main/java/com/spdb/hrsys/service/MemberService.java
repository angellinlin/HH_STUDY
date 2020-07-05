package com.spdb.hrsys.service;

/**
 * 用户注册管理
 */
public interface MemberService {
    //生成验证码
    String generateAuthCode(String phone);
    //判断验证码是否正确
    boolean verifyAuthCode(String phone, String authCode);
}

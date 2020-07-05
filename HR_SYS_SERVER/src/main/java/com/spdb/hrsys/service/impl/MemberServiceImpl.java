package com.spdb.hrsys.service.impl;

import com.spdb.hrsys.service.MemberService;
import com.spdb.hrsys.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.time}")
    private Long REDIS_KEY_AUTH_CODE_EXPIRE;

    @Override
    public String generateAuthCode(String phone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<6; i++){
            sb.append(random.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + phone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+phone, REDIS_KEY_AUTH_CODE_EXPIRE);
        return sb.toString();
    }

    @Override
    public boolean verifyAuthCode(String phone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return false;
        }
        String realAuthCode  = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + phone);
        return realAuthCode.equals(authCode);
    }
}

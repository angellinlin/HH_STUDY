package com.spdb.hrsys.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt Token生成工具类
 * JWT token的格式：header.payload.signature
 * header的格式（算法、token的类型）：
 * {"alg": "HS512","typ": "JWT"}
 * payload的格式（用户名、创建时间、过期时间）：
 * {"sub":"wang","created":1489079981393,"exp":1489684781}
 * signature的生成算法：
 * HMACSHA512(base64UrlEncode(header) + "." +base64UrlEncode(payload),secret)
 */
@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     *生成jwt的token
     * @param claims
     * @return token
     */
    private String generateToken(Map<String, Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpiration())
                .signWith(SignatureAlgorithm.ES512, secret)
                .compact();
    }

    /**
     * 生成过期时间
     * @return 过期时间
     */
    private Date generateExpiration(){
        return new Date(System.currentTimeMillis() + expiration*1000);
    }

    /**
     *从token中获取JWT负载
     * @param token
     * @return  JWT payload
     */
    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            LOGGER.error("JWT格式验证失败：{}", token);
        }
        return claims;
    }

    /**
     * 判断token是否过期
     * @param token
     * @return 过期与否
     */
    private boolean isTokenExpired(String token){
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 获取token过期时间
     * @param token
     * @return 过期时间
     */
    private Date getExpiredDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 从token中获取用户名
     * @param token
     * @return 用户名
     */
    public String getUserNameFromToken(String token){
        String username = null;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e){
            LOGGER.error("从token中获取用户名失败");
        }
        return username;
    }

    /**
     *根据用户信息生成Token
     * @return token
     */
    public String generateToken(){
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 验证token是否有效
     * @param token 客户端传入的token
     * @param user 用户名
     * @return 是否有效
     */
    public boolean validateToken(String token, String user){
        String username = getUserNameFromToken(token);
        return user.equals(username) && !isTokenExpired(token);
    }
}

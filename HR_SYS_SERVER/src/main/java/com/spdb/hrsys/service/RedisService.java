package com.spdb.hrsys.service;

/**
 * redis操作
 * 对象和数组以json形式存储
 * @author Lou
 */
public interface RedisService {

    void set(String key, String value);

    String get(String key);

    void remove(String key);

    boolean expire(String key, long expire);

    /**
     * 自增操作
     * @param key
     * @param delta 自增步长
     * @return
     */
    Long increment(String key, long delta);
}

package com.spdb.hrsys.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * @author Lou
 */
@Configuration
@MapperScan("com.spdb.hrsys.mbg.mapper")
public class MyBatisConfig {
}

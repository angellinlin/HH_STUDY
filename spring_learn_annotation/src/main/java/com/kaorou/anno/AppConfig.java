package com.kaorou.anno;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/27 09:02
 * @Description:
 */
@Configuration
@ComponentScan(basePackages = "com.kaorou")
@MapperScan(basePackages = "com.kaorou.anno")
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = false)  //开启AOP注解功能, 默认false JDK, true为cglib
                                                   //但是当代理类没有实现接口时，无论true,false都会自动切换为cglib
@Import(DataSourceConfig.class)
public class AppConfig {

    @Autowired
    private DataSourceConfig dataSourceConfig;


    //-----------Mybatis配置开始-------------
    //1. dataSource
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dataSourceConfig.getDriverClassName());
        dataSource.setUrl(dataSourceConfig.getUrl());
        dataSource.setUsername(dataSourceConfig.getUsername());
        dataSource.setPassword(dataSourceConfig.getPassword());
        return dataSource;
    }

    //2. sqlSessionFactoryBean
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(dataSourceConfig.getTypeAliasesPackage());
        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource(dataSourceConfig.getMapperLocations()));
        return sqlSessionFactoryBean;
    }

    //3. MapperScannerConfigure
    //注解替代 @MapperScan(basePackages = "dao所在的包")
    //-----------Mybatis配置结束-------------



    //-----------事务配置开始-------------
    //1. 配置DataSourceTransactionManager
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    //2. 在事务开启处添加@Transactional注解

    //3. 开启事务配置
    //@EnableTransactionManagement 注解替代 <tx:annotation-driven transaction-manager="dataSourceTransactionManager"/>
    //-----------事务配置结束-------------


    //-----------AOP配置开始-------------
    //0. 原始功能开发 xxxService

    //1. 配置切面类，额外功能+切入点
    //@Aspect
    //@Component
    //@Around  @pointcut


    //2. 开启AOP配置
    //@EnableAspectJAutoProxy

    //-----------AOP配置结束-------------

}

package com.weihongyu.spring.test;

import com.weihongyu.spring.entity.People;
import com.weihongyu.spring.proxy.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 17:18
 * @Description:spring工厂测试类
 */
public class SpringIOCTest {

    /**
     * @Description：spring工厂的创建
     */
    @Test
    public void test1() throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("./applicationContext.xml");
        People people = (People) ctx.getBean("people");
        System.out.println("people = " + people);
    }



}

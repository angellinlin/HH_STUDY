package com.weihongyu.spring.test;

import com.weihongyu.spring.entity.People;
import com.weihongyu.spring.proxy.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 17:18
 * @Description:测试类
 */
public class SpringTest {

    /**
     * @Description：spring工厂的创建
     */
    @Test
    public void test1() throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("./applicationContext.xml");
        People people = (People) ctx.getBean("people");
        System.out.println("people = " + people);
    }

    /**
     * @Description:静态代理类测试
     */
    @Test
    public void test2() throws Exception{
        UserService userService = new UserServiceProxy();
        userService.login("why", "123456");
        userService.register(new User());

        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();
    }

    /**
     * @Description：spring动态代理测试
     */
    @Test
    public void test3() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register(new User());
        userService.login("why", "123456");

        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.showOrder();

    }

}

package com.weihongyu.spring.test;

import com.weihongyu.spring.proxy.*;
import com.weihongyu.spring.proxy.a.UserService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/15 10:16
 * @Description:AOP相关测试
 */
public class SpringAOPTest {

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

        UserService2 userService2 = (UserService2) ctx.getBean("userService2");
        userService2.login();


    }
}

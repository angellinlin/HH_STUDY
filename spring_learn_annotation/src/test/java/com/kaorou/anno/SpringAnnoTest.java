package com.kaorou.anno;

import com.kaorou.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/27 09:10
 * @Description:
 */

public class SpringAnnoTest {

    /**
     * @Description
     */
    @Test
    public void test1() throws Exception{
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }

    /**
     * @Description：测试service+dao+事务
     */
    @Test
    public void test2() throws Exception{
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.kaorou.anno");
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        User user = new User();
        user.setName("xiaowang异常");
        user.setPassword("999777111");

        userServiceImpl.save(user);
    }


    /**
     * @Description：测试注解版AOP
     */
    @Test
    public void test3() throws Exception{
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userServiceImpl = (UserService) ctx.getBean("userServiceImpl");
        User user = new User();
        user.setName("xiaowang787");
        user.setPassword("123456");

        userServiceImpl.save(user);
    }

    /**
     * @Description:测试AOP底层，不实现接口，底层会自动切换为cglib
     */
    @Test
    public void test4() throws Exception{
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        TestJDKProxy testJDKProxy = (TestJDKProxy) ctx.getBean("testJDKProxy");
        testJDKProxy.say();
    }
}

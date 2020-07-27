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
        user.setName("xiaowang888");
        user.setPassword("999777111888");

        userServiceImpl.save(user);
    }
}

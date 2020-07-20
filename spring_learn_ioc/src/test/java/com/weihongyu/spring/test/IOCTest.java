package com.weihongyu.spring.test;

import com.weihongyu.spring.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/20 16:27
 * @Description:
 */
public class IOCTest {

    /**
     * @Description：基本API的调用
     */
    @Test
    public void test1() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        Person person = (Person) ctx.getBean("person");
//        System.out.println(person);

        //当前Spring的配置文件中 只能有一个<bean class是Person类型
//        Person person = ctx.getBean(Person.class);
//        System.out.println("person = " + person);

        //获取的是 Spring工厂配置文件中所有bean标签的id值  person product
//        String[] names = ctx.getBeanDefinitionNames();
//        for (String s : names) {
//            System.out.println("s = " + s);

        //根据类型获得Spring配置文件中对应的id值
//        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
//        for (String id : beanNamesForType) {
//            System.out.println("id = " + id);
//        }

        boolean b = ctx.containsBeanDefinition("person"); //只判断id
        System.out.println(b);

        boolean p = ctx.containsBean("p1"); //即可判断id，也可判断name
        System.out.println(p);
    }

    /**
     * @Description:没有id的bean会自动生成id值么。会
     */
    @Test
    public void test2() throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        String[] ids = ctx.getBeanDefinitionNames();
        for (String id : ids) {

            //id = com.weihongyu.spring.Person#0
            System.out.println("id = " + id);
        }

        Person p2 = (Person) ctx.getBean("p2");
        System.out.println("p2 = " + p2);
    }
}

package com.weihongyu.spring.cglib;

import com.weihongyu.spring.proxy.User;
import com.weihongyu.spring.proxy.UserService;
import com.weihongyu.spring.proxy.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/15 17:49
 * @Description:测试cglib动态代理
 */
public class TestCglib {

    public static void main(String[] args) {

        //1.创建原始对象
        UserService userService = new UserServiceImpl();

        //2.通过cglib创建代理对象
        /*
            Proxy.newProxyInstance(classloader,interface,invocationhandler)

            enhancer.setClassLoader()
            enhancer.setSuperClass()
            enhancer.setCallback();  ---> 传入MethodInterceptor(cglib包)
            enhancer.create() ---> 代理对象创建
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(userService.getClass().getClassLoader());
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println("-----cglib log-------");
                Object ret = method.invoke(userService, objects);

                return ret;
            }
        };
        enhancer.setCallback(interceptor);
        UserService service = (UserService) enhancer.create();

        service.login("kaorou", "123456");
        service.register(new User());
    }
}

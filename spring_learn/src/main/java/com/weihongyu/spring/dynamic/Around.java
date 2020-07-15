package com.weihongyu.spring.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/15 10:29
 * @Description:MethodInterceptor接口测试类
 */
public class Around implements MethodInterceptor {

    /*
         invoke方法的作用:额外功能书写在invoke
                        额外功能  原始方法之前
                                 原始方法之后
                                 原始方法执行之前 之后
         确定：原始方法怎么运行

         参数：MethodInvocation （Method):额外功能所增加给的那个原始方法
                    login
                    register
              invocation.proceed() ---> login运行
                                        register运行

          返回值：Object: 原始方法的返回值
     */

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("--------around log--------");
        Object ret = invocation.proceed();
        System.out.println("--------around log--------");
        return ret;
    }
}

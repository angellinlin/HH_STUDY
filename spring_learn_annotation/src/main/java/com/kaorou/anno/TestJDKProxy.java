package com.kaorou.anno;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/27 10:23
 * @Description:
 */
@Component
@Scope
@Lazy
public class TestJDKProxy {

    public void say(){
        System.out.println("TestJDKProxy.say");
    }
}

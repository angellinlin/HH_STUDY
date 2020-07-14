package com.spdb.spring.bean;

import com.spdb.spring.annotation.HRBeanDefinition;
import com.spdb.spring.annotation.HRBeanDefinitionRegistry;
import com.spdb.spring.annotation.HRBeanFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: A wei
 * @Date: 2020/7/9 17:29
 * @Last Modified by:
 * @last Modified date:
 * @Description: BeanFactory
 */
public class HRDefaultBeanFactory implements HRBeanDefinitionRegistry, HRBeanFactory {

    //存放我们的Bean，暂时不考虑多线程问题，采用HashMap
    private Map<String,Object> beanMap = new HashMap<>();

    //存放bean定义信息
    private Map<String,HRBeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, HRBeanDefinition hrBeanDefinition) throws Exception {
        Objects.requireNonNull(beanName,"beanName can not be null!");
        Objects.requireNonNull(hrBeanDefinition,"bean definition can not be null!");
        if (beanDefinitionMap.containsKey(beanName)){
            throw new Exception("already exist" + beanName + "definition!");
        }
        beanDefinitionMap.put(beanName,hrBeanDefinition);
    }

    @Override
    public HRBeanDefinition getBeanDefinition(String beanName) {

        return null;
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return false;
    }

    @Override
    public Object getBean(String beanName) throws Exception {

        return doGetBean(beanName);

    }

    @Override
    public Object getBean(Class<?> beanClass) throws Exception {
        return null;
    }

    private Object doGetBean(String beanName) throws Exception{
        Objects.requireNonNull(beanName,"beanName can Not be null!");
        Object instance = beanMap.get(beanName);
        if (instance != null){
            return instance;
        }

        HRBeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        Objects.requireNonNull(beanDefinition,"bean definition can not be null!");
        Class<?> beanClass = beanDefinition.getBeanClass();
        Objects.requireNonNull(beanClass,"bean class can not be null!");

        instance = beanClass.newInstance();
        //获取到类实例，通过反射执行bean init

        String initMethodName = beanDefinition.getInitMethodName();
        if (initMethodName != null){
            Method method = beanClass.getMethod(initMethodName,null);
            method.invoke(instance);
        }
        beanMap.put(beanName,instance);

        return instance;
    }
}

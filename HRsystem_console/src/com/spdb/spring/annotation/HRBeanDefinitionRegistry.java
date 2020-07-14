package com.spdb.spring.annotation;

/**
 * @Author: A wei
 * @Date: 2020/7/9 17:24
 * @Last Modified by:
 * @last Modified date:
 * @Description: 将Bean注册到BeanFactory
 */
public interface HRBeanDefinitionRegistry {

    void registerBeanDefinition (String beanName, HRBeanDefinition hkBeanDefinition) throws Exception;

    HRBeanDefinition getBeanDefinition(String beanName);

    boolean containsBeanDefinition(String beanName);
}

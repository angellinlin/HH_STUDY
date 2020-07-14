package com.spdb.spring.annotation;

/**
 * @Author: A wei
 * @Date: 2020/7/9 17:03
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
public interface HRBeanFactory {

    Object getBean(String beanName) throws Exception;

    public Object getBean(Class<?> beanClass) throws Exception;

}

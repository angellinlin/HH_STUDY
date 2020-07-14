package com.spdb.spring.annotation;

/**
 * @Author: A wei
 * @Date: 2020/7/9 17:23
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
public interface HRBeanDefinition {

    final static String SINGLETION = "sigleton";

    String getInitMethodName();

    Class<?> getBeanClass();

}

package com.spdb.spring.bean;

import com.spdb.spring.annotation.HRBeanDefinition;

/**
 * @Author: A wei
 * @Date: 2020/7/9 17:06
 * @Last Modified by:
 * @last Modified date:
 * @Description: 用来描述Bean信息
 */
public class HRGenericBeanDefinition implements HRBeanDefinition {

    private Class<?> beanClass;

    public String getInitMethod() {
        return initMethod;
    }

    private String initMethod;

    public void setInitMethod(String initMethod){
        this.initMethod = initMethod;
    }

    @Override
    public String getInitMethodName() {
        return null;
    }

    @Override
    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}

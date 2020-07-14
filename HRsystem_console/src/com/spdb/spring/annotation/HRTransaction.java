package com.spdb.spring.annotation;

import java.lang.annotation.*;

/**
 * @Author: A wei
 * @Date: 2020/7/9 11:09
 * @Last Modified by:
 * @last Modified date:
 * @Description: 事务管理注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HRTransaction {
}

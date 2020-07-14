package com.spdb.spring.annotation;

import java.lang.annotation.*;

/**
 * @Author: A wei
 * @Date: 2020/7/9 10:58
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HRAutowired {

    boolean required() default true;
}

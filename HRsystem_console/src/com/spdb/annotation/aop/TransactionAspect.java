package com.spdb.annotation.aop;

import com.spdb.util.TransactionManagerUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: A wei
 * @Date: 2020/7/14 12:56
 * @Last Modified by:
 * @last Modified date:
 * @Description: spring aop功能 注解形式执行模板
 *
 */
@Aspect
@Component
public class TransactionAspect {

    @Autowired
    TransactionManagerUtil transactionManagerUtil;

    @Around("@annotation(TransactionAnnotation)")
    public Object doTransaction(ProceedingJoinPoint proceedingJoinPoint) throws SQLException {

        Connection connection = null;
        try {
            // 1、开启事务
            connection = transactionManagerUtil.getConnection();
            connection.setAutoCommit(false);
            System.out.println("开启事务");

            //2、业务逻辑
            Object result = proceedingJoinPoint.proceed();

            System.out.println("事务提交");
            connection.commit();
            return result;
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("事务回滚");
            //3、事务回滚
            connection.rollback();
        }
        return null;
    }
}

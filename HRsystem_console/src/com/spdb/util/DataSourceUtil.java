package com.spdb.util;

import com.spdb.annotation.TransactionAnnotation;
import com.spdb.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: A wei
 * @Date: 2020/7/9 8:32
 * @Last Modified by:
 * @last Modified date:
 * @Description: 数据库连接执行sql 封装
 */
public class DataSourceUtil {

    @Autowired
    private static TransactionManagerUtil transactionManagerUtil;

    @TransactionAnnotation
    public boolean executeCreate(String sql) throws SQLException {

        Connection connection = transactionManagerUtil.getConnection();
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }

    public boolean executeDelete(String sql) throws SQLException {
        Connection connection = transactionManagerUtil.getConnection();
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }

    public Resume executeSelect(String sql) throws SQLException {
        Connection connection = transactionManagerUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet == null){
            return null;
        }
        return resolveResume(resultSet);
    }


    private Resume resolveResume(ResultSet resultSet) throws SQLException {
        Resume resume = new Resume(resultSet.getString(1),
                                   resultSet.getString(2),
                                    resultSet.getString(3),
                                    resultSet.getString(4),
                                    resultSet.getInt(5),
                                    resultSet.getString(6),
                                    resultSet.getString(7),
                                    resultSet.getInt(8));

        return resume;

    }



}

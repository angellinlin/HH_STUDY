package com.spdb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: A wei
 * @Date: 2020/7/9 11:24
 * @Last Modified by:
 * @last Modified date:
 * @Description: 事务管理器，负责管理数据库连接,采用单例的设计模式，从而管理数据库的连接,不采用连接池
 */
@Component //托管给spring，默认创建单实例
public class TransactionManagerUtil {

    private ThreadLocal<Connection> connection = new ThreadLocal<>();

    private String url = "jdbc:mysql://localhost:3306/hr_system?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
    private String username = "root";
    private String password = "root";
    private String driver = "com.mysql.cj.jdbc.Driver";



    //一个线程对应一个请求，采用ThreadLocal的目的是保证多线程情况下的安全问题。防止多个线程拿到同一个连接
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (connection == null){
            connection.set(DriverManager.getConnection(url,username,password)); //一个线程有效，线程封闭
        }
        return connection.get();
    }
}

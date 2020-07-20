package com.sy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * @author sy
 * @date 2020/7/20 11:05
 */
@Component
public class DbConnectionUtils {
    //URL
    public static String url = "jdbc:mysql://127.0.0.1:3306/hysys?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false" ;

    //驱动
    public final static  String driver = "com.mysql.cj.jdbc.Driver";

    //用户名
    public static String username = "root";

    //密码
    public static String password = "sy440222";


    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭连接
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void closeConnection(ResultSet resultSet,Statement statement,Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
                if (statement!=null){
                    statement.close();
                }
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param statement
     * @param connection
     */
    public static void closeConnection(Statement statement,Connection connection){
        closeConnection(null,statement,connection);
    }

}

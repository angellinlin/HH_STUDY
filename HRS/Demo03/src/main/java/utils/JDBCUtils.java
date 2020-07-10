package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import db.DruidTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/9 17:40
 * @modified By：
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        Properties properties = new Properties();
        InputStream is = DruidTest.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    * 获取连接
    * */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /*
    * 释放资源
    * */
    public static void close(Statement statement, Connection connection) {
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //重载
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * 获取连接池
    * */
    public static DataSource getDs(){
        return ds;
    }




}

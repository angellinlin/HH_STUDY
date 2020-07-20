package database;

import java.sql.*;

//数据库的连接与关闭操作
public class DBConnection {
    //连接数据库，返回一个Connection对象
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取Connection对象
//            conn = DriverManager.getConnection("jdbc:mysql:///db1?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false", "root", "root");
            conn = DriverManager.getConnection("jdbc:mysql:///db1?serverTimezone=GMT", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭数据库连接，释放资源
    public static void closeConnection(Connection conn ,Statement stmt){
        //避免空指针异常
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void closeConnection(ResultSet rs, Connection conn , Statement stmt){
        //避免空指针异常
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}

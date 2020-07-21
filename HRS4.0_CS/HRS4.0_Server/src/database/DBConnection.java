package database;

import java.sql.*;

public class DBConnection {

    static final String url = "jdbc:mysql://localhost:3306/spdb?serverTimezone=UTC&characterEncoding=utf-8";
    static final String user = "root";
    static final String passwords = "root";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,passwords);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Statement: 用于执行sql语句的工具接口
     * ResultSet： 结果集对象
     */
    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

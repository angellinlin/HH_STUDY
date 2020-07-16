package JDBC;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;

public class MySQLConnect {

    private static final String URL = "jdbc:mysql://localhost:3306/lowsystemdb?serverTimezone=UTC";
    private static final String NAME = "root";
    private static final String PASSWORD = "1994";
    private static Connection connection = null;

    public static String getURL() {
        return URL;
    }

    public static String getNAME() {
        return NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static Connection getConnection() {
        return connection;
    }


    public MySQLConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("can't find driver");
            e.printStackTrace();
        }


        String sql;
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Mysql is connect! Welcome !!!");
                Statement statement = connection.createStatement();
                sql = "CREATE TABLE IF NOT EXISTS PeopleList (name varchar(255) not null,id int not null,school varchar(255) not null,"+
                "primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8";
                statement.execute(sql);
                System.out.println("DB created success!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package DBConnection;

import java.sql.*;

public class DBConnection {
    /* jdbc:mysql-connector-java:8.0.17 */
    static final String url = "jdbc:mysql://127.0.0.1:3306/hrsys?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    static final String name = "com.mysql.cj.jdbc.Driver";
    static final String user = "root";
    static final String pass = "0123";

    /*init*/
    static {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception:" + e.toString());
        }
    }

    /*get conn*/
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Get Database Connection failed.Check user&pass&url:" + e.toString());
            return null;
        }
    }
    /*close conn*/
    public static void closeConnection(ResultSet rs, PreparedStatement prestatement, Connection conn)
    {
        try {
            if(rs!=null) {
                rs.close();
            }
            if(prestatement!=null) {
                prestatement.close();
            }
            if(conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

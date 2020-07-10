package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author ：Timber
 * @date ：Created in 2020/7/9 11:58
 * @modified By：
 */
public class DBConnction {
    static final String url = "jdbc:mysql://127.0.0.1:3306/db1";
    static final String name = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String password = "root";
    Connection con = null;
    Statement statement= null;
    static
    {
        try
        {
            Class.forName(name);
        }
        catch(ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception:"+cE.toString());
        }
    }
    public Connection getConnection()
    {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void closeConnection(ResultSet rs, Statement statement, Connection con)
    {
        try {
            if(rs!=null) {
                rs.close();
            }
            if(statement!=null) {
                statement.close();
            }
            if(con!=null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeConnection(Statement statement,Connection con)
    {
        closeConnection(null,statement,con);
    }

    public static void main(String[] args) {
        DBConnction dbConnction = new DBConnction();
        Connection connection = dbConnction.getConnection();
        System.out.println(connection);
    }
}

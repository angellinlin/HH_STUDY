package DBConnection;

import java.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;

public class DBConnection {
    /* jdbc:mysql-connector-java:8.0.17 */
    /* c3p0-0.9.5.5.jar */
    private static DataSource dataSource=null;

    /*init*/
    static {
        dataSource=new ComboPooledDataSource("mysql");
    }

    /*get conn*/
    public static Connection getConnection() {
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
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

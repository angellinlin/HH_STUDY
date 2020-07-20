package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// 定义数据库连接关闭方法
public class DBConnection {
    static final String url = "jdbc:mysql://localhost:3306/HRS";
    static final String name = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String password = "12345678";
    Connection con = null;
    Statement statement = null;
    /*
    1、导入驱动jar包
        复制jar包到
    2、注册驱动
    3、获取数据库连接对象Connection
    4、定义SQL语句
    5、获取执行SQL语句的对象statement
    6、执行SQL，接受返回结果
    7、处理结果
    8、释放资源
     */
//    2、注册驱动
    static {
        try
        {
            Class.forName(name);//forname方法不能之间在类里写，可以在结构体、方法里面写

        }catch(
        ClassNotFoundException cE){
            System.out.println("Class Not Found Exception:" + cE.toString());
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // 关闭连接
    public static void closeConnection(ResultSet rs,Statement statement,Connection con)
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






}
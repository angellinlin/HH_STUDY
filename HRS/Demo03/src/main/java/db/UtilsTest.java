package db;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/9 17:52
 * @modified By：
 */
public class UtilsTest {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //定义sql语句
            String sql = "insert into student values(?,?,?)";
            //获取statement对象
            statement = connection.prepareStatement(sql);
            //给？赋值
            statement.setString(1,"石原里美");
            statement.setString(2,"002");
            statement.setString(3,"备胎");
            //执行sql语句
            int i = statement.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            System.out.println("输入信息错误，或者重复");
            e.printStackTrace();
        }finally {
            //释放连接
            JDBCUtils.close(statement,connection);
        }
    }
}

package db;

import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/9 10:13
 * @modified By：
 */
public class DruidTest {

    public static void main(String[] args) {
        //1.配置maven
        //2.定义配置文件
        //3.加载配置文件
        Properties properties = new Properties();
        InputStream is = DruidTest.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
            //4.获取连接池对象
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            //5.获取连接对象
            Connection connection = ds.getConnection();
            System.out.println(connection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

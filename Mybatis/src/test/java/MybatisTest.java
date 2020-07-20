import bean.User;
import dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/20 18:14
 * @modified By：
 */

public class MybatisTest {


    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂对象，要通过builder去创建
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(in);
        //使用工厂生产sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用Sqlsession创建Dao接口的代理对象
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> users = iUserDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
        in.close();

    }
}

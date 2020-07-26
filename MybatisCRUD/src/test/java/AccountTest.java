import bean.Account;
import bean.User;
import dao.IAccountDao;
import dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/26 10:37
 * @modified By：
 */
public class AccountTest {
    private InputStream in;
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IAccountDao accountDao;
    Scanner sc = new Scanner(System.in);

    @Before
    public void init() throws IOException {
        //1.加载配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactoryBuilder对象
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.使用SqlSessionFactoryBuilder对象调用build方法去创建sqlSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //4.使用sqlSessionFactory对象调用openSession方法去创建sqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //5.使用sqlSession对象创建userDao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws IOException{
        //提交事务
        sqlSession.commit();
        sqlSession.close();
        in.close();
        sc.close();
    }

    /**
     * 测试查询所有功能
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException {
        List<Account> all = accountDao.findAll();
        for (Account account : all) {
            System.out.println("---账户信息---");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}

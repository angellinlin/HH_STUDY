import bean.QueryVo;
import bean.User;
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
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/21 13:17
 * @modified By：
 */
public class MybatisTest {

    /**
     * 测试查询所有
     */
    private InputStream in;
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    Scanner sc = new Scanner(System.in);

    //在Test执行之前执行
    @Before
    public void init() throws IOException{
        //1.加载配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactoryBuilder对象
        sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //3.使用SqlSessionFactoryBuilder对象调用build方法去创建sqlSessionFactory对象
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //4.使用sqlSessionFactory对象调用openSession方法去创建sqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        //5.使用sqlSession对象创建userDao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    //在Test执行之后执行
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
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 测试新增用户功能
     * @throws IOException
     */
    @Test
    public void testAdd() throws IOException {
        Date date = new Date(System.currentTimeMillis());
        User user = new User("小八",date,"男","四川成都");
        userDao.addUser(user);

    }

    /**
     * 测试修改一条用户信息
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException{
        User user = new User();
        user.setId(53);
        user.setUsername("修改");
        user.setAddress("修改");
        user.setSex("修");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    /**
     * 测试删除用户功能
     * @throws IOException
     */
    @Test
    public void testDel() throws IOException {
        userDao.delUser(43);
    }


    /**
     * 根据姓名实现模糊查询
     * @throws IOException
     */
    @Test
    public void testFindByName() throws IOException{
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> byName = userDao.findByName(queryVo);
        for (User user1 : byName) {
            System.out.println(user1);
        }
    }


    /**
     * 根据id进行用户的查询
     */
    @Test
    public void testFindById(){
        User byId = userDao.findById(42);
        System.out.println(byId);
    }

}

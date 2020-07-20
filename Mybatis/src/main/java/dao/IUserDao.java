package dao;

import bean.User;

import java.util.List;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/20 10:43
 * @modified By：
 * 用户的持久层接口，写好对应的映射文件，就无须再写实现类
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
}

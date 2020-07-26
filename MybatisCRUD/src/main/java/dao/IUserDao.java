package dao;

import bean.QueryVo;
import bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Select("select * from user")
    public List<User> findAll();

    /**
     * 新增一个用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void addUser(User user);

    /**
     * 修改一名用户信息
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    public void updateUser(User user);


    /**
     * 根据id删除一条用户
     * @param id
     */
    @Delete("delete from user where id=#{id}")
    void delUser(Integer id);


    /**
     * 模糊查询
     * @param queryVo
     * @return
     */
    @Select("select * from user where username like #{user.username}")
    List<User> findByName(QueryVo queryVo);

    /**
     * 根据id查询用户信息
     * @param id
     */
    @Select("select * from user where id=#{idd}")
    User findById(int id);


}

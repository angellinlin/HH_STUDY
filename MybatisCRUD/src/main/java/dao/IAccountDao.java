package dao;

import bean.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/26 10:35
 * @modified By：
 */
public interface IAccountDao {


    /**
     * 查询账户所有
     * @return
     *
     * 之所以要配置Results,只因为实体类中包含了User类，但在表中不含，所有必须配置实体类和表的对应关系
     */

    @Select("select * from account")
    @Results(id = "accountMap", value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user",column = "uid", one = @One(select = "dao.IUserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();
}

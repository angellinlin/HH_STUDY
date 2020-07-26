package service;

import bean.Jhunter;
import bean.OperaResult;
import utils.DbConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sy
 * @date 2020/7/26 21:45
 */
public class Service {
    public OperaResult add(Jhunter jhunter){
        int line = 0;
        String sql = "INSERT INTO tb_jh(name,identity,age,school,specialty,tag) VALUES(?,?,?,?,?,?)";
        OperaResult operaResult = new OperaResult();
        Connection connection = DbConnectionUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,jhunter.getName());
            preparedStatement.setString(2,jhunter.getIdentity());
            preparedStatement.setInt(3,jhunter.getAge());
            preparedStatement.setString(4,jhunter.getSchool());
            preparedStatement.setString(5,jhunter.getSpecialty());
            preparedStatement.setInt(6,jhunter.getTag());
            line = preparedStatement.executeUpdate();
            if (line>0){
                operaResult.setIsSuccess("Success");
            }else {
                operaResult.setIsSuccess("Fail");
            }
            System.out.println("添加成功"+jhunter.toString());
            DbConnectionUtils.closeConnection(preparedStatement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
            operaResult.setOnFail("Fail");
        }
        return operaResult;
    }

    public OperaResult delete(String name) {
        int line = 0;
        String sql = "DELETE from tb_jh WHERE name = ?";
        OperaResult operaResult = new OperaResult();
        Connection connection = DbConnectionUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            line = preparedStatement.executeUpdate();
            if (line>0){
                operaResult.setIsSuccess("Success");
            }
            else {
                operaResult.setIsSuccess("Fail");
            }
            System.out.println("删除成功"+name);
            DbConnectionUtils.closeConnection(preparedStatement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
            operaResult.setOnFail("Fail");
        }
        return operaResult;
        
    }

    public OperaResult update(Jhunter jhunter) {
        int line = 0;
        String    sql = "UPDATE tb_jh SET name = ? WHERE name = ? ";
        OperaResult operaResult = new OperaResult();
        Connection connection = DbConnectionUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,jhunter.getName());
            line = preparedStatement.executeUpdate();
            System.out.println("更新成功"+jhunter.toString());
            if (line>0){
                operaResult.setIsSuccess("Success");
            }
            else {
                operaResult.setIsSuccess("Fail");
            }
            DbConnectionUtils.closeConnection(preparedStatement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
            operaResult.setOnFail("Fail");
        }
        return operaResult;

    }

    public OperaResult searchByName(String name) {
        int line = 0;
        String sql = "SELECT  * FROM tb_jh WHERE name = ?";
        OperaResult operaResult = new OperaResult();
        List<Jhunter> list = new ArrayList<>();
        Connection connection = DbConnectionUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet!=null){
                operaResult.setIsSuccess("Success");
                while (resultSet.next()){
                    Jhunter jhunter = new Jhunter();
                    jhunter.setId(resultSet.getInt("id"));
                    jhunter.setName(resultSet.getString("name"));
                    jhunter.setIdentity(resultSet.getString("identity"));
                    jhunter.setAge(resultSet.getInt("age"));
                    jhunter.setSchool(resultSet.getString("school"));
                    jhunter.setSpecialty(resultSet.getString("specialty"));
                    jhunter.setTag(resultSet.getInt("tag"));
                    list.add(jhunter);
                }
                operaResult.setOperaData(list);
            }else {
                operaResult.setIsSuccess("Fail");
            }

            System.out.println("搜索成功"+list.toString());
            DbConnectionUtils.closeConnection(preparedStatement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
            operaResult.setOnFail("Fail");
        }
        return operaResult;
    }
}

package service;

import bean.Student;
import org.junit.Test;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/9 18:28
 * @modified By：
 */
public class StudentService {

    /**
     * 新增一条记录学生
     * @param student
     */
    public void add(Student student){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //获取连接对象
            connection = JDBCUtils.getConnection();
            //定义SQL语句
            String sql = "insert into student values(?,?,?)";
            //获取preparedstatement对象
            statement = connection.prepareStatement(sql);
            //给？赋值
            statement.setString(1,student.getName());
            statement.setString(2,student.getId());
            statement.setString(3,student.getPosition());
            //执行sql语句
            int i = statement.executeUpdate();
            if (i == 1){
                System.out.println("新增学生成功");
            }

        } catch (SQLException e) {
            System.out.println("新增学生失败，检查是否信息输错或者重复");
//            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement,connection);
        }
    }


    /**
     * 根据学生的id删除学生信息
     * @param id
     */
    public void delete(String id){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from student where id = " + id;
            statement = connection.prepareStatement(sql);
            int i = statement.executeUpdate();
            if (i == 1){
                System.out.println("删除学生记录成功");
            }else {
                System.out.println("删除失败，该学生不存在");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement,connection);
        }
    }


    /**
     * 根据学生的id进行招聘信息修改
     * @param student
     */
    public void modify(Student student){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "UPDATE student SET name = ?, position = ?  WHERE id = " + student.getId();
            statement = connection.prepareStatement(sql);
            statement.setString(1,student.getName());
            statement.setString(2,student.getPosition());
            int i = statement.executeUpdate();
            if (i == 1){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败，该学生不存在");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement,connection);
        }
    }


//    @Test
//    public void testsql(){
//        String sql = "delete from student where id = " + 001;
//        System.out.println(sql);
//    }


    /**
     * 查询应聘学生信息
     * @return ArrayList<Student>
     */
    public ArrayList<Student> search(){
        ArrayList<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from student";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //把查询结果封装在学生集合中返回
            while (rs.next()){
                Student student = new Student(rs.getString(1),rs.getString(2),rs.getString(3));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("查询失败");
            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement,connection);
        }
        return students;
    }


}

package work;

import bean.Resume;
import bean.ResumeList;
import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class HROperation{

    public int deleteByName(Resume resume){
        int temp = 0;
        try {
            //    3、获取数据库连接对象Connection
            Connection con = DBConnection.getConnection();
            //    4、定义SQL语句
            String stringSql = "delete from hrs where iname = '" + resume.getName() + "'";            //    5、获取执行SQL语句的对象statement
            Statement statement = con.createStatement();
            //    6、执行SQL，接受返回结果
            temp = statement.executeUpdate(stringSql);
            // 关闭数据库连接
            DBConnection.closeConnection((ResultSet)null,statement,con);
        }catch (SQLException var6){
            System.out.println("SQL Exception:" + var6.toString());
        }
        return temp;
    }

    public  void findPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查询的身份证号");
        String id = sc.next();
    }

    public  int insertPerson(Resume resume) {
        int temp = 0;
        try{
            //    3、获取数据库连接对象Connection
            Connection con = DBConnection.getConnection();
            //    4、定义SQL语句
            String stringSql = "insert into hrs values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+"')";
            //    5、获取执行SQL语句的对象statement
            Statement statement = con.createStatement();
            //    6、执行SQL，接受返回结果
            temp = statement.executeUpdate(stringSql);
            // 关闭数据库连接
            DBConnection.closeConnection((ResultSet)null,statement,con);
        }catch (SQLException var6){
            System.out.println("SQL Exception:" + var6.toString());
        }
        return temp;
    }

    public  void updatePerson() {
    }

    public int deleteById(Resume resume) {
        int temp = 0;
        try {
            //    3、获取数据库连接对象Connection
            Connection con = DBConnection.getConnection();
            //    4、定义SQL语句
            String stringSql = "delete from hrs where id = '" + resume.getId() + "'";            //    5、获取执行SQL语句的对象statement
            Statement statement = con.createStatement();
            //    6、执行SQL，接受返回结果
            temp = statement.executeUpdate(stringSql);
            // 关闭数据库连接
            DBConnection.closeConnection((ResultSet)null,statement,con);
        }catch (SQLException var6){
            System.out.println("SQL Exception:" + var6.toString());
        }
        return temp;
    }

    public ResumeList searchByName(Resume resume) {
        ResumeList resumeList =new ResumeList();
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql = "select * from hrs where iname='" + resume.getName() + "'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()) {
                Resume re1 = new Resume(rs.getString(1), rs.getString(2), rs.getString(3));
                resumeList.add(re1);
            }
            DBConnection.closeConnection(rs, statement, conn);
        } catch (SQLException var8) {
            System.out.println("SQL Exception:" + var8.toString());
        }
        return resumeList;
    }

    public int updateResumName(Resume resumeOld, Resume resumeNew) {
        int temp = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String stringSql = "UPDATE hrs SET iname = '" + resumeNew.getName()
                    + "', id='" + resumeNew.getId() + "',school='" + resumeNew.getSchool() + "'";
            temp = statement.executeUpdate(stringSql);
            DBConnection.closeConnection((ResultSet)null, statement, conn);
        } catch (SQLException var7) {
            System.out.println("SQL Exception:" + var7.toString());
        }

        return temp;
    }

    public int updateResumeProcess(Resume resumeOld, int process) {
        return 0;
    }
}

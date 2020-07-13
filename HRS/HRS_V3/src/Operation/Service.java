package Operation;

import Resume.Resume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//简历的增删改查
public class Service {
    //添加简历信息功能
    public static void addResume() {
        System.out.println("欢迎进入添加简历信息界面！");
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        System.out.println("请依次输入姓名，学校，身份ID，email");
        String resumeName = input.nextLine();
        String resumeSchool = input.nextLine();
        String resumeId = input.nextLine();
        String resumeEmail = input.nextLine();
        //get/SET
        Resume resume = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);
        //-------连接与关闭数据库的操作-------
        try {
            //连接数据库
            Connection conn = DBConnection.getConnection();
            //定义查询语句sql
            String sql = "insert into resume values('" + resume.getName() + "','" + resume.getSchool() + "','" + resume.getId() + "','" + resume.getEmail() + "')";
            //获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();
            //执行sql
            int count = stmt.executeUpdate(sql);//影响的行数
            if (count > 0) {
                System.out.println("您的信息已成功录入系统！");
            } else {
                System.out.println("信息填加失败！");
            }
            DBConnection.closeConnection(conn, stmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //--------------------------------
    }

    //删除简历功能
    public static void deletResume() {
        System.out.println("欢迎进入删除简历信息界面！");
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        System.out.println("输入你要删除的简历身份Id:");
        String id = input.nextLine();
        //连接与断开数据库
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            //删除语句
            String sql = "delete from resume where id= '" + id + "'";
            int count = stmt.executeUpdate(sql);
            if(count>0)
            {
                System.out.println("简历删除成功！");
            }
           else {
                System.out.println("无该应聘者简历信息！");
            }
            DBConnection.closeConnection(conn, stmt);//断开连接，释放资源
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //显示简历信息
    private static void showResume(Resume resume) {
        System.out.println("姓名：" + resume.getName() + ", 学校：" + resume.getSchool() + ", 身份ID：" + resume.getId()
                + ", email:" + resume.getEmail());
    }

    //修改简历信息功能
    public static void modifyResume() {
        System.out.println("欢迎进入修改简历信息界面！");
        System.out.println("请输入应聘人员的身份证号码：");//因为身份证信息是唯一的。
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        String dId = input.nextLine();
        //连接数据库
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql1 = "select * from resume where id= '" + dId + "'";
            ResultSet rs = stmt.executeQuery(sql1);
            rs.next();
            System.out.println("该应聘者的信息为：");
            showResume(new Resume(rs.getString("name"), rs.getString("school"),
                    rs.getString("id"), rs.getString("email")));
            System.out.println("--------开始更新简历信息--------");
            System.out.println("请输入应聘者的名字：");
            String resumeName = input.nextLine();
            System.out.println("请输入应聘者的学校：");
            String resumeSchool = input.nextLine();
            System.out.println("请输入应聘者的身份Id：");
            String resumeId = input.nextLine();
            System.out.println("请输入应聘者的email：");
            String resumeEmail = input.nextLine();
            String sql2 = "update resume set name ='" + resumeName + "',school='" + resumeSchool + "',id='" + resumeId + "',email='" + resumeEmail + "' where id='" + dId + "'";
            int count = stmt.executeUpdate(sql2);
            if (count > 0) {
                System.out.println("简历修改成功！");
            } else {
                System.out.println("简历修改存在异常！");
            }
            DBConnection.closeConnection(rs, conn, stmt);//断开连接，释放资源
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //查看简历功能
    public static void searchResume() {
        System.out.println("欢迎进入查询简历信息界面！");
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        boolean flag = true;
        while (flag) {
            System.out.println("查询全部---1");
            System.out.println("查询单人---2");
            System.out.println("退出查询---3");
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    List<Resume> applicants = new ArrayList<>();
                    searchAllResume(applicants);
                    for (Resume applicant : applicants) {
                        showResume(applicant);
                    }
                    break;
                }
                case 2: {
                    System.out.println("请输入你要查询的应聘者的身份ID：");
                    String tempId = input.next();
                    Resume resume = searchSingleResume(tempId);
                    showResume(resume);
                    break;
                }
                case 3:
                    flag = false;
                    break;
                default: {
                    System.out.println("输入错误！请重新输入：");
                }
            }
        }
    }

    //从数据库读取全部应聘者的简历信息，存入List<Resume>中
    private static void searchAllResume(List<Resume> applicants) {
        //连接数据库
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from resume";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Resume resume = new Resume(rs.getString("name"), rs.getString("school"),
                        rs.getString("id"), rs.getString("email"));
                applicants.add(resume);
            }
            DBConnection.closeConnection(rs, conn, stmt);//断开连接，释放资源
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //从数据库中读取某位应聘者的简历信息
    private static Resume searchSingleResume(String tempId) {
        Resume resume = null;
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            //查询语句
            String sql = "select * from resume where id= '" + tempId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();//rs最初位于第一行之前，用来维护指向当前是数据行的光标
            resume = new Resume(rs.getString("name"), rs.getString("school"),
                    rs.getString("id"), rs.getString("email"));
            DBConnection.closeConnection(rs, conn, stmt);//断开连接，释放资源
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resume;
    }
}

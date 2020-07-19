package Server;

import model.Student;

import java.sql.*;
import java.util.Scanner;

public class studentServer {
    private static Connection conn = null;

    public static void initConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrstudent?useUnicode=true&characterEncoding=utf8&useSSL=false", "root", "password");

    }

    public static void closeConnection() throws Exception {
        conn.close();
    }

    public static void addStudent() throws Exception {

        System.out.println("录入信息");

        Scanner input = new Scanner(System.in);

        System.out.println("请依次输入需要学生姓名，身份证号，毕业学校");

        String sName = input.nextLine();

        String sId = input.nextLine();

        String school = input.nextLine();
        initConnection();

        String sql = " INSERT INTO student(sName,sId,school)  VALUES (?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, sName);

        ps.setString(2, sId);

        ps.setString(3, school);

        ps.executeUpdate();

        ps.close();

        closeConnection();

        System.out.println("您已成功录入信息");
    }

    public static void deleteStu() throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("请输入需要删除的学生身份证号");

        String sId = input.nextLine();

        initConnection();

        String sql = "delete  from student where sId=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, sId);

        ps.executeUpdate();

        ps.close();

        closeConnection();
    }

    public static void updateStudent() throws Exception {

        initConnection();
        Scanner input = new Scanner(System.in);

        System.out.println("修改信息");

        System.out.println("请输入需要修改的学生身份证号");

        String sId = input.nextLine();

        System.out.println("输入修改后的信息");

        String sName = input.nextLine();

        String school = input.nextLine();

        String sql = "update student set sName=?,school=? where sId=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, sName);

        ps.setString(2, school);

        ps.setString(3, sId);

        ps.executeUpdate();

        ps.close();

        closeConnection();
    }

    public static void showStudent() throws Exception {

        System.out.println("学生姓名" + "   身份证号" + "          毕业院校");
        initConnection();
        String sql = "SELECT * FROM student";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        while (rs.next()) {

            System.out.println(rs.getString("sName") + "   " +
                    rs.getString("sId") + "          " +
                    rs.getString("school"));

        }
        closeConnection();

    }
}


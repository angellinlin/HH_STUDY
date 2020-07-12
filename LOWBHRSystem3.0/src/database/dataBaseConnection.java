package database;

import java.sql.*;
import java.lang.*;
import java.util.*;
import pojo.*;

public class dataBaseConnection {
    static final String url = "jdbc:mysql://localhost:3306/resume?&useSSL=false&serverTimezone=UTC";
    static final String user = "root";
    static final String password = "wangkan@112358";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //把数据库连接的驱动加载到java虚拟机
        }
        catch (ClassNotFoundException e) {
            System.out.println("找不到程序驱动类，加载驱动失败！");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        System.out.println("是否连接MySQL数据库，Y/N?");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();

        if(choice.equals("Y")) {
            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException ce) {
                ce.printStackTrace();
                System.out.println("连接MySQL数据库失败！");
                return null;
            }
        }
        else{
            return null;
        }
    }

    public static void closeConnection(connector con) {

        try {
            if (con.rs != null) {
                con.rs.close();    //回收垃圾回收机制
                con.rs = null;
            }
            if (con.ps != null) {
                con.ps.close();
                con.ps = null;
            }
            if (con.con != null) {
                con.con.close();
                con.con = null;
            }
        }
        catch (SQLException ce) {
            ce.printStackTrace();
        }
    }
}

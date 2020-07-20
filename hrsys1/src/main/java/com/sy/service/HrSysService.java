package com.sy.service;

import com.sy.bean.Jhunter;
import com.sy.utils.DbConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sy
 * @date 2020/7/20 11:07
 */
public class HrSysService {
    /**
     * 添加
     */
    public void add() {
        System.out.println("请依次输入姓名，身份证，年龄，学校，专业，状态");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String identity = input.nextLine();
        int age = Integer.parseInt(input.nextLine());
        String school = input.nextLine();
        String specialty = input.nextLine() ;
        int tag = input.nextInt();
        Jhunter jhunter = new Jhunter();
        jhunter.setName(name);
        jhunter.setIdentity(identity);
        jhunter.setAge(age);
        jhunter.setSchool(school);
        jhunter.setSpecialty(specialty);
        jhunter.setTag(tag);
        Connection connection = DbConnectionUtils.getConnection();
        try {
            String sql = "INSERT INTO tb_jh(name,identity,age,school,specialty,tag) VALUES(?,?,?,?,?,?)";

            PreparedStatement preparedStatement  = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,identity);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,school);
            preparedStatement.setString(5,specialty);
            preparedStatement.setInt(6,tag);
            preparedStatement.execute();
            System.out.println("添加成功"+jhunter.toString());
            DbConnectionUtils.closeConnection(preparedStatement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 删除
     */
    public void delete() {
        System.out.println("基于内存和控制台的hr系统1.0");
        Scanner input = new Scanner(System.in);
        System.out.println("输入要删除者的名字");
        //先查询在删除 重名则输入身份证号
        String name = input.nextLine();
        List<Jhunter> search = search(name);
        Connection connection = DbConnectionUtils.getConnection();
        String sql = "DELETE from tb_jh WHERE name = ?";
        switch (search.size()){
            case 0:
                System.out.println("没有该求职者，请重新输入！");
                break;
            case 1:
                System.out.println("是否进行该操作 Y/N");
                Scanner choose = new Scanner(System.in);
                String check = choose.nextLine();
                while (!check.equals("Y")&&!check.equals("N")){
                    System.out.println("请输入Y或者N");
                }
                if (check.equals("Y")){
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1,name);
                        preparedStatement.execute();
                        System.out.println("删除成功");
                        DbConnectionUtils.closeConnection(preparedStatement,connection);
                    } catch (SQLException e) {
                        System.out.println("删除失败"+e.getMessage());
                        e.printStackTrace();
                    }
                }else if (check.equals("N")){
                    System.out.println("操作取消");
                    break;
                }
                break;
            default:
                System.out.println("发现重名，请输入身份证号删除");
                Scanner in = new Scanner(System.in);
                String identity = in.nextLine();
                boolean delete = false;
                for (Jhunter jhunter:search
                ) {
                    String identity1 = jhunter.getIdentity();
                    if (identity == identity1){
                        sql = "DELETE from tb_jh WHERE identity = ?";
                        try {
                            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setString(1,identity);
                            preparedStatement.execute();
                            System.out.println("删除成功");
                            DbConnectionUtils.closeConnection(preparedStatement,connection);
                        } catch (SQLException e) {
                            System.out.println("删除失败"+e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("不存在或者删除失败");
        }
    }

    /**
     * 更新
     */
    public void update() {
        System.out.println("基于内存和控制台的hr系统1.0");
        Scanner input = new Scanner(System.in);
        System.out.println("输入要更新者的名字");
        //先查询
        String name = input.nextLine();
        List<Jhunter> search = search(name);
        Connection connection = DbConnectionUtils.getConnection();
        String sql = "";
        PreparedStatement preparedStatement = null;
        if (!search.isEmpty()) {
            switch (search.size()){
                case 0:
                    System.out.println("没有该求职者，请重新输入！");
                    break;
                case 1:
                    System.out.println("请输入更新项");
                    System.out.println("更新名字输入---1");
                    System.out.println("更新状态输入---2");
                    Scanner choose = new Scanner(System.in);
                    String check = choose.nextLine();
                    while (!check.equals("1")&&!check.equals("2")){
                        System.out.println("请输入1或者2");
                    }
                    if (check.equals("1")){
                        System.out.println("请输入新名字");
                        Scanner scannerName = new Scanner(System.in);
                        String nName = scannerName.nextLine();
                        search.get(0).setName(nName);
                        sql = "UPDATE tb_jh SET name = ? WHERE name = ?";
                        try {
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setString(1,nName);
                            preparedStatement.setString(2,name);
                            preparedStatement.execute();
                            System.out.println("更新成功"+search.get(0).toString());
                        } catch (SQLException e) {
                            e.printStackTrace();
                            System.out.println("更新失败"+e.getMessage());
                        }

                    }else if (check.equals("2")){
                        System.out.println("请输入新状态");
                        Scanner scannerTag = new Scanner(System.in);
                        int nTag = scannerTag.nextInt();
                        search.get(0).setTag(nTag);
                        sql = "UPDATE tb_jh SET tag = ? WHERE name = ?";
                        try {
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setInt(1,nTag);
                            preparedStatement.setString(2,name);
                            preparedStatement.execute();
                            System.out.println("更新成功"+search.get(0).toString());
                        } catch (SQLException e) {
                            e.printStackTrace();
                            System.out.println("更新失败"+e.getMessage());
                        }
                    }
                    DbConnectionUtils.closeConnection(preparedStatement,connection);
                    break;
                //超过一个
                default:
                    System.out.println("发现重名，请输入身份证号更新");
                    Scanner in = new Scanner(System.in);
                    String identity = in.nextLine();
                    boolean delete = false;
                    for (Jhunter jhunter:search
                    ) {
                        String identity1 = jhunter.getIdentity();
                        if (identity == identity1){
                            System.out.println("请输入更新项");
                            System.out.println("更新名字输入---1");
                            System.out.println("更新状态输入---2");
                            Scanner update = new Scanner(System.in);
                            String item = update.nextLine();
                            while (!item.equals("1")&&!item.equals("2")){
                                System.out.println("请输入1或者2");
                                choose = new Scanner(System.in);
                            }
                            if (item.equals("1")){
                                System.out.println("请输入新名字");
                                Scanner scannerName = new Scanner(System.in);
                                String nName = scannerName.nextLine();
                                sql = "UPDATE tb_jh SET name = ? WHERE name = ?";
                                try {
                                    preparedStatement = connection.prepareStatement(sql);
                                    preparedStatement.setString(1,nName);
                                    preparedStatement.setString(2,name);
                                    preparedStatement.execute();
                                    System.out.println("更新成功"+search.get(0).toString());
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    System.out.println("更新失败"+e.getMessage());
                                }

                            }else if (item.equals("2")){
                                System.out.println("请输入新状态");
                                Scanner scannerTag = new Scanner(System.in);
                                int nTag = scannerTag.nextInt();
                                sql = "UPDATE tb_jh SET tag = ? WHERE name = ?";
                                try {
                                    preparedStatement = connection.prepareStatement(sql);
                                    preparedStatement.setInt(1,nTag);
                                    preparedStatement.setString(2,name);
                                    preparedStatement.execute();
                                    System.out.println("更新成功"+search.get(0).toString());
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    System.out.println("更新失败"+e.getMessage());
                                }
                                DbConnectionUtils.closeConnection(preparedStatement,connection);
                            }
                        }
                    }
                    System.out.println("不存在或者更新失败");
            }
        }
        System.out.println("不存在该人");
    }

    /**
     * 搜索
     */
    public void search() {
        System.out.println("基于内存和控制台的hr系统1.0");
        Scanner input = new Scanner(System.in);
        System.out.println("输入要搜索的名字");
        String name = input.nextLine();
        List<Jhunter> search = search(name);
        System.out.println("搜素结果为"+search.toString());
    }

    /**
     * 搜索
     */
    public List<Jhunter> search(String name) {
        Connection connection = DbConnectionUtils.getConnection();
        List<Jhunter> list = new ArrayList<>();
        String sql = "SELECT  * FROM tb_jh WHERE name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 退出
     */
    public void exit() {
        System.out.println("你已成功退出");
        System.exit(0);
    }
}

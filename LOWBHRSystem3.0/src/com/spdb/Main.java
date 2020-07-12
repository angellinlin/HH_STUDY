/**
 * A program for JAVA-LOWBHRSystem
 * @version 1.0 2020-07-06
 * @author Kan Wang
 */

package com.spdb;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.sql.*;

import pojo.*;
import operation.dataOperate;
import service.PersonService;
import database.dataBaseConnection;

public class Main {
    public static void main(String [] args) {

        //LOWBHRSystem 3.0 基于数据库的存储方式
        connector con = new connector();
        con.con = dataBaseConnection.getConnection();
        Scanner in = new Scanner(System.in);

        if(con.con != null) {

            PersonService.createTable(con);

            while (true) {
                System.out.println("************Welcome to LOWBHRSystem 3.0************");
                System.out.println("新增人员信息请按--------1");
                System.out.println("更新人员信息请按--------2");
                System.out.println("删除人员信息请按--------3");
                System.out.println("打印人员信息请按--------4");
                System.out.println("退出HR系统请按--------5");

                int c = in.nextInt();

                //switch-case分支
                if (c == 1) {
                    PersonService.addPerson(con);
                }
                else if (c == 2) {
                    PersonService.updatePerson(con);
                }
                else if (c == 3) {
                    PersonService.deletePerson(con);
                }
                else if (c == 4) {
                    PersonService.showPerson(con);
                }
                else if (c == 5) {
                    dataBaseConnection.closeConnection(con);
                    System.out.println("您已退出HR系统！");
                    break;
                }
                else {
                    System.out.println("功能尚未完善，请按指示操作！");
                }
            }
        }
        else{
            System.out.println("连接MySQL数据库失败，即将退出！");
            return;
        }
    }
}

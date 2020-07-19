import Server.studentServer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
         /*
        HR系统03-基于数据库的HR管理系统
        hc-7/19
        HR系统的菜单显示（退出系统之前循环显示菜单）
        学生信息存储在数据库中
     */

        while (true) {

            System.out.println("基于内存控制台的HR管理系统!");

            System.out.println("1.学生信息录入");

            System.out.println("2.学生信息查询");

            System.out.println("3.学生信息删除");

            System.out.println("4.学生信息修改");

            System.out.println("5.退出系统");

            Scanner sc = new Scanner(System.in);

            int c = sc.nextInt();

            switch (c) {

                case 1:

                    studentServer.addStudent();

                    break;

                case 2:

                    studentServer.showStudent();

                    break;
                case 3:

                    studentServer.deleteStu();

                    break;
                case 4:

                    studentServer.updateStudent();

                    break;

                case 5:

                    System.out.println("退出系统");

                    break;
                default:

                    System.out.println("无效输入");

                    c = 5;

                    break;
            }

            if (c == 5) break;
        }
    }
}



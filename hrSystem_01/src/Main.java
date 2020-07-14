import Server.hrServer;
import model.Student;

/*
    HR系统01-基于内存控制台HR管理系统
    hc-7/14
    HR系统的菜单显示（退出系统之前循环显示菜单）
    使用双向链表LinkedList存储学生对象，作为基于内存的HR管理系统的依据
    每次启动运行主程序时，之前的信息将被清空
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

        LinkedList<Student> sList = new LinkedList<Student>();

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

                    hrServer.addStudent(sList);

                    break;

                case 2:

                    hrServer.showStudent(sList);

                    break;
                case 3:

                    hrServer.deleteStudent(sList);

                    break;
                case 4:

                   hrServer.updateStudent(sList);

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

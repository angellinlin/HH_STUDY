import Server.informationServer;
import Server.studentServer;
import model.Student;

import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    /*
        HR系统02-基于txt文件的HR管理系统
        hc-7/15
        HR系统的菜单显示（退出系统之前循环显示菜单）
        学生信息存储在桌面txt文件中
     */
        public static void main(String[] args)  {

            LinkedList<Student> sList = new LinkedList<Student>();

            //加载学生信息
            informationServer.loadData(sList);

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

                        studentServer.addStudent(sList);

                        break;

                    case 2:

                        studentServer.showStudent(sList);

                        break;
                    case 3:

                        studentServer.deleteStudent(sList);

                        break;
                    case 4:

                        studentServer.updateStudent(sList);

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

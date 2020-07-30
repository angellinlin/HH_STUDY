package cn.swjtu.HRSystem;
/*
需要实现以下功能：
    1、从txt中学生信息录入
    2、从txt中学生信息删除
    3、从txt中学生信息修改
    4、从txt中学生信息查询
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

import cn.swjtu.Student.Student;
import cn.swjtu.Operator.SystemOperator;

import static cn.swjtu.Operator.SystemOperator.addStudent;

public class HRMain {
    //创建一个集合用于存储学生对象
    public static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎进入HR_Syetem1.0系统，请输入你要进行的操作：");
            System.out.println("1--增加学生信息");
            System.out.println("2--查询学生信息");
            System.out.println("3--修改学生信息");
            System.out.println("4--删除学生信息");
            String in = sc.nextLine();
            switch (Integer.valueOf(in)) {
                case 1: {//增加学生信息
                    SystemOperator.addStudent();
                    break;
                }
                case 2: {//2--查询学生信息

                    SystemOperator.foreachStudent();
                    break;
                }
                case 3: {//3--修改学生信息
                    SystemOperator.alterStudent();
                    break;
                }
                case 4: {//4--删除学生信息
                    SystemOperator.deleteStudent();
                    break;
                }
                default:
                    break;

            }
            if (in.equals("")) {
                break;
            }

        }

    }
}



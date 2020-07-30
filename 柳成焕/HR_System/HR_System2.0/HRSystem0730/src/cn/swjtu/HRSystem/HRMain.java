package cn.swjtu.HRSystem;
/*
需要实现以下功能：
    1、从txt中学生信息录入
    2、从txt中学生信息删除
    3、从txt中学生信息修改
    4、从txt中学生信息查询

思路：
1、从文本中加载已有数据到内存中
使用缓冲字符输出流BufferedReader和缓冲字符输出流BufferWriter
2、对读取到的字节进行解析，将每一行解析后存入到ArrayList数组中
3、提示用户选择操作：1-添加 2-查询 3-修改  4-删除
这个版本是对txtx进行操作，其中添加、修改、删除都会涉及到改动txt，而查询则不需要，直接读取后进行查询。
4、保存学生信息，所有操作完成后都将数据写入到文件中保存
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

import cn.swjtu.DataTxt.DataOperatorTXT;
import cn.swjtu.Student.Student;
import cn.swjtu.Operator.SystemOperator;

import static cn.swjtu.Operator.SystemOperator.addStudent;

public class HRMain {
    //创建一个集合用于存储学生对象
    // public static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入HR_System2.0系统，正在加载文本数据，请稍等...");
        //加载文本资源
        ArrayList<Student> students = DataOperatorTXT.loadData();

        while (true) {
            System.out.println("请输入您想要进行的操作：");
            System.out.println("1--增加学生信息");
            System.out.println("2--查询学生信息");
            System.out.println("3--修改学生信息");
            System.out.println("4--删除学生信息");
            String in = sc.nextLine();
            if (in.equals("")) {
                break;
            }
            switch (Integer.valueOf(in)) {
                case 1: {//增加学生信息
                    students = SystemOperator.addStudent(students);
                    //并将其保存至txt中
                    students=DataOperatorTXT.saveData(students);
                    break;
                }
                case 2: {//2--查询学生信息

                    students = SystemOperator.foreachStudent(students);
                    break;
                }
                case 3: {//3--修改学生信息
                    students = SystemOperator.alterStudent(students);
                    //并将其保存至txt中
                    students=DataOperatorTXT.saveData(students);
                    break;
                }
                case 4: {//4--删除学生信息
                    students = SystemOperator.deleteStudent(students);
                    //并将其保存至txt中
                    students=DataOperatorTXT.saveData(students);
                    break;
                }
                default:
                    break;
            }
        }
    }
}



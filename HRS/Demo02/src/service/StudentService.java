package service;

import bean.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/4 16:57
 * @modified By：
 */
public class StudentService {
    Scanner sc = new Scanner(System.in);
    //新增
    public void addStudent(ArrayList<Student> studentList){
        System.out.println("欢迎来到新增学生信息界面");
        System.out.print("请输入新增学生姓名：");
        String stuName = sc.next();
        System.out.print("请输入新增学生身份证号码：");
        String stuID = sc.next();
        for (Student student : studentList) {
            if (student.getStudentID().equals(stuID)){
                System.out.println("学生信息重复，新增失败");
                return;
            }
        }
        System.out.print("请输入新增学生应聘岗位：");
        String stuPosition = sc.next();
        Student stu = new Student(stuName,stuID,stuPosition);
        studentList.add(stu);
        System.out.println("添加学生信息成功");
    }
    //删除
    public void delStudent(ArrayList<Student> studentList){
        System.out.println("欢迎来到删除学生信息界面");
        System.out.print("请输入要删除学生的身份证号码：");
        String stuID = sc.next();
        int f = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID().equals(stuID)){
                studentList.remove(i);
                i--;
                System.out.println("删除成功");
                f = 1;
            }
        }
//        for (Student student : studentList) {
//            if (student.getStudentID().equals(stuID)){
//                //删除集合中最后一个元素的时候会发生异常java.util.ConcurrentModificationException
//                studentList.remove(student);
//                System.out.println("删除成功");
//                f = 1;
//            }
//        }
        if (f == 0){
            System.out.println("学生不存在，删除失败");
        }
    }
    //修改
    public void modifyStudent(ArrayList<Student> studentList){
        System.out.println("欢迎来到修改学生信息的界面");
        System.out.println("请输入要修改学生信息的身份证号码");
        String stuID = sc.next();
        int f = 0;
        for (Student student : studentList) {
            if (student.getStudentID().equals(stuID)){
                System.out.print("请输入修改的学生姓名：");
                String stuName = sc.next();
                System.out.print("请输入修改的学生应聘岗位：");
                String stuPosition = sc.next();
                Student student1 = new Student(stuName,stuID,stuPosition);
                Collections.replaceAll(studentList,student,student1);
                System.out.println("修改成功");
                f = 1;
            }
        }
        if (f == 0){
            System.out.println("学生不存在，修改失败");
        }
    }
    //查看
    public void showStudent(ArrayList<Student> studentList){
        System.out.println("欢迎来到查看学生信息界面");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
    //关闭输入流
    public void close(){
        sc.close();
    }
}

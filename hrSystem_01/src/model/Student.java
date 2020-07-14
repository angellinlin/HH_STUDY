package model;
/*
    HR系统01-基于内存控制台管理系统
    hc-7/14
    学生信息类
    学生姓名
    身份证号
    毕业院校
 */

public class Student {
    public String studentName;

    public String studentId;

    public String school;

    public Student(String studentName, String studentId, String school) {

        this.studentName = studentName;

        this.studentId = studentId;

        this.school = school;
    }
}
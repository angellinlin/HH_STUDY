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
    private String sName;

    private String sId;

    private String school;



    public String getSName() {
        return sName;
    }

    public void setSName(String studentName) {
        this.sName = studentName;
    }

    public String getSId() {
        return sId;
    }

    public void setSId(String studentId) {
        this.sId = studentId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
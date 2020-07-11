package cn.swjtu.day01.Demo0709_01;

import java.util.ArrayList;

/*
题目：自定义4个学生对象，添加到集合，并遍历。
思路：
1.定义学生类Student,标准类
2.定义ArrayList集合，创建对象.add
3.遍历for循环，list.get（）

 */
public class Demo07ArrayListStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("柳成焕", 24);
        Student stu2 = new Student("李姝欣", 23);
        Student stu3 = new Student("董曲江", 25);
        Student stu4 = new Student("郭彦宏", 26);

        //添加对象
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println("姓名："+list.get(i).getName()+",年龄："+list.get(i).getAge());
        }

    }
}

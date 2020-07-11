package cn.swjtu.day01;
/*
定义一个类，用于模拟学生

属性（是什么，有什么）：姓名、学号、年龄、班级
行为（能做什么）：吃饭、睡觉、学习
对应到Java的类中

成员变量（属性）：
    String name; //姓名
    Int age;     //年龄
成员方法（行为）：
    public void eat();  //吃饭
    public void sleep(); //睡觉
    public void study(); //学习

 注意事项：
 1.成员变量是直接写在类内部中的，在方法外边。
 2.成员方法不要写static关键字。
 */
public class Student {
    String name;
    int age;

    public void eat(){
        System.out.println("吃！");
    }

    public void study(){
        System.out.println("学！");
    }
}

package cn.swjtu.day01;
/*
注意事项：
1.如果成员变量未进行赋值，那么将会有一个默认值，规则与数组一样。
整型 0
浮点型 0.0
字符型 '\u0000'
String  null
boolean false

 */
public class Demo0706UseStudentu {
    public static void main(String[] args) {
        //1.导包
        //在同一个模块中，因此不需要导包

        //2.创建对象
        Student stu=new Student();

        //3.使用成员变量
        System.out.println(stu.name);  //null
        System.out.println(stu.age);   //0

        System.out.println("======");

        //改变成员变量中数值内容
        stu.name="LCH";  //将右侧字符串赋值交给左侧成员变量
        stu.age=18;
        System.out.println(stu.name);  //LCH
        System.out.println(stu.age);   //18

        System.out.println("======");
        //4.使用成员变量的方法
        stu.eat();
        stu.study();
    }
}

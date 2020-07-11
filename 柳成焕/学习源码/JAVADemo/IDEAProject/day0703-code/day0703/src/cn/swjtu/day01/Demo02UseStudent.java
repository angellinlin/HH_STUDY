package cn.swjtu.day01;

import org.w3c.dom.ls.LSOutput;

/*
通常情况下，一个类并不能直接使用，需要根据类创建一个对象，才能使用。

1、导包：也就是指出需要使用的类，在什么位置。
import 包名称.类名称；
import cn.swjtu.day01.demo02Student;
对于和当前类属于同一个包的情况，可以省略导包语句不写。

2.创建
类名称 对象名=new 类名称（）；
Demo02Student stu=new Demo02Student();

3.使用：分为两种情况
使用成员变量：对象名.成员变量名；
使用成员方法：对象名.成员方法（）
（也就是想用谁，就用对象名点谁）
 */
public class Demo02UseStudent {

    public static void main(String[] args) {
        //1.导包
        //这里我们需要使用Demo02Student类，和当前所在类处于同一个包，因此可省略。

        //2.创建
        //类名称 对象名=new 类名称（）；
        //创建了stu对象
        Demo02Student stu = new Demo02Student();

        //3，使用成员变量
        System.out.println(stu.name);
        System.out.println(stu.age);

        stu.eat();


    }


}

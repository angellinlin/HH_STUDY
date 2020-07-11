package cn.swjtu.day01.Demo0708_04;

import java.util.Scanner;  //1.导包
/*
Scanner类的功能，可以实现键盘输入数据，到程序当中。

引用类型的一般使用步骤：
（1）导包：ipmort 包路径.类名称;
如果需要使用的目标类与当前类位于统一包下，则可省略导包语句不写。
只有Java.lang包下的内容不需要导包，其他都需要。
（2）创建：类名称 对象名=new 类名称();
（3）使用: 对象名.成员方法名();

 */
public class Demo01Scanner {
    public static void main(String[] args) {
        //2.创建
        //System.in代表从键盘输入
        Scanner sc=new Scanner(System.in);

        //3.使用
        int num=sc.nextInt();  //获取输入int数字
        System.out.println("输入的int数字是："+num);

        String str=sc.next();  //获取输入的字符串
        System.out.println("输入的字符串是："+str);
    }
}

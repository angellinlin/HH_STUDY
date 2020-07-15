package cn.swjtu.Final_day071401;
/*
final关键字代表最终、不可改变的。

常见四种用法：
1、用于修饰类
2、用于修饰一个方法
3、用于修饰一个局部变量
4、用于修饰一个成员变量


 */
public class Demo01Final {
    public static void main(String[] args) {
        int num1=10;
        System.out.println(num1);  //10
        num1=20;
        System.out.println(num1);  //20

        //一旦使用final关键字修饰局部变量，那么这个变量就不能进行更改。“一次赋值，终生不变”
        final int num2=100;
        //num2=200;  //错误！不能改变！
        // num2=100;   //错误！

        //正确写法！
        final int num3;
        num3=300;

        //对于基本类型来说，不可变说的是变量当中的数据值不可改变。
        //对于引用类型来说，不可变说的是变量当中的地址值不可改变。
        Student stu1=new Student("高圆圆");
        System.out.println(stu1);
        System.out.println(stu1.getName());
        stu1=new Student("高圆圆圆圆");
        System.out.println(stu1);
        System.out.println(stu1.getName());

        System.out.println("==============");

        final Student stu2=new Student("李斯丹妮");
        System.out.println(stu2.getName());
        //错误写法！地址值不可改变
        /*stu2=new Student("李思思思思丹妮");*/
        stu2.setName("李思思思思丹妮");
        System.out.println(stu2.getName());
    }

}

package cn.swjtu.day0710_Static;

public class MyClass {
    int num;//成员变量
    static int numStaic; //静态变量


    public void method() {
        System.out.println("这是一个成员方法！");
        System.out.println(num); //成员方法可访问成员变量
        System.out.println(numStaic);//成员方法可以访问静态变量
    }

    public static void methodStatic() {
        //System.out.println(num);  //报错！静态不能直接访问非静态
        System.out.println(numStaic);  //静态可以访问静态
        System.out.println("这是一个静态方法！");
        //静态方法中不能使用this关键字！
        //System.out.println(this);

    }
}

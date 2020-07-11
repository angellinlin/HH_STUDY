package cn.swjtu.day0710Math;

import java.util.jar.JarOutputStream;

/*
java.util,Math是数学相关的工具类，里面提供了大量的静态方法，完成与数学相关的操作。

public static double abs(double num);  获取绝对值
public static double ceil(double num); 向上取整12.1 →13
public static double floor(double num); 向下取整12.9 →12
public static long  round(double num);  四舍五入

Math.PI代表近似的圆周率常量。（double）
 */
public class Demo01Math {
    public static void main(String[] args) {
        //获取绝对值
        System.out.println(Math.abs(3.14));  //3.14
        System.out.println(Math.abs(-2));    //2
        System.out.println(Math.abs(0));     //0
        System.out.println("==================");

        //向上取整
        System.out.println(Math.ceil(3.1));  //4.0
        System.out.println(Math.ceil(3.9));  //4.0
        System.out.println(Math.ceil(-3.1));   //3.0
        System.out.println("==================");

        //向下取整，抹零
        System.out.println(Math.floor(3.99));  //3.0
        System.out.println(Math.floor(3.01));  //3.0
        System.out.println(Math.floor(-30.1));  //30.0
        System.out.println("==================");

        //四舍五入
        System.out.println(Math.round(12.4));  //12
        System.out.println(Math.round(12.5));  //13
        System.out.println("==================");

        System.out.println(Math.PI);  //近似圆周率
    }
}

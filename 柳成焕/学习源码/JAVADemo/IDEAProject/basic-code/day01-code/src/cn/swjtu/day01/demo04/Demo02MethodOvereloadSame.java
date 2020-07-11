package cn.swjtu.day01.demo04;

/*
题目要求：
比较两个数据是否相等：
参数类型分别是2个byte、2个short、2个int、2个long类型
并在main中进行测试。

方法三要素：
返回值：boolean
方法名称：isSame
参数列表：
 */
public class Demo02MethodOvereloadSame {
    public static void main(String[] args) {
       byte num1=1,num2=2;
       short num3=10,num4=10;
       int num5=55,num6=66;
       long num7=1000,num8=1000;
        System.out.println(isSame(num1,num2));
        System.out.println(isSame(num3,num4));
        System.out.println(isSame(num5,num6));
        System.out.println(isSame(num7,num8));

    }

    public static boolean isSame(byte a, byte b) {
        System.out.println("两个byte参数方法执行！");
        return a == b;
    }

    public static boolean isSame(short a, short b) {
        System.out.println("两个short参数方法执行！");
        return a == b;
    }

    public static boolean isSame(int a, int b) {
        System.out.println("两个int参数方法执行！");
        return a == b;
    }

    public static boolean isSame(long a, long b) {
        System.out.println("两个long参数方法执行！");
        return a == b;
    }

}

package cn.swjtu.day01.demo04;

/*
对于功能类似的方法，因为参数列表不一样，却需要记住那么多不同的方法名称，太麻烦！
→引用方法重载！（OverLoad）:多个方法的名称相同，参数列表不同。
好处：只需记住唯一一个方法名称，就可实现类似的多个功能。

方法重载与下列因素相关：
1.参数个数不同；
2.参数类型不同；
3.参数的多类型顺序不同。

方法重载与下列因素无关：
1.与参数名称无关；
2.与方法返回值类型无关；

 */
public class Demo04MethodOverload {
    public static void main(String[] args) {
        /*System.out.println(getSum(10,20));   //30
        System.out.println(sumThree(10,20,30)); //60
       */

        System.out.println(getSum(10, 40));
        System.out.println(getSum(10, 20, 30));
        System.out.println(getSum(10, 20, 30, 40));
        System.out.println(getSum(1.1, 2));
//        System.out.println(getSum(10,20,30,40,50));  //报错，找不到对应方法来匹配

    }

    public static int getSum(int a, int b) {
        System.out.println("有两个参数的方法执行啦！");
        return a + b;
    }

//报错，重载与参数名称无关
//    public static int getSum(int x, int y) {
//        System.out.println("有两个参数的方法执行啦！");
//        return x + y;
//    }

    //参数类型不同
    public static double getSum(double a, double b) {
        return a + b;
    }

    //参数个数不同
    public static int getSum(int a, int b, int c) {
        System.out.println("有三个参数的方法执行啦！");
        return a + b + c;
    }

    //参数的多类型顺序不同
    public static int getSum(int a, double b) {
        System.out.println("参数类型顺序不同，int在前！");
        return (int) (a + b);
    }

    public static int getSum(double a, int b) {
        System.out.println("参数类型顺序不同，double在前！");
        return (int) (a + b);
    }

    public static int getSum(int a, int b, int c, int d) {
        System.out.println("有四个参数的方法执行啦！");
        return a + b + c + d;
    }

//重载与方法的返回值类型无关
//    public static double getSum(int a, double b) {
//        return a + b;
//    }
}

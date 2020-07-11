package cn.swjtu.day01.demo02;
/*
方法可有参数，也可无参数
有参数：小括号中有内容。当一个方法需要一些数据条件才能完成任务时，就是有参数。
无参数：小括号中留空。一个方法不需要任何数据条件，自己就能独立完成任务。

 */

public class Demo03MathodParameter {
    public static void main(String[] args) {
        method1(14,13);
        method2();
    }

    //有参数
    public static void method1(int a,int b){
        int result=a*b;
        System.out.println(result);
    }

    //无参数
    public  static void method2(){
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }
}

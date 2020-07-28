package cn.swjtu.demo02.Recursion;
/*
使用递归计算阶乘。

 */
public class Demo03Recursion {
    public static void main(String[] args) {
        int result=multi(5);
        System.out.println(result);
    }

    public static int multi(int n){
        //递归的结束条件
        if(n==1){
            return 1;
        }
        //递归的目的：获取下一个被乘的数字n-1
        return n*(multi(n-1));
    }
}

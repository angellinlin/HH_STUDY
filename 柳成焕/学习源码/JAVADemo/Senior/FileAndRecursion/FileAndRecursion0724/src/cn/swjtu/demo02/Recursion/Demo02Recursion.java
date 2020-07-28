package cn.swjtu.demo02.Recursion;

/*
使用递归计算1-n之间的和。
思路：1+2+....+n，也就是n+(n-1)+(n-2)+...+2+1
已知最大值n，最小值1
使用递归必须明确：
    1、递归的结束条件 获取到1的时候结束
    2、递归的目的：获取下一个要加的数字（n-1）

 */
public class Demo02Recursion {
    public static void main(String[] args) {
        int result = sum(100);
        System.out.println(result);
    }
    public static int sum(int n) {
        //获取到1时结束
        if (n == 1) {
            return 1;
        }
        //获取下一个要加的数字（n-1）
        return n + sum(n - 1);
    }
}

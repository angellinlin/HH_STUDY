package cn.swjtu.day01.Demo0708_04;

import java.util.Scanner;

/*
题目：键盘输入三个int数字，然后求出其中最大值。

思路：
1.键盘输入：Scanner类，导包，创建，使用
2.三次键盘输入，三个int变量
3.求最大值
 */
public class Demo03ScannerMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个int数字：");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //方法一
        /*int max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }*/

        //方法2
        int temp = a > b ? a : b;
        int max = temp > c ? temp : c;

        System.out.println("最大值为：" + max);

    }
}

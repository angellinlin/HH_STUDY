package cn.swjtu.day01.Demo0708_04;

import java.util.Scanner;

/*
题目要求：键盘输入两个int数字，并求出和值。
分析：
1.键盘输入：需要Scanner类。
导包、创建、使用
2.定义两个int数字接键盘输入
3.求和

 */
public class Demo02ScannerSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数字：");
        int num2 = sc.nextInt();
        int sum = num1 + num2;
        System.out.println("数字" + num1 + "和数字" + num2 + "的和为：" + sum);

    }
}

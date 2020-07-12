package cn.com.spdb.testidea05;

import java.util.Scanner;

/*
题目1：键盘输入两个数字并求和
题目2：键盘输入三个数字求最大值
*/
public class TestScanner {
    public static void main(String[] args) {
        //题目1
        Scanner sc = new Scanner(System.in);
        System.out.println("请分别输入两个数字");
        System.out.println("数字和是" + addNum(sc.nextInt(), sc.nextInt()));
        //题目2
        System.out.println("请分别输入三个数字");
        System.out.println("最大值是" + maxNum(sc.nextInt(), sc.nextInt(), sc.nextInt()));

    }

    public static int addNum(int a, int b) {
        return a + b;
    }

    public static int maxNum(int a, int b, int c) {
        int max = a > b ? a : b;
        max = max > c ? max : c;
        return max;
    }
}

package cn.swjtu.day01.Demo0708_06;

import java.util.Random;

/*
题目要求：
根据int变量n的值，来获取随机数字，范围是[1,n]

思路：
1.变量n，随意赋值
2.随机Random，导包，创建
3.若输入为10，范围为0-9，想要的是1-10，因此整体加1。int num=r.nextInt(n)+1;  //本来范围是[0,n-1],现在是[1,n]
4.打印

 */
public class Demo03Random {
    public static void main(String[] args) {
        int n=10;
        Random r=new Random();

        for (int i = 0; i < 100; i++) {
            int num=r.nextInt(n)+1;  //本来范围是[0,n-1],现在是[1,n]
            System.out.println(num);
        }

    }
}

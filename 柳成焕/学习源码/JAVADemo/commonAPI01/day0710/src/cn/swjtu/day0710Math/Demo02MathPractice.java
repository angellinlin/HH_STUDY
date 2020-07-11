package cn.swjtu.day0710Math;

import java.util.Arrays;

/*
题目：计算在-10.8到5.9之间，绝对值大于6或者小于2.1的整数有多少个？

思路：
1.既然确定了范围，for循环
2.起点位置-10.8可用两种方法转为-10
   一是向上取整，而是强制转换
3.每一个数字都是整数，所以步进表达式应该是num++
4.如何拿到绝对值：Math.abs
5.条件判断，计数统计++

 */
public class Demo02MathPractice {
    public static void main(String[] args) {
        int count = 0;
        int min = (int) (Math.ceil(-10.8));
        int max = (int) (Math.floor(5.9));


        for (int i = min; i < max; i++) {
            int abs = Math.abs(i);
            if (abs > 6 || abs < 2.1) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("个数为：" + count);
    }
}

package cn.swjtu.day01.Demo0709_02;

import java.util.Scanner;

/*
题目：键盘输入一个字符串，并且统计其中各种字符出现的次数。
种类有：大写字母、小写字母、数字、其他。

思路：
1.键盘输入Scanner
2.定义一个字符串存键盘输入sc.next();
3.定义四个变量用于统计字符种类数
3.将字符串转为字符数字.toCharArray();
4.遍历字符数组进行判断，并对四个变量进行++动作
5.打印四个变量

 */
public class Demo09StringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();
        char[] array = str.toCharArray();
        int num1 = 0; //大写字母个数
        int num2 = 0; //小写字母个数
        int num3 = 0; //数字个数
        int num4 = 0; //其他字符个数

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                num1++;
            }else if(array[i] >= 'a' && array[i] <= 'z'){
                num2++;
            }else if(array[i] >= '0' && array[i] <= '9'){
                num3++;
            }else{
                num4++;
            }
        }

        System.out.println("大写字母个数为："+num1);
        System.out.println("小写字母个数为："+num2);
        System.out.println("数字个数为："+num3);
        System.out.println("其他字符个数为："+num4);

    }
}

package cn.swjtu.day01.Demo0708_06;

import java.util.Random;
import java.util.Scanner;

/*
题目：用代码模拟猜数字的小游戏。

思路：
1.产生一个随机数字，并且一旦产生不再变化。int num=r.nextInt(n);
2.键盘输入，用到了Scanner中的nextInt方法，获取两个数字
3.if判断两个数字：
    如果太小了，提示太小，并且重试；
    如果太大了，提示太大，并且重试；
    如果合适，游戏结束
 */
public class Demo04RandomGame {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(100)+1;  //范围[1,100]

        while (true) {
            System.out.println("请猜一个数字：");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num > n) {
                System.out.println("太大啦！游戏继续");
            } else if (num < n) {
                System.out.println("太小啦！游戏继续");
            } else {
                System.out.println("猜中啦！");
                break;  //猜中则游戏结束
            }
        }
        System.out.println("游戏结束！");
    }
}

package cn.swjtu.day01.Demo0708_06;

import java.util.Random;

/*
Random类用来生成随机数字，使用起来也是三个步骤：
1.导包 import java.util.Random;
2.创建 Random r=new Random(); //小括号留空即可
3.使用
获取随机int数字(范围是int所有范围，有正负两种)：int num=r.nextInt();
获取随机int数字（参数代表范围，左闭右开区间）： int num=r.nextInt(n);
实际上代表的含义是：[0,n),也就是0,1，……，n-1
 */
public class Demo01Random {
    public static void main(String[] args) {
        Random r = new Random();

        int num = r.nextInt();
        System.out.println("随机数是："+num);
    }
}

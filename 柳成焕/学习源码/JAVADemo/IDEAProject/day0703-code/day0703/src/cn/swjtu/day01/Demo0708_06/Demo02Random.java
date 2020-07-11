package cn.swjtu.day01.Demo0708_06;

import java.util.Random;

public class Demo02Random {
    public static void main(String[] args) {
        Random r=new Random();
        for (int i = 0; i < 100; i++) {
            int num = r.nextInt(10);  //范围是[0.10)
            System.out.println(num);
        }
    }
}

package cn.swjtu.day01.Demo0709_01;

import java.util.ArrayList;
import java.util.Random;

/*
题目：生成6个1-33之间的随机整数，添加到集合，并遍历集合。

思路：
1.随机数生成Random类，创建，使用
2.创建ArrayList集合存Integer随机数，.add  r.nexrInt(33)+1
3.遍历集合 .size()  .get()

 */
public class Demo06ArrayListRandom {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(r.nextInt(33)+1);
        }

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}

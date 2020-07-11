package cn.swjtu.day01.Demo0709_01;

import java.util.ArrayList;
import java.util.Random;

/*
题目：
用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合中。
要求使用自定义的方法实现筛选。

思路：
1.定义一个大集合和一个小集合
2.定义一个随机类Random r，大集合中存入20个随机数字listA.add  r.nextInt()
3.定义方法实现筛选,参数为ArrayList,返回值也为ArrayList
4.方法中实现奇偶判断
5.偶数存入集合中
6.返回小集合，遍历输出
 */
public class Demo09ArrayListReturn {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();    //大集合
        ArrayList<Integer> smallList=new ArrayList<>(); //小集合
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(100); //0-99
            list.add(num);
        }

        System.out.println("大集合个数为："+list.size());
        //遍历大集合
        System.out.println(list.toString());

        smallList=getSmallList(list);
        //遍历小集合
        System.out.println("小集合个数为："+smallList.size());
        System.out.println(smallList.toString());
       /* for (int i = 0; i < smallList.size(); i++) {
            System.out.print(smallList.get(i));
        }*/
    }

    //接收大集合参数，返回小集合，进行偶数筛选
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> list) {
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num % 2 == 0) {
                smallList.add(num);
            }
        }
        return smallList;
    }

}

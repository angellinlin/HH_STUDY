package cn.swjtu.day01.Demo0709_01;

import java.util.ArrayList;

/*
题目2：定义以指定格式打印集合的方法（ArrayList作为参数），使用{}括起集合，使用@作为分隔符。

思路：
1.定义一个ArrayList<Integer>
2.定义一个方法printArrayList(ArrayList list)
3.方法中获取每个元素，并用@分隔
 */
public class Demo08ArrayListPrint {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

        printArrayList(list);

    }

    public static void printArrayList(ArrayList<Integer> list){
        System.out.print("{");
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i)+"@");
        }
        System.out.println(list.get(list.size()-1)+"}");  //最后一个元素
    }
}

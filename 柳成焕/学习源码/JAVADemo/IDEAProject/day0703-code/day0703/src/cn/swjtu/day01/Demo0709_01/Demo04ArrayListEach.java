package cn.swjtu.day01.Demo0709_01;

import java.util.ArrayList;

/*
遍历集合
 */
public class Demo04ArrayListEach {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        boolean success = list.add("胖胖的山头");
        list.add("滇西小哥");
        list.add("李子柒");
        list.add("鹏程哥你行不行啊");
        list.add("喝易拉罐要用吸管啊");

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

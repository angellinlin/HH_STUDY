package cn.swjtu.day01.Demo0709_01;

import java.util.ArrayList;

/*
ArrayList中的常用方法：
public boolean add(E e);  //向集合中添加元素，参数类型与泛型一致，返回值代表添加是否成功。
备注：对于ArrayList集合来说，add添加动作一定是成功的，所以返回值可用可不用。
但是对于其他集合来说，add添加动作不一定成功。

public E get(int index);  //从集合中获取元素，参数是索引编号，返回值就是对应位置的元素

public E remove(int index);//从集合中删除元素，参数是索引编号，返回值是被删除掉的元素

public int size();         //获取集合的尺寸长度，返回值是集合中包含的元素个数。

 */
public class Demo03ArrayListMethod {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list); //[]

        //向集合中添加元素 add
        boolean success = list.add("胖胖的山头");
        System.out.println("添加动作是否成功" + success);  //true
        System.out.println(list);     //[胖胖的山头]

        list.add("滇西小哥");
        list.add("李子柒");
        list.add("鹏程哥你行不行啊");
        list.add("喝易拉罐要用吸管啊");
        System.out.println(list);  //[胖胖的山头, 滇西小哥, 李子柒, 鹏程哥你行不行啊, 喝易拉罐要用吸管啊]

        //从集合中获取元素，get，索引值从0开始
        String name = list.get(2);
        System.out.println("第2号索引位置：" + name); //李子柒

        //从集合中删除元素
        String whoRemoved = list.remove(4);
        System.out.println("被删除的元素是："+whoRemoved);  //喝易拉罐要用吸管
        System.out.println(list);  //[胖胖的山头, 滇西小哥, 李子柒, 鹏程哥你行不行啊]

        //获取集合的元素个数
        int size=list.size();
        System.out.println("集合的长度是："+size);  //4

    }
}

package cn.swjtu.day01.Demo0709_01;

import java.util.ArrayList;

/*
数组的长度不可变，但是ArrayList集合的长度是可变的。
对于ArrayList来说，有一个<E>，代表泛型。
泛型，也就是装在集合中的所有元素，全都是统一的什么类型。
注意：泛型只能是引用类型，不能是基本类型。

注意事项：
对于ArrayList来说，直接发音得到的不是地址值，而是内容。
如果内容是空，得到的是空的中括号：[]
 */
public class Demo02ArrayList {
    public static void main(String[] args) {
        //创建了一个ArrayList集合叫list，里面存放的是String类型的字符串数据。
        //备注：从JDK 1.7+开始，右侧的尖括号内可不写内容，但本身左边<>还是要写的
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);  // []

        //向集合中添加一些数据，add
        list.add("123");
        System.out.println(list);  //[123]

        list.add("迪丽热巴");
        list.add("古力娜扎");
        System.out.println(list);  //[123, 迪丽热巴, 古力娜扎]
        //list.add(100);  //报错
    }
}

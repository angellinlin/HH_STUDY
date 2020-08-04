package cn.swjtu.demo01.Stream;

import java.util.ArrayList;
import java.util.List;

/*
使用Stream流的方式，遍历集合，对集合中的数据进行过滤。
Stream流是JDK1.8之后出现的，关注的是做什么，而不是怎么做。
 */
public class Demo02Stream {
    public static void main(String[] args) {
        //创建一个List集合，存储姓名
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张丽");
        list.add("李四");
        list.add("张无忌");
        list.add("周芷若");
        //遍历元素，将以“张”开头的元素，存储到新集合中
        //遍历元素,只要姓名长度为3的人
        //遍历元素,打印输出
        list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .forEach(name -> System.out.println(name));
    }
}

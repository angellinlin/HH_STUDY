package cn.swjtu.demo01.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
4、count方法：用于统计Stream流中元素个数：
long count​()； 是一个终结方法，返回值是long类型的整数，所以不能再继续调用Stream中的其他方法了。
 */
public class Demo07Stream_count {
    public static void main(String[] args) {
        //获取一个Stream流
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println(count);  //5
    }
}

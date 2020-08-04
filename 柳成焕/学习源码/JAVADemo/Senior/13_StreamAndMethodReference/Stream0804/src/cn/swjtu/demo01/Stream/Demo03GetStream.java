package cn.swjtu.demo01.Stream;

import java.util.*;
import java.util.stream.Stream;

/*
java.util.stream.Stream<T>是Java8新加入的最常用的接口。（这并不是一个函数式接口）
获取一个流非常简单，主要有以下方式。
1、所有的Collection集合都可以通过stream默认方法获取流；
default stream<E> stream()
2、Stream接口的静态方法of可以获取数组对象的流。
static <T> Stream<T> of(T...value)
参数是一个可变参数，那我们可以传递一个数组。
 */
public class Demo03GetStream {
    public static void main(String[] args) {
        //把集合转换为Stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = list.stream();

        Map<String, String> map = new HashMap<>();
        //获取键，把键存储到set集合中
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();
        //获取值，存储到Collection集合中
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();
        //获取键值对，（键与值的映射关系entrySet）
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();

        //把数组转为Stream流
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5);
        //可变参数可以传递数组
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Stream<Integer> stream7 = Stream.of(arr1);
        String[] arr2 = {"aaa", "bbbb", "cccc"};
        Stream<String> stream8 = Stream.of(arr2);

    }
}

package cn.swjtu.demo01.Stream;

import java.util.stream.Stream;

/*
2、Stream常用方法filter：用于对数据进行过滤
Stream<T> filter​(Predicate<? super T> predicate)
参数是一个函数式接口Predicate，所以可以传递lambda表达式，对数据进行过滤。
Predicate中的抽象方法：boolean test(T t)

Stream流属于管道流，只能被消费（使用）一次
第一个Stream流调用完毕后，数据就会流转到下一个Stream流上。
而这时第一个Stream流已经使用完毕，就会关闭了，所以第一个Stream流不能再调用方法了。
IllegalStateException: stream has already been operated upon or closed
 */
public class Demo05Stream_filter {
    public static void main(String[] args) {
        //创建一个Stream流
        Stream<String> stream01 = Stream.of("凯", "庄周", "阿珂", "王昭君", "芈月", "张飞", "张无忌");
        //对流中的元素进行过滤,只要姓张的
        Stream<String> stream02 = stream01.filter((String name) -> {
            return name.startsWith("张");
        });
        //遍历集合输出
        stream02.forEach((name) -> System.out.println(name));
    }

}

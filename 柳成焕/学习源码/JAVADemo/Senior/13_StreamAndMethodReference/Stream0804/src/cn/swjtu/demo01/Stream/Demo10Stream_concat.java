package cn.swjtu.demo01.Stream;

import java.util.stream.Stream;

/*
7、concat​方法：用于把流组合到一起。
如果有两个流，希望合并为一个流，那么就可以使用Stream接口的静态方法concat。
static <T> Stream<T> concat​(Stream<? extends T> a, Stream<? extends T> b)
 */
public class Demo10Stream_concat {
    public static void main(String[] args) {
        //创建2个Stream流
        Stream<String> stream01 = Stream.of("王昭君", "芈月", "张飞", "张无忌");
        String[] arr = {"喜羊羊", "懒羊羊", "红太狼", "灰太狼"};
        Stream<String> stream02 = Stream.of(arr);
        //把以上两个流组合为一个流
        Stream<String> concat = Stream.concat(stream01, stream02);
        //遍历concat流
        concat.forEach((s)-> System.out.println(s));
    }
}

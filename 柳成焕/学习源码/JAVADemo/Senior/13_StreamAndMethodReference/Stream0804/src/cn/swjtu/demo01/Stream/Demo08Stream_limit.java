package cn.swjtu.demo01.Stream;

import java.util.stream.Stream;

/*
5、limit方法：用于截取流中的元素。
对流进行截取，值取用前n个。
Stream<T> limit​(long maxSize) 参数是一个long型，如果集合当前长度大于参数则进行截取，否则不进行操作。
是一个延迟方法，只是对流中的元素进行截取，返回的是一个新的流，所以可以继续调用Stream流中其他方法。
 */
public class Demo08Stream_limit {
    public static void main(String[] args) {
        //获取Stream流
        String[] arr = {"喜羊羊", "懒羊羊", "红太狼", "灰太狼"};
        Stream<String> stream = Stream.of(arr);
        //使用limit方法对流进行截取，只要前两个元素
        Stream<String> stream2 = stream.limit(2);
        //遍历stream2
        stream2.forEach((s -> System.out.println(s))); //喜羊羊  懒羊羊
    }
}

package cn.swjtu.demo01.Stream;

import java.util.stream.Stream;

/*
6、skip：用于跳过前几个元素。
如果希望跳过几个元素，可以使用skip方法获取一个截取后的新流。
Stream<T> skip​(long n)
如果流的当前长度大于n,则跳过前n个；佛足额会得到一个长度为0的空流。
 */
public class Demo09Stream_skip {
    public static void main(String[] args) {
        //获取Stream流
        String[] arr = {"喜羊羊", "懒羊羊", "红太狼", "灰太狼"};
        Stream<String> stream = Stream.of(arr);
        //使用skip方法跳过前2个元素
        Stream<String> stream2 = stream.skip(2);
        //遍历stream2
        stream2.forEach((s -> System.out.println(s))); //红太狼 灰太狼
    }

}

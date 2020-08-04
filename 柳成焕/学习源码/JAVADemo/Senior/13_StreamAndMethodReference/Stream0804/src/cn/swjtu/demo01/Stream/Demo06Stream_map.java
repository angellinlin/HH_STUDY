package cn.swjtu.demo01.Stream;
/*
3、Stream流常用方法map:将流中的元素映射到另一个流中。
<R> Stream<R> map​(Function<? super T,? extends R> mapper)
该接口需要一个Function函数式接口，可以将当前的T类型转为R类型。
Function中抽象方法：R apply(T t);
 */

import java.util.stream.Stream;

public class Demo06Stream_map {
    public static void main(String[] args) {
        //获取一个流
        Stream<String> stream1 = Stream.of("111", "222", "333", "444");
        //使用map方法将字符串类型整数映射为Integer类型的整数
        Stream<Integer> stream2 = stream1.map((String s) -> {
            return Integer.parseInt(s);
        });
        //遍历输出stream2
        stream2.forEach((in)-> System.out.println(in));
    }
}

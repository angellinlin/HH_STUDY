package cn.swjtu.demo01.Stream;

import java.util.stream.Stream;

/*
1、Stream流中的常用方法foreach
void forEach​(Consumer<? super T> action):该方法接收一个Consumer接口函数，会将每一个流元素交给函数进行处理。
Consumer接口是一个消费型的函数式接口，可以传递lambda表达式，消费数据。
简单记：forEach方法，用来遍历流中的数据，是一个终结方法，遍历后就不能继续调用Stream流的其他方法。
 */
public class Demo04Stream_foreach {
    public static void main(String[] args) {
        //获取一个Stream流
        Stream<String> stream = Stream.of("王昭君", "孙尚香", "芈月", "庄周");
        //使用forEach方法遍历流中的数据
       /* stream.forEach((String name) -> {
            System.out.println(name);
        });*/
        stream.forEach((name) -> System.out.println(name));
    }
}

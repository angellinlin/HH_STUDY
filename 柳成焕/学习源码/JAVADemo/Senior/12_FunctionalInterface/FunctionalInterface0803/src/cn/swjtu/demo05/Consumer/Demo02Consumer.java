package cn.swjtu.demo05.Consumer;

import java.util.function.Consumer;

/*
Consumer接口是一个消费型接口，泛型指定什么类型，就可以使用accept方法消费什么类型的数据。
至于怎么消费（使用）数据，需要自定义（输出，计算等）
 */
public class Demo02Consumer {
    //定义一个方法，参数传递字符串的姓名，参数传递Consumer接口消费字符串的姓名
    public static void method(String name, Consumer<String> com) {
        com.accept(name);
    }
    public static void main(String[] args) {
        method("孙尚香", (String name) -> {
            //对传递的字符串进行消费
            //消费方式1：直接输出字符串
            System.out.println(name);
            //消费方式2：把字符串进行反转输出
            String reName = new StringBuffer(name).reverse().toString();
            System.out.println(reName);
        });
    }
}

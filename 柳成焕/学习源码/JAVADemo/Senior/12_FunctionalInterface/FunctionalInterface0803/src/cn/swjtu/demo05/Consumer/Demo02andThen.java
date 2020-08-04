package cn.swjtu.demo05.Consumer;

import java.util.function.Consumer;

/*
作用：需要两个Consumer接口，可以把两个Consumer接口组合在一起，再对数据进行消费。
例如
Consumer<String>con1
Consumer<String>con2
String s="hello";
com1.accept(s);
com2.accept(s);

用andThen优化：连接两个Consumer接口，再进行消费
con1.andThen(con2).accept(s);谁写前边，谁先进行消费
 */
public class Demo02andThen {
    //定义一个方法，参数传递一个字符串和两个Consumer接口，Consumer接口的泛型使用Sting
    public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
       /* con1.accept(s);
        con2.accept(s);*/
        //使用andThen方法优化  与上面等同
        con1.andThen(con2).accept(s);  //con1先消费，con2后消费
    }
    public static void main(String[] args) {
        //调用method方法，传递一个字符串，两个lambda表达式
        method("hello",
                (String s) -> {
                    //con1的消费方式：转换为大写输出
                    System.out.println(s.toUpperCase());
                },
                (String s) -> {
                    //con2的消费方式，反转
                    String name=new StringBuffer(s).reverse().toString();
                    System.out.println(name);
                });
    }
}

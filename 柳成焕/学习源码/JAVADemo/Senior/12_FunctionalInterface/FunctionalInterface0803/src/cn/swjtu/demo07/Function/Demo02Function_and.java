package cn.swjtu.demo07.Function;

import java.util.function.Function;

/*
Function接口中的默认方法andThen：用来进行组合操作。
需求：
把String类型的“123”Integer类型，再把转换后的结果加10
把增加之后的Integer类型的数据，转换为String类型。

分析：一共转换了两次，
1、第一次是把String类型转为Integer类型，可用Function<String,Integer>
Integer in=fun1..apply("123")+10
2、第二次是把Integer类型转为String类型，Function<Integer,String>
String s=fun2.apply(in);

我们可以使用andThen方法，把两次转换组合在一起，
String s=fun1.andTen(fun2).apply("123");
执行顺序：fun1先调用apply将字符串转为Integer类型，fun2再调用apply将Integer类型转为String。
 */
public class Demo02Function_and {
    public static void change(String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        s = fun1.andThen(fun2).apply(s);
        System.out.println(s);
    }
    public static void main(String[] args) {
        String s = "123";
        /*change(s, (String str) -> {
                    //把String类型的“123”Integer类型，再把转换后的结果加10
                    return Integer.parseInt(str) + 10;
                },
                (Integer in) -> {
                    //第二次是把Integer类型转为String类型，Function<Integer,String>
                    return (in + "");
                });*/
        //优化lambda
        change(s, (str) ->  Integer.parseInt(str) + 10 , (in) -> in + "");
    }
}

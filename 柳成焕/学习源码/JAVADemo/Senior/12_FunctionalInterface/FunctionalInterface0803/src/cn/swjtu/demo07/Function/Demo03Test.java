package cn.swjtu.demo07.Function;

import java.util.function.Function;

/*
分析：
1、Function<String,String>  "孙尚香,20"  -->"20"
2、Function<String,Integer>  "20"     -->  20
3、Function<Integer,Integer>  20   -->120
 */
public class Demo03Test {
    //定义一个方法，传递一个字符串，3个Function接口
    public static void method(String s, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer, Integer> fun3) {
        Integer age = fun1.andThen(fun2).andThen(fun3).apply(s);
        System.out.println(age);
    }

    public static void main(String[] args) {
        String s = "孙尚香,20";
       /* method(s,
                (String str1) -> {
                    return str1.split(",")[1];
                },
                (String str2) -> {
                    return Integer.parseInt(str2);
                },
                (Integer in) -> {
                    return in + 100;
                });*/
        //简化lambda
        method(s, (str1) -> str1.split(",")[1], (str2) -> Integer.parseInt(str2), (in) -> in + 100);
    }
}

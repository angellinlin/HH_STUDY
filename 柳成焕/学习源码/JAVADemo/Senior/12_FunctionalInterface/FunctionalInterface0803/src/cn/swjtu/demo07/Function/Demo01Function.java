package cn.swjtu.demo07.Function;

import java.util.function.Function;

/*
java.util.function.Function<T,R>接口，用来根据一个类型的数据，得到另一个类型的数据。
前者称为前置条件，后者称为后置条件。
Function接口中最主要的抽象方法为R apply(T t),根据T的参数获取R类型的参数。
使用场景如：String类型转为Integer类型。
 */
public class Demo01Function {
    /*定义一个方法，传递1个字符串类型的整数，1个Function类型的接口
    使用Function接口中的apply，把字符串转为integer*/
    public static void change(String s, Function<String, Integer> fun) {
        //Integer in = fun.apply(s);
        int in = fun.apply(s);//自动拆箱
        System.out.println(in);
    }
    public static void main(String[] args) {
        String s = "123";
        /*change(s,(String str)->{
            //把字符串转为Integer整数输出
            return Integer.parseInt(str);
        });*/
        //简化lambda
        change(s, (str) -> Integer.parseInt(str));
    }

}

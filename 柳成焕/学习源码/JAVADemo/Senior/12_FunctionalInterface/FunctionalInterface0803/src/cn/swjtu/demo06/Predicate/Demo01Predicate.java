package cn.swjtu.demo06.Predicate;

import java.util.function.Predicate;

/*
Predicate<T>接口：
作用：对某种数据类型进行判断，从而得到一个boolean值。
抽象方法：boolean test(T t):用来毒地指定数据类型的数据进行判断的方法
结果：符合条件，true;不符合条件：false。
 */
public class Demo01Predicate {
    //定义一个方法，传递String字符串，1个Predicate接口，使用test方法对字符串进行判断，并将结果返回
    public static boolean check(String s, Predicate<String> prep) {
        return prep.test(s);
    }
    public static void main(String[] args) {
        String s = "hello1";
        /*boolean b = check(s, (String str) -> {
            //对参数传递的字符串进行判断，判断字符串的长度是否大于5
            return str.length()>5;
        });*/
        //优化lambda表达式
        boolean b = check(s, (str) -> str.length()>5);
            //对参数传递的字符串进行判断，判断字符串的长度是否大于5
        System.out.println(b);
    }
}

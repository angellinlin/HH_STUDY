package cn.swjtu.demo06.Predicate;

import java.util.function.Predicate;

/*
需求：判断一个字符串，有两个判断的条件
1、字符串的长度是否大于5
2、字符串中是否包含a
要求满足一个条件即可，就可以使用||运算符连接两个条件。

Predicate接口中有一个方法or，表示或关系，也可以用于连接两个判断条件。
方法内部的两个判断条件也是使用||运算符连接起来的。
 */
public class Demo03Predicate_or {
    //定义一个方法，传递1个字符串，传递2个Predicate接口，一个用于判断字符串长度，一个用于判断是否包含a
    //满足一个条件即可
    public static boolean checkString(String s, Predicate<String> prep1, Predicate<String> prep2) {
        //return prep1.test(s) || prep2.test(s);
       return prep1.or(prep2).test(s); //与上一行等价
    }
    public static void main(String[] args) {
        String s = "defg";
       /* boolean b = checkString(s,
                (String str) -> {
                    //字符串的长度是否大于5
                    return str.length() > 5;
                },
                (String str) -> {
                    //字符串中是否包含a
                    return str.contains("a");
                });*/
        //简化lambda
        boolean b = checkString(s, (str) -> str.length() > 5, (str) -> str.contains("a"));
        System.out.println(b);
    }
}

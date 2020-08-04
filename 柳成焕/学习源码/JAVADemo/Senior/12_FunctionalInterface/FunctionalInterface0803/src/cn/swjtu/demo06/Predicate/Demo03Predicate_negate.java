package cn.swjtu.demo06.Predicate;

import java.util.function.Predicate;

/*
需求：判断一个字符串，字符串的长度是否大于5
大于5，返回false;不大于5，返回true
所以我们可以使用取反符号对判断结果进行取反

Predicate接口中有一个方法negate，表示取反。
 */
public class Demo03Predicate_negate {
    //定义一个方法，传递1个字符串，传递1个Predicate接口，一个用于判断字符串长度
    //满足一个条件即可
    public static boolean checkString(String s, Predicate<String> prep) {
        //return !(prep.test(s));
        return prep.negate().test(s);
    }
    public static void main(String[] args) {
        String s = "defg";
        boolean b = checkString(s,
                (String str) -> {
                    //字符串的长度是否大于5
                    return str.length() > 5;   //这里为什么不需要取反呢？？
                });
        System.out.println(b);
    }
}

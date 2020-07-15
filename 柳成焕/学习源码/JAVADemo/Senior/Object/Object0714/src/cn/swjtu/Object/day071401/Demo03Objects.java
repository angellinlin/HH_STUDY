package cn.swjtu.Object.day071401;

import java.util.Objects;

/*
Objects类中的equals方法，也是对两个对象进行比较，防止空指针异常
 public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
 */
public class Demo03Objects {
    public static void main(String[] args) {
        /*String s1="abc";*/
        String s1=null;
        String s2="ABC";
        //boolean b=s1.equals(s2);  //NullPointerException null是不能调用方法的，否则会出现空指针异常
        boolean b2 =Objects.equals(s1,s2);
        System.out.println(b2);  //false
    }
}

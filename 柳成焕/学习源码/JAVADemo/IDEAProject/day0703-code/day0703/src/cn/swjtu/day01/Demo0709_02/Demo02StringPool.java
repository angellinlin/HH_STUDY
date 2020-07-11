package cn.swjtu.day01.Demo0709_02;
/*
字符串常量池，程序中直接写上的双引号字符串，就在字符串常量池中。

对于基本类型来说，==是进行数值比较。
对于引用类型来说，==是进行【地址值】的比较。


 */
public class Demo02StringPool {
    public static void main(String[] args) {
        String str1="abc";
        String str2="abc";

        char[] charArr={'a','b','c'};
        String str3=new String(charArr);

        System.out.println(str1==str2);  //true
        System.out.println(str1==str3);  //false
        System.out.println(str3==str2);  //false


    }
}

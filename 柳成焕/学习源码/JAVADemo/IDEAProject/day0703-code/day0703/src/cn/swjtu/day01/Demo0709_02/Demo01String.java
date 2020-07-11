package cn.swjtu.day01.Demo0709_02;
/*
java.lang.String类代表字符串
API中说，Java程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
其实就是说，程序中所有的双引号字符串，都是String类的对象（就算没有new，也照样是）

字符串的特点：
1.字符串的内容永不可变【重点】 ---字符串是常量；它们的值在创建之后不能更改。
2.正是因为字符串不可改变，所以字符串是可共享使用的。
3.字符串效果上相当于是char[]字符数组。但是底层原理是byte[]字节数组。

创建字符串的常见3+1方式：
三种构造方法:
public String();  //创建一个空白字符串，没有任何内容
public String(char[] array);  //根据字符数组的内容，来创建对应的字符串
public String(byte[] array);  //根据字节数组的内容，来创建对应的字符串
一种直接创建:
String str="Hello";
注意：直接写上双引号，就是字符串对象！
 */
public class Demo01String {
    public static void main(String[] args) {
        //首先使用空参构造
        String str1=new String(); //小括号留空，说明字符串什么内容都没有
        System.out.println("第一个字符串的内容："+str1);  //第一个字符串的内容：

        //根据字符数组创建字符串
        char[] array={'a','b','c','d'};
        String str2=new String(array);
        System.out.println("第二个字符串的内容："+str2); //第二个字符串的内容：abcd

        //根据字节数组创建字符串
        byte[] byteArr={97,98,99,100};
        String str3=new String(byteArr);
        System.out.println("第三个字符串的内容："+str3);  //第三个字符串的内容：abcd

        //直接创建
        String str4="Hello";
        System.out.println("第四个字符串的内容："+str4);   //第四个字符串的内容：Hello
    }
}

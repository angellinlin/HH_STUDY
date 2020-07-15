package cn.swjtu.StringBuilder_day0715;
/*
public StringBuilder()构造一个其中不带字符的字符串生成器，初始容量为 16 个字符。
public StringBuilder(String str)构造一个字符串生成器，并初始化为指定的字符串内容。
 */
public class Demo01StringBuilder {
    public static void main(String[] args) {
        StringBuilder build1=new StringBuilder();
        System.out.println("build1:"+build1);

        StringBuilder build2=new StringBuilder("abc");
        System.out.println("build2:"+build2);
    }
}

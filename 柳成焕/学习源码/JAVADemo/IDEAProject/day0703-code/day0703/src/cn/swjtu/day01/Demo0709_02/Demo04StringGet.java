package cn.swjtu.day01.Demo0709_02;

/*
String中与获取相关的常用方法
public int length();  获取字符串中含有的字符个数，拿到字符串长度。
public String concat(String str);  将当前字符串和参数字符串拼接成为返回值新的字符串。
public char charAt(int index);   获取指定索引为止的单个字符，索引从0开始
public int indexOf(String str); 查找参数字符串在本字符串中首次出现的索引位置，如果没有返回值则返回-1.


 */
public class Demo04StringGet {
    public static void main(String[] args) {
        //获取字符串长度
        int length = "snfdhjskafhuslfhanbsjafhs".length();
        System.out.println("字符串长度是：" + length);

        //拼接字符串（字符串一旦创建，内容不可改变）
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1.concat(str2);
        System.out.println(str1); //原封不动Hello
        System.out.println(str2); //原封不动World
        System.out.println(str3); //新的字符串HelloWorld
        System.out.println("----------------");

        //获取指定索引位置的单个字符
        char c = "hello".charAt(4);
        System.out.println("在4号索引位置的字符是：" + c);  //o
        System.out.println("----------------");

        //查找参数字符串在本来字符串中出现的第一次索引位置
        String original = "HelloWorldHelloWorld";
        int index = original.indexOf("llo");
        System.out.println(index);   //2
        System.out.println("HelloWorldHelloWorld".indexOf("abc")); //-1
    }
}

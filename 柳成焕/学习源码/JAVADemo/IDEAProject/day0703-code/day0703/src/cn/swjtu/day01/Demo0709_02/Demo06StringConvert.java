package cn.swjtu.day01.Demo0709_02;

/*
String中与转换相关的常用方法：
public char[] toCharArray(); 将当前字符串拆分成字符数组作为返回值。
public byte[] getBytes();    获得当前字符串底层的字节数组
public String replace(CharSequence olsString,CharSequence newString);
将所有出现的老字符串替换成为新的字符串，返回替换之后的结果新字符串。
备注：CharSequence意思就是说可以接受字符串类型。

 */
public class Demo06StringConvert {
    public static void main(String[] args) {
        char[] charArr = "Hello".toCharArray();
        System.out.println(charArr[0]);     //H
        System.out.println(charArr.length); //5

        //转换成为字节数组
        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]); //97 98 99
        }

        System.out.println("==============");

        //字符串的内容替换
        String str1 = "How Are You?";
        String str2 = str1.replace("o", "*");
        System.out.println(str1); //How Are You?
        System.out.println(str2); //H*w Are Y*u?

        String lang1 = "会不会玩儿啊，你大爷的！你大爷的！你大爷的！";
        String lang2 = lang1.replace("大爷", "**");
        System.out.println(lang1); //会不会玩儿啊，你大爷的！你大爷的！你大爷的!
        System.out.println(lang2);//会不会玩儿啊，你**的！你**的！你**的！
    }
}

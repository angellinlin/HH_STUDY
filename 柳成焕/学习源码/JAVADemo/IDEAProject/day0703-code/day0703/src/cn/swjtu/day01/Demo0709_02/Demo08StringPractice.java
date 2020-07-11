package cn.swjtu.day01.Demo0709_02;

/*
题目：
定义一个方法，把数组[1,2,3]按照指定格式拼接成一个字符串，格式参照如下：
[word1#word2#word3]

思路：
1.int数组
2.方法，
三要素
返回值String
方法名称fromArrayToString
参数列表int[]
3.[word1#word2#word3]
用到：for循环、字符串拼接、每个元素前有一个word，分隔符用#，区分是否为最后一个
4.调用方法，打印字符串

 */
public class Demo08StringPractice {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(fromArrayToString(array));
    }

    public static String fromArrayToString(int[] array) {
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {  //最后一个元素
                str += "word" + array[i] + "]";
            } else {
                str += "word" + array[i] + "#";
            }
        }
        return str;
    }
}

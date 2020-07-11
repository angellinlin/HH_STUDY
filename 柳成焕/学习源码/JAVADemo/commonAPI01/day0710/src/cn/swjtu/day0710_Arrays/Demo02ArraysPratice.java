package cn.swjtu.day0710_Arrays;

import java.util.Arrays;
import java.util.Random;

/*
请使用Arrays相关的API，将一个随机字符串中的所有字符升序排列，并倒序打印。

思路：
1.升序排列 Arrays.sort(数组)
2.将字符串转为字符数组str.toCharArray()

 */
public class Demo02ArraysPratice {
    public static void main(String[] args) {
        String str = "djhhfdsuguagnvkanvgad";
        char[] array = str.toCharArray();  //字符串转为字符数组
        Arrays.sort(array);                //升序排列
        //倒序遍历 .forr
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

}

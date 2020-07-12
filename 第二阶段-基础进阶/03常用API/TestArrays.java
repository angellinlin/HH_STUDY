package cn.com.spdb.testidea05;

import java.util.Arrays;

public class TestArrays {
    public static void main(String[] args) {
        int[] scores1 = new int[]{50,15,25};
        String str = Arrays.toString(scores1);
        System.out.println(str);

        //错误写法，没有返回值
        //int[] scores2 = Arrays.sort(scores1);
        Arrays.sort(scores1);
        String str1 = Arrays.toString(scores1);
        System.out.println(str1);

        //将随机排列的字符串升序排列，并倒序打印
        String str3 = "asdfakgygerallsf";
        //先变成字符数组
        char[] chars = str3.toCharArray();
        //升序排列
        Arrays.sort(chars);
        //倒序打印
        for (int i = chars.length-1; i >=0; i--) {
            System.out.print(chars[i]+" ");
        }
    }
}

package cn.swjtu.Map_day071705;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
练习：计算一个字符串中每个字符出现的次数
思路：
1.用Scanner类获取输入的字符串
2.字符不能重复，个数可以重复，因此使用HashMap<Charcter,Interger>
4.遍历字符串，获取每个字符
5.遍历：字符串转为字符toCharArray;或者用length()+charAt()
6.使用Map集合中的方法判断字符是否包含：containsKey,true则获取value，++，false则将（字符，1）添加到集合中
  使用集合的get方法，null说明key不存在，否则存在。
 */
public class DemoMapPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();

        //定义一个HashMap集合
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) != null) {  //集合中包含该元素，则获取
                Integer value = map.get(array[i]);
                value++;
                map.put(array[i], value);
            } else {
                map.put(array[i], 1);
            }
        }

        //遍历输出
        Set<Character> set = map.keySet();
        for (Character key : set) {
            Integer value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }

}


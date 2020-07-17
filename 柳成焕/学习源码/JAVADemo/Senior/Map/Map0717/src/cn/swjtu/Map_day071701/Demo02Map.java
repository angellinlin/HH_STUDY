package cn.swjtu.Map_day071701;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map集合遍历：
第一种方式：键找值
 Set<K> keySet() 键找值，实现步骤：
    1.把Map集合找那个所有的key取出来存储到一个Set集合中；
    2.使用迭代器/增强for遍历Set集合，获取Map集合中的每一个key；
    3.使用Map集合的方法get(key)获取value。

 */
public class Demo02Map {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("小乔", 158);
        map.put("大乔", 165);
        map.put("貂蝉", 168);
        map.put("王昭君", 170);
        System.out.println(map);

        //遍历方式1
        Set<String> set = map.keySet(); //将key取出存储到set集合中
        Iterator<String> it = set.iterator();//使用迭代器遍历键
        while (it.hasNext()) {
            String key = it.next();
            Integer value = map.get(key);//使用get方法获取值
            System.out.println(key+"="+value);
        }

        System.out.println("=========");
        //使用增强for遍历键
        for (String key : set) {
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
    }

}

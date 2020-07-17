package cn.swjtu.Map_day071701;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Map集合的第二种遍历方式：
Map.Entry<K,V>:在Map接口中有一个内部接口Entry
作用：当Map集合一创建，就会在Map集合中创建一个Entry对象，用来记录键与值（键值对对象，键与值的映射关系）
Set<Map.Entry<K,V>> entrySet() 实现步骤：
    1.使用Map集合中的entrySet()方法，把Map集合内部的多个Entry对象取出来存储到一个Set集合中；
    2.遍历Set集合中的每一个Entry对象；
    3.Entry对象中的方法：getKey()获取key，getValue()获取value
 */
public class Demo03EntryMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("小乔", 158);
        map.put("大乔", 165);
        map.put("貂蝉", 168);
        map.put("王昭君", 170);
        System.out.println(map);

        //创建集合存储entry对象
        Set<Map.Entry<String,Integer>> set=map.entrySet();
        //遍历set集合
        Iterator<Map.Entry<String, Integer>> it=set.iterator();
        while (it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            String key=entry.getKey();
            Integer value=entry.getValue();
            System.out.println(key+"="+value);
        }

        System.out.println("==========");
        for (Map.Entry<String, Integer> entry : set) {
            String key=entry.getKey();
            Integer value=entry.getValue();
            System.out.println(key+"="+value);
        }



    }

}

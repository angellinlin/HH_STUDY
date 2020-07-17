package cn.swjtu.Map_day071703;
/*
java.util.LinkedHashMap<K,V> extends HashMap<k,v>
    Map接口的哈希表和链接列表实现，具有可预知的迭代顺序。
    底层原理：哈希表+链表（记录元素顺序）

 */

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Demo01LinkedHashMap {
    public static void main(String[] args) {
        HashMap<String,String>map=new HashMap<>();//key不允许重复，无序
        map.put("d","d");
        map.put("a","a");
        map.put("c","c");
        map.put("b","b");
        map.put("a","d");
        System.out.println(map);//{a=d, b=b, c=c, d=d}

        LinkedHashMap<String,String> linkedMap=new LinkedHashMap<>();//key不允许重复，有序
        linkedMap.put("d","d");
        linkedMap.put("a","a");
        linkedMap.put("c","c");
        linkedMap.put("b","b");
        linkedMap.put("a","d");
        System.out.println(linkedMap); //{d=d, a=d, c=c, b=b}
    }
}

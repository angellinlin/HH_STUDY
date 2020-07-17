package cn.swjtu.Map_day071701;

import java.util.HashMap;
import java.util.Map;

/*
java.util Map<K,V>集合
特点：
    1.Map集合是一个双列集合，一个元素包含两个值（一个key，一个value）;
    2.Map集合中的元素，key和value的数据类型可以相同，也可以不同；
    3.key不允许重复，value可以重复。
    4.key和value是一一对应的。

java.util.HashMap<k,v>集合 implements Map<k,v>接口
特点：
    1.HashMap集合底层是哈希表：查询速度非常快。
        JDK1.8之前：数组+单向链表
        JDK1.8之后：数组+单向链表/红黑树（链表长度超过8）：提高查询速度
     2.HashMap集合是一个无序的集合，存储元素和取出元素的顺序有可能不一致。

java.util.LinkedHashMap<k,v>集合 extends HashMap<k,v>集合
特点：
    1.LinkedHashMap底层是哈希表+链表：保证迭代的顺序。
    2.是一个有序集合，存储元素和取出元素的顺序是一致的。

常用方法：
 V put(K key, V value) 将指定的键与值添加到Map集合中。
    返回值：v
    存储键值对的时候，key不重复，返回值v是null；
    key重复，会使用新的value替换map中重复的value值，返回被替换的value值。
 V get(Object key) 根据指定的键，在map集合中获取对应的值。
    返回值：v
        key存在，返回对应的value值；不存在则返回null。
 V remove(Object key) 把指定的键所对应键值对元素，从map集合中删除，返回被删除的元素。
    返回值：v
        key存在，v返回被删除的值；key不存在，返回null。
 boolean containsKey(Object key) 判断集合中是否包含指定的键。
    包含返回true,不包含返回false。

 */
public class Demo01Map {
    public static void main(String[] args) {
        show01();
        show02();
    }

    private static void show02() {
        Map<String, Integer> map = new HashMap<>();
        map.put("小乔", 158);
        map.put("大乔", 165);
        map.put("貂蝉", 168);
        map.put("王昭君", 170);
        System.out.println(map);

        //删除存在的键
        Integer v1 = map.remove("貂蝉");
        System.out.println(v1);

        //删除不存在的键
        /*int v2=map.remove("大大乔");*/  //NullPointerException
        Integer v2 = map.remove("大大乔"); //null
        System.out.println(v2);

        //查找对应的值
        Integer v3 = map.get("大乔");
        System.out.println(v3); //165

        Integer v4 = map.get("貂蝉");
        System.out.println(v4); //null

        //判断是否包含
        boolean b1 = map.containsKey("小乔");
        System.out.println(b1);//true

        boolean b2=map.containsKey("大大乔");
        System.out.println(b2);//false
    }

    private static void show01() {
        Map<String, String> map = new HashMap<>();
        String v1 = map.put("陈芊芊", "韩烁");
        System.out.println(v1);  //null

        String v2 = map.put("陈芊芊", "韩烁2");
        System.out.println(v2);  //被替换的值：韩烁


        map.put("孙尚香", "刘备");  //一般情况下无需接收返回值
        map.put("貂蝉", "吕布");
        map.put("大乔", "孙策");
        System.out.println(map); //{貂蝉=吕布, 大乔=孙策, 孙尚香=刘备, 陈芊芊=韩烁2}
    }
}

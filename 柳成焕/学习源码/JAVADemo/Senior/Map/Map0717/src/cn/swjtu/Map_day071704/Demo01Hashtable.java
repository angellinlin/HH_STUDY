package cn.swjtu.Map_day071704;

import java.util.HashMap;
import java.util.Hashtable;

/*
java.util.Hashtable<K,V>集合  implements Map<K,V>接口
特点：
    1.Hashtable底层也是一个哈希表，是一个线程安全的集合，是单线程集合，速度慢
      HashMap底层是一个哈希表，是一个线程不安全的集合，是多线程集合，速度快
    2.HashMap集合（之前学的所有集合都）：可以存储null值，null键
      Hashtable集合：不能存储null值，null键
   3.Hashtable集合和Vector集合在JDK1.2版本之后被更先进的集合取代了（HashMap,ArrayList）
     Hashtable的子类Properties依然活跃在历史舞台，Properties是唯一一个和IO流相结合的集合。


 */
public class Demo01Hashtable {
    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<>();
        map1.put(null, "a");
        map1.put("b", null);
        map1.put(null, null);
        System.out.println(map1); //{null=null, b=null}

        Hashtable<String, String> map2 = new Hashtable<>();
       // map2.put(null, "a");  //NullPointerException
       // map2.put("b", null);
        //map2.put(null, null);
        System.out.println(map2);

    }
}

package cn.swjtu.Map_day071702;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*

HashMap存储自定义类型键值：
    Map集合保证key是唯一的：作为key的元素，必须重写hashCode和equals方法。以保证key唯一。



 */
public class Demo01HashMapSavePerson {
    public static void main(String[] args) {
        method01();
        System.out.println("============");
        method02();
    }

    /*
   key：Person类型
      Person类型必须重写hashCode方法和equals方法，以保证key唯一
   value：String类型
       value可以重复
    */
    private static void method02() {
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person("啊柳", 18), "厦门");
        map.put(new Person("王昭君", 17), "青海");
        map.put(new Person("李白", 20), "苏州");
        map.put(new Person("啊柳", 18), "昆明");
        System.out.println(map);
        //使用entrySet和增强for遍历
        Set<Map.Entry<Person, String>> set = map.entrySet();
        //使用增强for遍历
        for (Map.Entry<Person, String> entry : set) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

    /*
    key：String类型
        String类型重写hashCode方法和equals方法
    value：Person类型
        value可以重复（同名年龄的人视为同一个人）
     */
    private static void method01() {
        //创建HashMap集合
        HashMap<String, Person> map = new HashMap<>();
        map.put("北京", new Person("张三", 18));
        map.put("上海", new Person("李四", 17));
        map.put("厦门", new Person("王五", 20));
        map.put("北京", new Person("李五", 19));
        System.out.println(map);
        //使用keySet  增强for遍历
        Set<String> set = map.keySet();
        for (String key : set) {
            Person value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }
}

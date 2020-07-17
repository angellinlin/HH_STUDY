package cn.swjtu.Collections_day0717;

import java.util.ArrayList;
import java.util.Collections;

/*
 public static <T> void sort(Lsit<T> list):将集合中的元素按默认规则排序（默认从小到大）
注意：sort方法适用前提是被排序的集合里存储的元素，必须实现Comparable，重写接口中的方法compareTo定义排序的规则。
      Comparable排序规则：this-参数：升序

 */
public class Demo02CollectionsSort {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 4, 6, 3, 10, 3, 1, 3, 100);
        System.out.println(list1); //[4, 6, 3, 10, 3, 1, 3, 100]

        Collections.sort(list1);
        System.out.println(list1);  //[1, 3, 3, 3, 4, 6, 10, 100]

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "vv", "ab", "ac", "AC","bc");
        System.out.println(list2); //[vv, ab, ac, AC, bc]

        Collections.sort(list2);
        System.out.println(list2);  //[AC, ab, ac, bc, vv]

        System.out.println("================");
        ArrayList<Person> list3=new ArrayList<>();
        Collections.addAll(list3,
                new Person("啊柳",18),
                new Person("孙尚香",15),
                new Person("王昭君",19));
        System.out.println(list3);//[Person{name='啊柳', age=18}, Person{name='孙尚香', age=15}, Person{name='王昭君', age=19}]

        Collections.sort(list3);//年龄升序
        System.out.println(list3);//[Person{name='孙尚香', age=15}, Person{name='啊柳', age=18}, Person{name='王昭君', age=19}]
    }
}

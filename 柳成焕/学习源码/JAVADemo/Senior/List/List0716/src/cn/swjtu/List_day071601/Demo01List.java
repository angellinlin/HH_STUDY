package cn.swjtu.List_day071601;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
java.util.List接口extends Collection接口
    List接口的特点：
        1.有序的集合，存储元素和取出元素的顺序是一致的（存储的顺序是123，取出的顺序也是123）；
        2.有索引，包含了一些带索引的方法；
        3.允许存储重复元素。
     List接口中带索引的方法（特有）:
        void add(int index, E element) 在列表的指定位置插入指定元素。
        E get(int index) 返回列表中指定位置的元素。
         E remove(int index) 移除列表中指定位置的元素，返回的是被移除的元素。
         E set(int index, E element) 用指定元素替换列表中指定位置的元素，返回更新前的元素。
注意：操作索引时，一定要防止索引越界异常。
IndexOutOfBoundsException，索引越界异常，集合会报
ArrayIndexOutOfBoundsException,数组索引越界异常
StringIndexOutOfBoundsException，字符串索引越界异常

 */
public class Demo01List {
    public static void main(String[] args) {
        //创建一个List集合。多态
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        list.add("aaa");
        //打印集合
        System.out.println(list);  //重写了toString  [aaa, bbb, ccc, ddd, eee, aaa]

        //void add(int index, E element) 在列表的指定位置插入指定元素。
        //在ccc和ddd之间添加一个hello
        list.add(3, "hello");
        System.out.println(list);//[aaa, bbb, ccc, hello, ddd, eee, aaa]

        // E remove(int index) 移除列表中指定位置的元素，返回的是被移除的元素。
        //移除ccc元素
        System.out.println("被移除的元素：" + list.remove(2)); //被移除的元素：ccc
        System.out.println(list); //[aaa, bbb, hello, ddd, eee, aaa]

        // E set(int index, E element) 用指定元素替换列表中指定位置的元素，返回更新前的元素。
        //把最后一个aaa替换为AAA
        System.out.println("被替换的元素：" + list.set(5, "AAA"));  //被替换的元素：aaa
        System.out.println(list);//[aaa, bbb, hello, ddd, eee, AAA]

        //遍历List集合有三种方式
        //1.使用普通for循环
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(str);
        }

        //2.迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }

        //增强for
        for(String str:list){
            System.out.println(str);
        }

        /*String s=list.get(6);
        System.out.println(s); */ //IndexOutOfBoundsException
    }
}

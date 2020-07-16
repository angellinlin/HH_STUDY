package cn.swjtu.List_day071601;

import java.util.LinkedList;
import java.util.jar.JarOutputStream;

/*
java.util.LinkedList集合 implements List接口
特点：
1.底层是一个链表结构：查询慢，增删快；
2.里边包含了大量操作首尾元素的方法；
    注意：使用LinkedList集合特有的方法不能使用多态。

常用方法：
    void addFirst(E e) 将指定元素插入此列表的开头。
    void addLast(E e) 将指定元素添加到此列表的结尾
    void push(E e) 将元素推入此列表所表示的堆栈。相当于addFirst()

    E getFirst() 返回此列表的第一个元素。
    E getLast() 返回此列表的最后一个元素。

    E removeFirst() 移除并返回此列表的第一个元素。
    E removeLast() 移除并返回此列表的最后一个元素。
    E pop() 从此列表所表示的堆栈处弹出一个元素。相当于removeLast()

    boolean isEmpty()如果列表不包含元素，则返回true



 */
public class Demo02LinkedList {
    public static void main(String[] args) {
        show01();
        show02();
        show03();
    }

    private static void show03() {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("aaa");
        linked.add("bbb");
        linked.add("ccc");
        linked.add("ddd");
        linked.add("aaa");
        System.out.println(linked);  //[aaa, bbb, ccc, ddd, aaa]

        String str1=linked.removeFirst();
        System.out.println("被移除的第一个元素:"+str1);//被移除的第一个元素:aaa
        String str2=linked.removeLast();
        System.out.println("被移除的最后一个元素："+str2);//被移除的最后一个元素：aaa
        System.out.println(linked);//[bbb, ccc, ddd]

        String str3=linked.pop();
        System.out.println(str3);  //bbb
        System.out.println(linked); //[ccc, ddd]

    }

    private static void show02() {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("xxx");
        linked.add("yyy");
        linked.add("zzz");

        linked.clear();  //清空元素  再获取集合元素则会抛出异常NoSuchElementException

        if(!linked.isEmpty()){
            //获取第一个元素
            String str1 = linked.getFirst();
            System.out.println("第一个元素为：" + str1);
            String str2 = linked.getLast();
            System.out.println("最后一个元素为：" + str2);
            System.out.println(linked);//集合不变 [xxx, yyy, zzz]
        }

    }

    private static void show01() {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("aaa");
        linked.add("bbb");
        linked.add("ccc");
        linked.add("ddd");
        linked.add("aaa");
        System.out.println(linked);  //[aaa, bbb, ccc, ddd, aaa]

        //往集合开头添加一个world
        linked.addFirst("world");
        System.out.println(linked);  //[world, aaa, bbb, ccc, ddd, aaa]

        //再往集合开头添加一个hello
        //push  addFirst等效
        linked.push("hello");
        System.out.println(linked);  //[hello, world, aaa, bbb, ccc, ddd, aaa]

        //往集合末尾添加com
        linked.addLast("com");  //其实与add无异
        System.out.println(linked); //[hello, world, aaa, bbb, ccc, ddd, aaa, com]
    }

}

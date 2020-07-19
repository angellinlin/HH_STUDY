package cn.com.spdb.testidea09;

import java.util.Collection;
import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();//多态
        list.add(5);
        list.add(6);
        list.add(1,7);
        list.push(9);//入栈
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.pop();//出栈
        System.out.println(list);

    }
}

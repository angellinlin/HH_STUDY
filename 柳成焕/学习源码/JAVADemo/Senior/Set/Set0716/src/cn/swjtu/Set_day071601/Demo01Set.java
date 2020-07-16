package cn.swjtu.Set_day071601;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
java.util.Set接口 extends Collection
Set接口的特点：
    1.不允许存储重复的元素；
    2.没有索引，没有带索引的方法，也不能使用普通的for循环；

java.util.HashSet集合 implements Set接口
HashSet集合的特点：
    1.不允许存储重复的元素；
    2.没有索引，没有带索引的方法，也不能使用普通的for循环；
    3.是一个无序的集合，存储元素和取出元素的顺序可能不一致；
    4.底层是一个哈希表结构（查询速度非常的快）。

 */
public class Demo01Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(100);
        set.add(200);
        set.add(300);
        System.out.println(set);

        //遍历Set集合，使用迭代器
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println(i);
        }

        //使用增强for
        for (Integer i : set) {
            System.out.println(i);
        }

    }
}


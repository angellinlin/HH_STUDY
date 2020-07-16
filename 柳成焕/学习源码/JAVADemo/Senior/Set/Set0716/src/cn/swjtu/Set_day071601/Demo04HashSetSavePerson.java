package cn.swjtu.Set_day071601;

import java.util.HashSet;

/*
HashSet存储自定义类型元素
Set集合报错元素唯一：
    存储的元素（String,Integer,...,Student,Person...），必须重写hashCode方法和equals方法

 要求：同名同年龄的人，视为同一人，只能存储一次

 */
public class Demo04HashSetSavePerson {
    public static void main(String[] args) {
        //创建一个HashSet集合存储Person
        HashSet<Person> set=new HashSet<>();
        Person p1=new Person("孙尚香",18);
        Person p2=new Person("孙尚香",18);
        Person p3=new Person("孙尚香",19);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p1==p2);//false
        System.out.println(p1.equals(p2)); //不重写比较的是地址值，false
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
    }
}

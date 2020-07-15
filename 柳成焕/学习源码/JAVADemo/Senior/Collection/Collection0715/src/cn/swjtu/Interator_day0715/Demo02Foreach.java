package cn.swjtu.Interator_day0715;

import java.util.ArrayList;
import java.util.Collection;

/*
增强for循环：底层使用的是迭代器，使用for循环的结构，简化了迭代器的书写。
是JDK1.5之后的新特性。
public interface Collection<E>extends Iterable<E>：所有的单列集合都可以使用增强for。
public interface Iterable<T>实现这个接口允许对象成为 "foreach" 语句的目标。

作用：用于遍历集合和数组
格式：for(集合/数组的数据类型 变量名：集合名/数组名) {
        sout(变量名);
       }


 */
public class Demo02Foreach {
    public static void main(String[] args) {
        //增强for遍历数组
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        for(int i:arr){
            System.out.println(i);
        }

        //遍历集合
        Collection<String>coll=new ArrayList<>();
        coll.add("孙尚香");
        coll.add("鲁班七号");
        coll.add("伽罗");
        coll.add("芈月");
        for(String str:coll){
            System.out.println(str);
        }
    }
}

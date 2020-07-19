package cn.com.spdb.testidea09;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();//多态
        System.out.println(c1);//重写了toString方法
        //添加元素，返回值是布尔值，可以不用接收
        c1.add("张三");
        c1.add("李四");
        c1.add("王五");
        c1.add("田七");
        System.out.println(c1);
        //删除
        c1.remove("张三");
        //包含
        System.out.println(c1.contains("张三"));
        System.out.println(c1.contains("李四"));
        //判断是否为空
        System.out.println(c1.isEmpty());
        //返回元素个数
        System.out.println(c1.size());
        //变成数组
        Object[] obj = c1.toArray();
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }
    }
}

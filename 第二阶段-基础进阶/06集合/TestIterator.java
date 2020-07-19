package cn.com.spdb.testidea09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();//多态
        System.out.println(c1);//重写了toString方法
        //添加元素，返回值是布尔值，可以不用接收
        c1.add("张三");
        c1.add("李四");
        c1.add("王五");
        c1.add("田七");
        System.out.println(c1);

        Iterator<String> iterator = c1.iterator();//获取迭代器
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
     for(String a:c1){
         System.out.println(a);
     }

     //测试自己写的带泛型的类
     TestGeneric<String> ge = new TestGeneric<>("旺旺");
        System.out.println(ge.getName());

        TestGeneric<Integer> ge1 = new TestGeneric<>(1);
        int a = ge1.getName();
        System.out.println(a);

        //测试自己写的接口
        TestGeCom new1 = new TestGeCom();
        new1.method1("hahah");

        TestGenericImpl2<Integer> new2 = new TestGenericImpl2<>();
        new2.method1(10);

    }
}

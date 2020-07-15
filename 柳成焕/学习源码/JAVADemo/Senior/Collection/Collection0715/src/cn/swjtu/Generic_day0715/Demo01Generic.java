package cn.swjtu.Generic_day0715;

import java.util.ArrayList;
import java.util.Iterator;

/*
创建集合对象，不使用泛型
    好处：集合不使用泛型，默认类型就是Object类型，可以存储任意数据。
    弊端：不安全，会引发异常。
创建集合，使用泛型：
    好处：
        1.避免了类型转换的麻烦，存储的是什么类型，取出的就是什么类型；
        2.把运行期异常（代码运行之后会抛出的异常），提升到了编译期（写代码的时候就会报错）。
    弊端：泛型是什么类型，就只能存储什么类型（可以忽略）。
 */
public class Demo01Generic {
    public static void main(String[] args) {
        //不使用泛型
        //demo01();

        //使用泛型
        demo02();

    }

    private static void demo02() {
        ArrayList<String> list=new ArrayList<>();
        list.add("123");
        //list.add(100);  //直接报错

        Iterator<String> it=list.iterator();
        while (it.hasNext()){
            String str=it.next();
            System.out.println(str+" "+str.length());  //3
        }
    }

    private static void demo01() {
        //不使用泛型
        ArrayList list = new ArrayList();
        list.add("abs");
        list.add(100);
        //使用迭代器遍历list集合
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);

            //想要使用String类特有的方法.length获取字符串的长度；
            //但现在不能使用，因为多态不能使用子类的专有方法
            //所以需要向下转型
            //ClassCastException类型转换异常
            String str = (String) obj;
            System.out.println(str.length());
        }
    }


}

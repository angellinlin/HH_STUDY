package cn.swjtu.Interator_day0715;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
java.util.Iterator接口：迭代器（对集合进行遍历）
有两个常用方法：
    boolean hasNext() 判断集合中还有没有下一个元素，有则返回true，没有则返回false.
    E next()          取出集合的下一个元素
注意：
1.Iterator迭代器是一个接口，无法直接使用，需要使用其实现类对象。获取实现类的方式比较特殊。
2.Collection接口中有一个方法叫Iterator()，这个方法的返回值就是Iterator的实现类对象。
  即：Iterator<E> iterator()

迭代器的使用步骤【重点】：
1.先使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收（多态）；
注意：Iterator<E>接口也是有泛型的，迭代器的泛型跟着集合走，集合是什么类型，迭代器就是什么类型。
2.使用Iterator的hasNext()方法判断还有没有下一个元素；
3.使用Iteraor的next()方法取出集合中的一个元素。

 */
public class Demo01Interator {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("孙尚香");
        coll.add("后羿");
        coll.add("鲁班七号");
        coll.add("虞姬");
        coll.add("伽罗");
        //1.先使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收（多态）；
        //泛型与集合一致
        //接口           --   实现类     （多态）
        Iterator<String> it = coll.iterator();

        while (it.hasNext()){  //2.判断是否还有下一个元素
            String str=it.next();  //有则取出下一个元素
            System.out.println(str);
        }

        System.out.println("============");
       /* String str=it.next();   //没有元素再取则会抛出异常 NoSuchElementException
        System.out.println(str);*/

        //若是想用for循环
        for (Iterator<String> it2 = coll.iterator(); it2.hasNext(); ){

        }

    }
}

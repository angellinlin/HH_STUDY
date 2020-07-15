package cn.swjtu.Collection_day071501;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/*
java.util.Collection接口：
    public boolean add(E e);    把给定的对象添加到当前集合中（一般都返回true，可以不用接收）
    public void clear();        清空集合中所有的元素（清空集合中的元素，但集合还在）
    public boolean remove(E e);  把给定的对象在集合中删除
                                 （集合中存在该元素，删除元素，返回true；集合中不存在该元素，删除失败，返回false）
    public boolean contains(E e);判断当前集合中是否包含给定的对象
    public boolean isEmpty();    判断当前集合是否为空(空返回true)
    public int size();           返回集合中元素的个数
    public Object[] toArray();   把集合中的元素，存储到数组中。


 */
public class Demo01Collection {
    public static void main(String[] args) {
        //创建集合  使用多态
        //Collection<String> coll = new ArrayList<>();
        Collection<String> coll = new HashSet<>();
        System.out.println(coll);  //重写了toString方法

        //使用add方法
        boolean bool = coll.add("啊柳");
        System.out.println(coll);  //[啊柳]
        System.out.println(bool);  //true
        coll.add("孙尚香");
        coll.add("孙尚香");
        coll.add("芈月");
        System.out.println(coll);  //[啊柳, 孙尚香, 芈月]

        //删除指定元素
        boolean b1 = coll.remove("啊柳");
        System.out.println(b1);  //true

        boolean b2 = coll.remove("凯");
        System.out.println(b2);  //false

        System.out.println(coll);  //[孙尚香, 芈月]

        //判断是否包含该元素
        boolean b3=coll.contains("芈月");
        System.out.println(b3);  //true

        boolean b5=coll.contains("吕布");
        System.out.println(b5);  //false

        //判断当前集合是否为空  集合为空返回true，否则返回false
        boolean b6=coll.isEmpty();
        System.out.println(b6);  //false

        //求集合长度
        int size=coll.size();
        System.out.println(size);  //2

        //把集合中的元素存储到数组
        Object[] arr=coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //清空集合中的元素，但集合还在
        coll.clear();
        System.out.println(coll); //[]
        System.out.println(coll.isEmpty()); //true
    }
}

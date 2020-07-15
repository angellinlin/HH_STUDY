package cn.swjtu.Generic_day0715;

import java.util.ArrayList;
import java.util.Iterator;

/*
泛型通配符：  ？代表任意的数据类型
使用方式：   不能创建对象使用，只能作为方法的参数使用。


 */
public class Demo05Generic {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(100);
        list1.add(200);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("孙尚香");
        list2.add("刘备");
        list2.add("吕布");
        list2.add("貂蝉");

        foreachArrayList(list1);
        foreachArrayList(list2);

        //到底能不能用啊，没有报错啊！！
       /* ArrayList<?> list3=new ArrayList<>();
        foreachArrayList(list3);
*/
    }

    //定义一个方法，能够遍历所有类型的ArrayList集合
    public static void foreachArrayList(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}

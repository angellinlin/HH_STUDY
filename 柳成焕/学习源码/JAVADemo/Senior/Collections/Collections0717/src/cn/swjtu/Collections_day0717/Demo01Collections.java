package cn.swjtu.Collections_day0717;

import java.util.ArrayList;
import java.util.Collections;

/*
java.util.Collections是集合工具类，用来对集合进行操作。
常用方法：
    public static<T> boolean addAll(Collection<T> c,T...elements)：往集合中添加一些元素
    public static void shuffle(List<?> list)：打乱元素顺序
    public static <T> void sort(Lsit<T> list):将集合中的元素按默认规则排序（默认从小到大）
注意：sort方法适用前提是被排序的集合里存储的元素，必须实现Comparable，重写接口中的方法compareTo定义排序的规则。
      Comparable排序规则：this-参数：升序
    public static <T> void sort(List<T> list,Comparator<? super T>)：定义默认规则
区别：Comparable：自己(this)和别人（参数）比较，自己需要实现Comparable接口，重写比较规则compareTo方法
      Comparator：相当于找一个第三方的裁判，比较两个o1,o2

 */
public class Demo01Collections {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        /*list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add("ff");
        System.out.println(list);//[aa, bb, cc, dd, ee, ff]*/

        //一次性添加多个元素
        Collections.addAll(list, "aa", "bb", "cc", "dd", "ee");
        System.out.println(list);//[aa, bb, cc, dd, ee]

        //打乱元素顺序
        Collections.shuffle(list);
        System.out.println(list);

        //
    }
}

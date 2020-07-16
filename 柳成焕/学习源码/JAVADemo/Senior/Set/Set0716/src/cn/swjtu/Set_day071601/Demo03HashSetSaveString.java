package cn.swjtu.Set_day071601;

import java.util.HashSet;

/*
Set集合不允许存储重复元素的原理:
    Set集合在调用add方法时，add方法会调用元素的hashCode方法和equals方法，判断元素是否重复。

 */
public class Demo03HashSetSaveString {
    public static void main(String[] args) {
        //创建HashSet集合对象
        HashSet<String> set = new HashSet<>();
        String s1 = new String("abc");
        String s2 = new String("abc");
        set.add(s1);
        set.add(s2);
        set.add("重地");
        set.add("通话");
        System.out.println(set);//[重地, 通话, abc]
    }
}

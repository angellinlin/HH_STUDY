package cn.swjtu.demo01.Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Demo11StreamTest02 {
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("万茜");
        one.add("李斯丹妮");
        one.add("张萌");
        one.add("张含韵");
        one.add("王菲菲");
        one.add("蓝盈盈");
        one.add("王丽坤");
        one.add("孟佳");
        one.add("金晨");
        //1.第一个队伍只要名字为3个字的成员姓名，存储到一个新的集合中
        //2.筛选之后只要前三个元素，存储到一个新的集合中
        Stream<String> oneStream = one.stream().filter(name -> name.length() == 3).limit(3);
        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("孙尚香");
        two.add("王昭君");
        two.add("张三");
        two.add("庄周");
        two.add("张无忌");
        two.add("张飞");
        two.add("小乔");
        two.add("张三丰");
        //3.姓张的成员姓名,存储到一个新的集合中
        //4.筛选后的集合，不要前两个人，存储到新的集合中
        Stream<String> twoStream = two.stream().filter(name -> name.startsWith("张")).skip(2);
        //5.将两个筛选后的队伍合并，存储到一个新的集合中
        //6.根据姓名创建Person对象，存储到集合中
        //7.打印整个队伍信息
        Stream.concat(oneStream, twoStream).map(name -> new Person(name)).forEach(person -> System.out.println(person));
    }
}

package cn.swjtu.demo01.Stream;

import java.util.ArrayList;

public class Demo11StreamTest01 {
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
        ArrayList<String> one01 = new ArrayList<>();
        for (String s : one) {
            if (s.length() == 3) {
                one01.add(s);
            }
        }
        //2.筛选之后只要前三个元素，存储到一个新的集合中
        ArrayList<String> one02 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            one02.add(one01.get(i)); //i=0, 1, 2
        }

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
        ArrayList<String> two01 = new ArrayList<>();
        for (String s : two) {
            if (s.startsWith("张")) {
                two01.add(s);
            }
        }
        //4.筛选后的集合，不要前两个人，存储到新的集合中
        ArrayList<String> two02 = new ArrayList<>();
        for (int i = 2; i < two01.size(); i++) {
            two02.add(two01.get(i));
        }

        //5.将两个筛选后的队伍合并，存储到一个新的集合中
        ArrayList<String> all = new ArrayList<>();
        all.addAll(one02);
        all.addAll(two02);

        //6.根据姓名创建Person对象，存储到集合中
        ArrayList<Person> list = new ArrayList<>();
        for (String s : all) {
            list.add(new Person(s));
        }
        //7.打印整个队伍信息
        for (Person person : list) {
            System.out.println(person);
        }
    }
}

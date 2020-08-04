package cn.swjtu.demo01.Stream;

import java.util.ArrayList;
import java.util.List;

/*
使用传统方式，遍历集合，对集合中的数据进行过滤
 */
public class Demo01List {
    public static void main(String[] args) {
        //创建一个List集合，存储姓名
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张丽");
        list.add("李四");
        list.add("张无忌");
        list.add("周芷若");
        //遍历元素，将以“张”开头的元素，存储到新集合中
        ArrayList<String> list02 = new ArrayList<>();
        for (String s : list) {
            //char[] chars = s.toCharArray();
            //if (chars[0] == '张') {
            if(s.startsWith("张")){
                list02.add(s);
            }
        }
        //只要姓名长度为3的人
        ArrayList<String>list03=new ArrayList<>();
        for (String s : list02) {
            if(s.length()==3){
                list03.add(s);
            }
        }

        for (String s : list03) {
            System.out.println(s);
        }
    }
}

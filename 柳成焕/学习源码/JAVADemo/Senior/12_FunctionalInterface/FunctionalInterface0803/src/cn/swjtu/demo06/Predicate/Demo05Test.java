package cn.swjtu.demo06.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
1、有两个判断条件，所以需要使用两个Predicate接口
2、必须同时满足两个条件，可以使用and方法连接两个判断条件
 */
public class Demo05Test {
    //定义一个方法，参数传递数组，2个Predicate接口，用于对数组信息进行过滤
    //把满足条件的信息存到ArrayList集合中保存并返回
    public static ArrayList<String> check(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
        //创建ArrayList用于存储过滤之后的信息
        ArrayList<String> list = new ArrayList<>();
        //遍历数组，获取每一条信息
        for (String s : arr) {
            //对字符串进行判断
            boolean b = pre1.and(pre2).test(s);
            if (b) {
                //两个条件都满足则把信息存储到ArrayList中
                list.add(s);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        //定义一个字符串类型的数组
        String[] arr = {"王昭君,女","孙尚香,女","庄周,男"};
        //调用方法
        ArrayList<String> list = check(arr,
                (String s) -> {
                    //获取自字符串中的姓名，判断长度是否为2
                    int length = s.split(",")[0].length();
                    return ( length== 2);
                },
                (String s) -> {
                    //获取字符串的性别，判断是否为男
                    String male=s.split(",")[1];
                    return male.equals("男");
                });
        //遍历集合输出
        for (String s : list) {
            System.out.println(s);
        }
    }

}

package cn.swjtu.demo05.Consumer;

import java.util.function.Consumer;

public class Demo03Test {
    //定义一个方法，参数传递String类型数组和2个Consumer接口
    public static void printInfor(String[] arr, Consumer<String> con1, Consumer<String> con2) {
        //遍历字符串数组
        for (String s : arr) {
            //使用andThen方法连接两个Consumer接口，消费字符串
            con1.andThen(con2).accept(s);
        }
    }
    public static void main(String[] args) {
        //定义一个字符串类型的数组
        String[] arr = {"王昭君,女", "孙尚香, 女", "庄周, 男"};
        printInfor(arr,
                (String s) -> {
                    //消费方式：对s进行切割，获取姓名，按照指定格式输出
                    String name = s.split(",")[0];
                    System.out.print("姓名：" + name);
                },
                (String s) -> {
                    String male = s.split(",")[1];
                    System.out.println("。性别：" + male+"。");
                });
    }
}

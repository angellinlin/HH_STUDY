package cn.swjtu.day01.Demo0706;

/*
手机类
属性：品牌、价格、颜色
行为：打电话、发短信。
 */
public class Phone {
    String brand; //品牌
    double price; //价格
    String color; //颜色

    public void call(String who) {
        System.out.println("给" + who + "打电话");
    }

    public void text() {
        System.out.println("群发短信！");
    }

}

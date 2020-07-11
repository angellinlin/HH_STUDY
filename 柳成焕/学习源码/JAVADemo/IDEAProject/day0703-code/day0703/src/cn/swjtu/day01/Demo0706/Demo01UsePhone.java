package cn.swjtu.day01.Demo0706;

public class Demo01UsePhone {
    public static void main(String[] args) {
        Phone phone1=new Phone();
        System.out.println(phone1.brand);  //默认值
        System.out.println(phone1.price);
        System.out.println(phone1.color);
        System.out.println("==================");

        //改变成员变量
        phone1.brand="Redmi k30";
        phone1.price=2000;
        phone1.color="薄荷蓝";

        System.out.println(phone1.brand);
        System.out.println(phone1.price);
        System.out.println(phone1.color);
        System.out.println("==================");

        //使用成员方法
        phone1.call("啊柳");
        phone1.text();
    }
}

package cn.swjtu.day01.Demo0706;

public class Demo02PhoneParam {
    public static void main(String[] args) {
        Phone one = new Phone();
        one.brand="红米k30";
        one.price=5000;
        one.color="薄荷蓝";

        method(one);  //传递进去的参数其实就是地址值

    }

    public static void method(Phone phone) {
        System.out.println("method方法执行啦！");
        System.out.println(phone.brand);
        System.out.println(phone.price);
        System.out.println(phone.color);
    }
}

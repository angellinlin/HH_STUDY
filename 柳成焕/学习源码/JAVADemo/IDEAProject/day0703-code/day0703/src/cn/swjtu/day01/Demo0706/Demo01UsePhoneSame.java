package cn.swjtu.day01.Demo0706;
/*
两个对象引用同一块对象空间
 */
public class Demo01UsePhoneSame {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        System.out.println(phone1.brand);  //默认值
        System.out.println(phone1.price);
        System.out.println(phone1.color);
        System.out.println("==================");

        //改变成员变量
        phone1.brand = "Redmi k30";
        phone1.price = 2000;
        phone1.color = "薄荷蓝";

        System.out.println(phone1.brand);
        System.out.println(phone1.price);
        System.out.println(phone1.color);
        System.out.println("==================");

        //使用成员方法
        phone1.call("啊柳");
        phone1.text();
        System.out.println("==================");

        Phone phone2 = phone1;  //实际上是将phone1的地址值赋值给phone2
        System.out.println(phone2.brand);  //默认值就不是0和null了
        System.out.println(phone2.price);
        System.out.println(phone2.color);
        System.out.println("==================");

        //改变成员变量
        phone2.brand = "坚果pro2";
        phone2.price = 1700;
        phone2.color = "酒红色";

        System.out.println(phone2.brand);
        System.out.println(phone2.price);
        System.out.println(phone2.color);
        System.out.println("==================");

        //使用成员方法
        phone2.call("狗子");
        phone2.text();

    }
}

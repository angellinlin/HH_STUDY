package cn.swjtu.StringBuilder_day0715;

/*
public StringBuilder append(...)  添加任意数据类型，返回当前对象自身
注意：StringBuilder builder2 = builder1.append("abc");
方法返回的是this，builder1调用的方法，this=builder1
因此，使用append方法无需接收返回值

链式编程：方法返回值是一个对象，可以继续调用方法。


 */
public class Demo02StringBuilder {
    public static void main(String[] args) {
        StringBuilder builder1 = new StringBuilder();
        System.out.println(builder1);
        //方法返回的是this，builder1调用的方法，this=builder1
        /*StringBuilder builder2 = builder1.append("abc");
        System.out.println(builder2);
        System.out.println(builder1==builder2);//true*/

        //使用append方法无需接收返回值
        builder1.append(1);
        builder1.append(2.0);
        builder1.append("abc");
        builder1.append(false);
        System.out.println(builder1);

        //链式编程
        System.out.println("abc".toUpperCase().toLowerCase().toUpperCase());
        System.out.println(builder1.append(2).append("hsdj").append(23.1));
    }
}

package cn.swjtu.Integer_day0715;

/*
装箱：基本类型 --> 包装类
1.使用构造方法
public Integer(int value)
public Integer(String s)：传递的字符串必须是基本类型的字符串，否则会抛出异常，100-正确，0抛异常
2.使用静态方法
public static Integer valueOf(int i)
public static Integer valueOf(String s)


拆箱：包装类 --> 基本类型
public int intValue()


自动装箱与自动拆箱:JDK1.5后的新特性

 */
public class Demo01Integer {
    public static void main(String[] args) {
        //装箱
        //构造方法
        Integer num1=new Integer(100);//方法上有横线，说明方法过时了
        System.out.println(num1);  //100 重写了toString方法

        Integer num2=new Integer("200");
        System.out.println(num2);//200

        //静态方法
        Integer num3= Integer.valueOf(300);
        System.out.println(num3);  //300

        Integer num4=Integer.valueOf("400");
        System.out.println(num4);  //400

       /* Integer num5=Integer.valueOf("a");
        System.out.println(num5); */     //NumberFormatException

        //拆箱
       Integer num=new Integer(500);
       int i=num.intValue();  //拆箱
    }
}

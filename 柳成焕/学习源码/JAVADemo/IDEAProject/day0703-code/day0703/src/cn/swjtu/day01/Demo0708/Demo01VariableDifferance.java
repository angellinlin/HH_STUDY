package cn.swjtu.day01.Demo0708;
/*
局部变量与成员变量：
1.定义位置不同：
局部变量：在方法的内部
成员变量：在方法的外部，直接写在类中

2.作用域不同【重点】
局部变量：只有在方法中才可以使用，出了方法就不能再用。
成员变量：整个类全部可以通用。

3.默认值不一样【重点】
局部变量：没有默认值，若想要使用，必须手动进行赋值。
成员变量：若没有赋值，会有默认值，规则与数组一样。

4.内存的位置不一样（了解）
局部变量：栈内存
成员变量：堆内存

5.生命周期不一样（了解）
局部变量：随着方法的进栈而诞生，随着方法的出栈而消失。
成员变量：随着对象的创建而诞生，随着对象被垃圾回收而消失。

 */
public class Demo01VariableDifferance {
    public static String name; //成员变量 有默认值 null

    public static void main(String[] args) {
        method1();
        method2(10);
    }

    public static void method1(){
        int num=20;  //局部变量
        System.out.println(num);
        System.out.println(name);
    }

    public static void method2(int param){ //方法参数就是局部变量
        System.out.println(param);  //方法参数在调用时一定会被赋值

        int age;
       //  System.out.println(age);  //错误！局部变量没有默认值，没赋值不能使用

       // System.out.println(num); //错误写法，num为method1中的局部变量

    }
}

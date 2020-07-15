package cn.swjtu.Generic_day0715;

/*
定义含有泛型的方法：泛型定义在方法的修饰符和返回值之间。
格式：修饰符 <泛型> 返回值类型 方法名（参数列表（使用泛型）） {
        方法体;
     }
含有泛型的方法，在调用方法的时候确定泛型的数据类型
传递什么类型的参数，泛型就是什么类型。

 */
public class Demo03GenericMethod {
    public static void main(String[] args) {
        //测试含有泛型的非静态方法
        GenericMethod gm = new GenericMethod();
        gm.method1(100);
        gm.method1(200);
        System.out.println("--------------");

        //测试含有泛型的静态方法
        gm.method2("abf");  //不推荐是用对象调用静态方法，而是直接使用类
        GenericMethod.method2("hello");
    }


}

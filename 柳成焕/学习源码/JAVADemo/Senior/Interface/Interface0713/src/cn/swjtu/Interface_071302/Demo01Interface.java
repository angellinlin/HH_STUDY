package cn.swjtu.Interface_071302;
/*
使用接口的时候，需要注意：
1、接口是没有静态代码块和构造方法的。
2、一个类的直接父类是唯一的，但是一个类可以同时实现多个接口。
格式：
public class MyInterfaceImpl implements MyInterfaceA,MyInterfaceB{
    //覆盖重写所有抽象方法
}
3、如果实现类所实现的多个接口中，存在重复的抽象方法，那么只需要覆盖重写一次即可。
4、如果实现类没有覆盖重写所有接口中的所有抽象方法，那么实现类必须是一个抽象类。
5、如果实现类所实现的多个接口中，存在重复的默认方法，那么实现类一定要对冲入的默认方法进行覆盖重写。
6、一个类中如果直接父类中的方法和接口中的默认方法产生了冲突，优先使用父类中的方法。

 */
public class Demo01Interface {
    public static void main(String[] args) {
        Zi zi=new Zi();
        zi.method();
    }
}

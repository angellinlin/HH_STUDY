package cn.swjtu.Interface_071301;
/*
1.接口的默认方法，可以通过接口实现类对象，直接调用。
2.接口的默认方法，也可以被接口实现类进行覆盖重写。

 */
public class Demo02Interface {
    public static void main(String[] args) {
        MyInterfaceDefaultA a=new MyInterfaceDefaultA();
        a.methodAbs();  //调用抽象方法
        //调用默认方法，如果实现类中没有，则向上找接口
        a.methodDefault();  //这是新添加的默认方法

        System.out.println("========");
        MyInterfaceDefaultB b=new MyInterfaceDefaultB();
        b.methodAbs();
        b.methodDefault(); //这是B覆盖重写了默认方法methodDefault
    }
}

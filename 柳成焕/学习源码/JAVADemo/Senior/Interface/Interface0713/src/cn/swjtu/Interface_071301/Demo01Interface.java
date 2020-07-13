package cn.swjtu.Interface_071301;

/*
接口：就是多个类的公共规范。
接口是一种引用数据类型，最重要的内容就是其中的抽象方法。
定义接口：
public interface 接口名称{
    //接口内容
}

备注：换成了关键字interface之后，生成的字节码文件仍然是：.java  -->  .class

如果是Java7，那么接口中可以包含的内容有：
1.常量
2.抽象方法

如果是Java8，还可以额外包含：
3.默认方法
4.静态方法

如果是Java9，还可以额外包含：
5.私有方法


接口的使用步骤：
1.接口不能直接使用，必须有一个“实现类”来“实现”该接口。
格式：
public class 实现类名称 implements 接口名称{
    //....
}
2.接口的实现必须覆盖重写（实现）接口中所以的抽象方法。
实现：去掉abstract关键字，加上大括号和方法体。
3.创建类的对象，进行使用。

注意事项：
如果实现类并没有覆盖重写接口中所有的抽象方法，那么这个实现类自己就必须是抽象类。
 */
public class Demo01Interface {
    public static void main(String[] args) {
        //不能直接定义接口对象
        // MyInterfaceAbstract inter=new MyInterfaceAbstract();

        //创建实现类的对象使用
        MyInterfaceAbstractImpl ipml=new MyInterfaceAbstractImpl();
        ipml.methodAbs1();

    }
}

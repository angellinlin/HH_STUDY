package cn.swjtu.Interface_071301;
/*
注意：不能通过接口实现类的对象类调用接口当中的静态方法。
正确用法：通过接口名称，直接调用其中的静态方法！
接口名称.静态方法名（参数）;


 */
public class Demo03Interface {
    public static void main(String[] args) {
        //创建实现类对象
        MyInterfaceAbstractImpl impl=new MyInterfaceAbstractImpl();
       //错误写法
        // impl.methodStatic();

        //直接通过接口名称调用静态方法
        MyInterfaceStatic.methodStatic();
    }
}

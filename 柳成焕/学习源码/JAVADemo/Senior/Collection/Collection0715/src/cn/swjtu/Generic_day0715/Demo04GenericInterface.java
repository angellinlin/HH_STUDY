package cn.swjtu.Generic_day0715;

public class Demo04GenericInterface {
    public static void main(String[] args) {
        //创建实现类1的对象
        GenericInterfaceImpl gil=new GenericInterfaceImpl();
        gil.method("abd");
        //创建实现类2的Integer对象
        GenericInterfaceImpl2<Integer> gil2=new GenericInterfaceImpl2<>();
        gil2.method(123);
        //创建实现类2的Double对象
        GenericInterfaceImpl2<Double> gil3=new GenericInterfaceImpl2<>();
        gil3.method(200.0);

    }
}

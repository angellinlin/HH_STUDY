package cn.swjtu.Generic_day0715;
/*
含有泛型的接口，第二种使用方式：接口使用什么泛型，实现类就使用什么泛型，类跟着接口走。
相当于定义了一个含有泛型的类，创建对象时指定泛型的类型。

 */
public class GenericInterfaceImpl2<I> implements GenericInterface<I>{
    @Override
    public void method(I i) {
        System.out.println(i);
    }
}

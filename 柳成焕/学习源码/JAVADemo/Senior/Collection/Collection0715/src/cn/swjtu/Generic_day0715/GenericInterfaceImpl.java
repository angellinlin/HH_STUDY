package cn.swjtu.Generic_day0715;
/*
定义含有泛型的接口的实现类，实现接口，并指定接口的泛型
 */
public class GenericInterfaceImpl implements GenericInterface<String>{

    @Override
    public void method(String str) {
        System.out.println(str);
    }
}

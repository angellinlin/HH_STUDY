package cn.swjtu.demo01.FunctionalInterface;
/*
@Override:检测方法是否为重写的方法
是：编译成功
否：编译失败
 */
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface{
    @Override
    public void method() {
        System.out.println("使用接口实现类重写抽象方法！");
    }


   /* @Override
    public void method3() {

    }*/
}

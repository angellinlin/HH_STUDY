package cn.swjtu.Interface_071302;

public class MyInterfaceImpl implements MyInterfaceA,MyInterfaceB{
    @Override
    public void methodAbs() {
        //只需要覆盖重写一次即可
        System.out.println("覆盖重写AB接口中的重复抽象方法");
    }

    @Override
    public void methodA() {

    }

    @Override
    public void methodB() {

    }

    @Override
    public void methodDefault() {
        System.out.println("这是实现类的覆盖重写AB接口中的默认方法");
    }
}

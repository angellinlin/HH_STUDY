package cn.swjtu.Interface_071301;

public class MyInterfaceDefaultB implements MyInterfaceDefault{
    @Override
    public void methodAbs() {
        System.out.println("实现了抽象方法BBB");
    }

    @Override
    public void methodDefault() {
        System.out.println("这是B覆盖重写了默认方法methodDefault");
    }
}

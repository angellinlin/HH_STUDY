package cn.swjtu.Interface_071302;

public interface MyInterfaceB {
    public abstract void methodAbs();

    public abstract void methodB();

    public default void methodDefault(){
        System.out.println("这是接口B的默认方法");
    }
}

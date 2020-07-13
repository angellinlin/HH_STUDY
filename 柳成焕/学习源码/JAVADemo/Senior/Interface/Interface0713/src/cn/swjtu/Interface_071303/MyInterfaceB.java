package cn.swjtu.Interface_071303;


public interface MyInterfaceB {
    public abstract void methodB();

    public abstract void methodCommon();

    public default void methodDefault() {
        System.out.println("AAA");
    }
}

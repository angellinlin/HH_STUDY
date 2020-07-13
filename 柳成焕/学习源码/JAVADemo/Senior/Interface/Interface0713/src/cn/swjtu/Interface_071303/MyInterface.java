package cn.swjtu.Interface_071303;
/*
子接口中有几个方法：
4个。
methodA；来源于接口A
methodB：来源于接口B
methodCommon：同时来源于接口A B
method：来源于我自己

 */
public interface MyInterface extends MyInterfaceA,MyInterfaceB{
    public  abstract void method();

    @Override
    default void methodDefault() {
        System.out.println("子接口中覆盖重写父接口中的冲突默认方法，default也要写上");
    }
}

package cn.swjtu.demo01.FunctionalInterface;

/*
函数式接口：有且只有一个抽象方法的接口.
当然接口中可以包含其他的方法（默认方法、静态方法、私有方法）

@FunctionalInterface注解：检测接口是否是一个函数式接口。
是：编译成功
否：编译失败（接口中没有抽象方法；抽象方法的个数不为1个）
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    //定义一个抽象方法
    public abstract void method();

}

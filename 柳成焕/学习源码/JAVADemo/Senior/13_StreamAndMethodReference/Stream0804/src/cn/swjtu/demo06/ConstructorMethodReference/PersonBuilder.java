package cn.swjtu.demo06.ConstructorMethodReference;

/*
定义一个创建Person类对象的函数式接口
 */
@FunctionalInterface
public interface PersonBuilder {
    //定义一个方法，根据传递的姓名创建Person对象返回
    public abstract Person personBuilder(String name);
}

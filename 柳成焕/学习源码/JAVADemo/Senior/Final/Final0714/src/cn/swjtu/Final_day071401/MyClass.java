package cn.swjtu.Final_day071401;

/*
当final关键字修饰一个类时，格式：
public final class{
    //...
}
含义：当前这个类不能有任何的子类（太监类）
注意：一个类如果是final的，那么其中所有的成员方法都无法进行覆盖重写。(因为没儿子)


 */
public final class MyClass {
    public void method() {
        System.out.println("方法执行！");
    }
}

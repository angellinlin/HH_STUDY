package cn.swjtu.Final_day071401;

/*
当final关键字修饰一个方法的时候，这个方法是最终方法，也就是不能进行覆盖重写。
格式：public final 返回值类型 方法名称（参数列表）{
        //方法体
    }
注意事项：对于类、方法来说，abstract关键字和final关键字是不能同时使用的，因为矛盾。

 */
public class Fu {
    public/* abstract */final void method() {
        System.out.println("父类方法执行！");
    }
}

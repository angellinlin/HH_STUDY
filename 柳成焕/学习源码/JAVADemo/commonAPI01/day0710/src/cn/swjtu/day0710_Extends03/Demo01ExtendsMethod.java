package cn.swjtu.day0710_Extends03;

/*
在父类的继承关系中，创建子类对象，访问成员方法的规则：
       创建(new)的对象是谁，就优先用谁，如果没有则向上找。
注意事项：
无论是成员方法还是成员变量，如果没有都是向上找父类，绝对不会向下找子类的。

重写Override
概念：在继承关系中，方法名称一样，参数列表也一样。

重写（Override）：方法名称一样，参数列表【也一样】，发生在继承关系中。覆盖、覆写。
重载（Overload）：方法名称一样，参数列表【不一样】。

方法的覆盖重写的特点：创建new的是子类对象，则优先用子类方法。


 */
public class Demo01ExtendsMethod {
    public static void main(String[] args) {
        //就看new的是谁
        Zi zi = new Zi();
        zi.method();//子类重名方法执行啦！


        Fu fu = new Fu();
        fu.method();  //父类重名方法执行啦！

        Fu obj1 = new Zi();
        obj1.method();  //子类重名方法执行啦！

        // Zi obj2=new Fu();
        // obj2.method();
    }
}

package cn.swjtu.day0711_01;
/*
抽象方法：就是在返回值之前加上abstract关键字，然后去掉大括号，直接分号结束。
抽象类：抽象方法所在的类，必须是抽象类才行。在class前加上abstract即可。

使用
1.不能直接创建new抽象类对象。
2.必须用一个子类来继承抽象父类。
3.子类必须覆盖重写抽象父类中所有的抽象方法。
覆盖重写（实现）：去掉抽象方法的abstract关键字，然后补上大括号方法体。
4.创建子类对象进行使用。

 */
public abstract  class Animal {
    //这是一个抽象方法，代表吃东西，但是具体吃什么（大括号的内容）不确定
    public abstract void eat();

    //这是普通的成员方法
    public void method(){
        System.out.println();
    }
}

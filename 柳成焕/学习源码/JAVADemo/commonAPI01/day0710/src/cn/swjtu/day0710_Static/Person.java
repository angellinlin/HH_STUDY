package cn.swjtu.day0710_Static;
/*
静态代码块的格式：

public class 类名称{
    static{
        //静态代码块的内容
    }
}
特点：当第一次用到本类时，静态代码块执行唯一的一次。
静态内容总是优先于非讲台，所以静态代码块比构造方法先执行。

 */
public class Person {
    static {
        System.out.println("静态代码块执行了！");
    }

    public Person(){
        System.out.println("构造方法执行啦！");
    }
}

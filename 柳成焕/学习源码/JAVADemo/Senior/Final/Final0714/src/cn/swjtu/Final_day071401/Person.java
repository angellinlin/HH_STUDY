package cn.swjtu.Final_day071401;

/*
对于成员变量来说，如果使用final关键字来修饰，那么这个变量也同样是不可改变。

1.由于成员变量有默认值，所以使用了final之后必须手动赋值，不会再给默认值了。
2.对于final的成员变量，要么使用直接赋值，要么通过构造方法进行赋值。
3.必须保证类中所有重载的构造方法，都最终会对final的成员变量进行赋值。



 */
public class Person {
    private final String name/*="刘亦菲"*/;

    public Person() {
        name = "刘亦菲";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*public void setName(String name) {
        this.name = name;
    }*/
}

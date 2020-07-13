package cn.swjtu.Multi_day071302;
/*
在多态的代码中，成员方法的访问规则是：
看new的是谁，就优先用谁，没有则向上找。

口诀：编译看左边，运行看右边。

对比一下：
成员变量：编译看左边，运行还看左边。
成员方法：编译看左边，运行看右边。
 */
public class Demo02MultiMethod {
    public static void main(String[] args) {
        Fu obj=new Zi();

        //父子都有method，new的是Zi，则优先用子类方法
        obj.method();  //子类方法！

        //子类没有，则向上找
        obj.methodFu(); //父类专有方法！

        //编译看左边，左边是Fu,Fu中没有methodZi方法，所以编译报错
        //obj.methodZi();  报错
    }



}

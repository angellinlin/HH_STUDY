package cn.swjtu.day01.Demo0708_02;
/*
当方法的局部变量和类的成员变量重名的时候，根据“就近原则”，优先使用局部变量。
如果需要访问本类中的成员变量，需要使用格式：this.成员名

"通过谁调用的方法，谁就是this"
 */
public class Person {
    String name;  //我自己的名字

    public void sayHello(String name){
        System.out.println(name+"给"+this.name+"打招呼");
        System.out.println(this);
    }
}

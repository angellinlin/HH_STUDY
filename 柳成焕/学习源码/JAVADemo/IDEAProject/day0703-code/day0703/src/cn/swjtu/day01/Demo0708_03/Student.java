package cn.swjtu.day01.Demo0708_03;
/*
定义一个标准类
一个标准的类通常要拥有下列四个组成部分：
1.所有的成员变量都要使用private关键字修饰；
2.为每一个成员变量编写set/get方法；
3.编写一个无参构造方法；
4.编写一个全参数的构造方法。

标准的类也叫作：Java Bean
 */
public class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

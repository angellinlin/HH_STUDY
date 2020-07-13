package cn.swjtu.day0711_01;

public class DemoMain {
    public static void main(String[] args) {
        //报错！抽象类不能直接创建对象
        //Animal ani=new Animal();

        Cat cat=new Cat();
        cat.eat();
    }


}

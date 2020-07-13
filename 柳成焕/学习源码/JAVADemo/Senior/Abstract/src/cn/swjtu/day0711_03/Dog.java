package cn.swjtu.day0711_03;
/*
子类也是一个抽象类
 */
public abstract class Dog extends Animal{
    @Override
    public void sleep() {
        System.out.println("huhuhu");
    }

    //public abstract void eat();
}

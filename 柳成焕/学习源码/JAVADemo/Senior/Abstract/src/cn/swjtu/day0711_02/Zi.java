package cn.swjtu.day0711_02;

public class Zi extends Fu{
    public Zi(){
        System.out.println("子类构造！");
    }

    @Override
    public void method() {
        System.out.println("子类");
    }
}

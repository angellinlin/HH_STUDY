package cn.swjtu.day0710Extends_02;

public class Zi extends Fu {
    int num =20;

    public void method() {
        int num = 30;
        System.out.println(num);  //30  局部变量
        System.out.println(this.num); //20 子类成员变量
        System.out.println(super.num);//10 父类成员变量
    }
}

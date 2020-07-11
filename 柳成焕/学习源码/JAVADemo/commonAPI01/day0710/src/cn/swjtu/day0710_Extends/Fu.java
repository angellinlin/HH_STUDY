package cn.swjtu.day0710_Extends;

public class Fu {
    int numFu = 10;
    int num = 100;

    public void methodFu(){
        //使用的是本类中的num，不会向下找
        System.out.println(num);
    }

    public void method(){
        System.out.println(num);
    }
}

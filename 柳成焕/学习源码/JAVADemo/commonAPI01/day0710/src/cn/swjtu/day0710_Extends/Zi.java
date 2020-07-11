package cn.swjtu.day0710_Extends;

public class Zi extends Fu {
    int numZi = 20;
    //int num = 200;

    public void methodZi(){
        //因为本类中有num，所以此处使用的是本类中的num
        System.out.println(num);
    }

    public void method(){
        System.out.println(num);
    }
}

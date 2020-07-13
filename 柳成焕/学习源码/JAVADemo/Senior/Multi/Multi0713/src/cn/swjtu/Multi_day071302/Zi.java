package cn.swjtu.Multi_day071302;

public class Zi extends Fu {
    int num = 20;

    @Override
    public void showNum() {
        System.out.println(num);
    }

    @Override
    public void method(){
        System.out.println("子类方法！");
    }

    public void methodZi(){
        System.out.println("子类专用方法");
    }

}

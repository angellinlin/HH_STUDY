package cn.swjtu.Demo02.WaitAndNotify;
/*
4、测试类：包含main方法的类，程序执行的入口，启动程序。
	创建包子对象
	创建包子铺线程，开启
	创建吃货线程，开启

 */
public class Demo {
    public static void main(String[] args) {
        //创建包子对象
        BaoZi baozi=new BaoZi();
        //创建包子铺线程，开启
        new BaoZiPu(baozi).start();
        //创建吃货线程，开启
        new ChiHuo(baozi).start();
    }
}

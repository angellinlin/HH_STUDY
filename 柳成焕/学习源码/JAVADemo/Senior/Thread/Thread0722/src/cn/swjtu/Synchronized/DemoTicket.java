package cn.swjtu.Synchronized;

public class DemoTicket {
    public static void main(String[] args) {
        //定义一个实现类对象
        RunnableImpl1 run = new RunnableImpl1();
        Thread th0=new Thread(run);
        Thread th1=new Thread(run);
        Thread th2=new Thread(run);

        //启动线程
        th0.start();
        th1.start();
        th2.start();
    }


}

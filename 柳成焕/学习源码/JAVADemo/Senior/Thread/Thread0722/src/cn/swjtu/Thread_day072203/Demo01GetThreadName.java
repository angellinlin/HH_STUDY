package cn.swjtu.Thread_day072203;
/*
线程的名称：
    主线程:main
    新线程：Thread-0，Thread-1

 */
public class Demo01GetThreadName {
    public static void main(String[] args) {
        //创建Thread类的子类对象
        MyThread mt1=new MyThread();
        //调用start方法，开启新线程
        mt1.start();

        MyThread mt2=new MyThread();
        mt2.start();

        MyThread mt3=new MyThread();
        mt3.start();

        //获取主线程名称
        System.out.println(Thread.currentThread().getName());
    }
}

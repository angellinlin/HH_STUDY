package cn.com.spdb.testidea10;

import cn.com.spdb.testidea08.Tset;

import static java.lang.Thread.sleep;

public class TestMultiThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();//创建实例
        mt.setName("hh");
        mt.start();//开启线程
        //mt.run();//不用调用方法，开启线程自动执行run方法
        new MyThread().start();
        new MyThread().start();
        Thread.sleep(50);
        for (int i = 0; i < 20; i++) {
            System.out.println("main="+i);//这个是线程安全的，貌似不能用来看多线程的效果
        }
        System.out.println(Thread.currentThread().getName());

        TestRunnable run = new TestRunnable();
        Thread th = new Thread(run);
        th.start();
    }
}

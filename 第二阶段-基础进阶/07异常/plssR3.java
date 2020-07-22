package cn.com.spdb.testidea10;

public class plssR3 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程3");
    }
}


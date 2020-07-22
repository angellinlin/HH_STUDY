package cn.com.spdb.testidea10;

import java.util.concurrent.locks.Lock;

public class TestWaitNotify {
    public static void main(String[] args) {
        //创建顾客和老板两个线程,顾客和老板的操作必须使用同步代码块包裹起来
        Object obj = new Object();
        //顾客
         new Thread(new Runnable() {
            @Override

            public void run() {
                for (int i = 0; i <5 ; i++) {
                    synchronized (obj) {
                        System.out.println("我要"+i+"个包子");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

         //厨师
        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(300*i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println("给你"+i+"个包子");
                        obj.notify();
                    }
                }
                System.out.println("记得给五星好评");
            }
                //花五秒时间做包子

        }).start();

    }
}

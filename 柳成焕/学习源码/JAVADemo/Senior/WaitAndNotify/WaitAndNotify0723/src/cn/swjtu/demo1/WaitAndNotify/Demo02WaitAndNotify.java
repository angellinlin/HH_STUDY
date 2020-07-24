package cn.swjtu.demo1.WaitAndNotify;
/*
进入到TimeWaiting(计时等待)有两种方式：
1、使用sleep(long m)方法，在毫秒值结束后，线程睡醒进入到Runnable/Blocked状态；
2、使用wait(long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来。

唤醒的方法：
1、void notify()唤醒在此对象监视器上等待的单个线程，如果有多个，则随机唤醒一个
2、 void notifyAll() 唤醒在此对象监视器上等待的所有线程
 */
public class Demo02WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object obj=new Object();
        //创建一个顾客线程
        new Thread(){
            @Override
            public void run() {
                //保证等待和唤醒的线程只能有一个执行
                //需要使用同步技术
                while (true){
                    synchronized (obj){
                        System.out.println("顾客1告知老板要的包子种类和数量");
                        //调用wait方法，放弃CPU的执行，进入到waiting无线等待状态
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子已经做好了，顾客1开吃！");
                        System.out.println("=====================");
                    }
                }
            }
        }.start();

        //创建一个顾客线程
        new Thread(){
            @Override
            public void run() {
                //保证等待和唤醒的线程只能有一个执行
                //需要使用同步技术
                while (true){
                    synchronized (obj){
                        System.out.println("顾客2告知老板要的包子种类和数量");
                        //调用wait方法，放弃CPU的执行，进入到waiting无线等待状态
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子已经做好了，顾客2开吃！");
                        System.out.println("=====================");
                    }
                }
            }
        }.start();
        //创建一个老板线程
        new Thread(){
            @Override
            public void run() {
                while (true){
                    //花了5秒做包子
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (obj){
                        System.out.println("老板5秒钟之后做好了包子，告知顾客可以吃包子了");
                        //做好了以后，调用notify方法，唤醒顾客吃包子
                        //obj.notify();
                        obj.notifyAll();
                    }
                }
            }
        }.start();
    }
}

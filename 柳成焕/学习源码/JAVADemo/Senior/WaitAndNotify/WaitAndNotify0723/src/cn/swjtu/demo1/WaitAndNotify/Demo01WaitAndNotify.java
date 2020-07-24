package cn.swjtu.demo1.WaitAndNotify;
/*
等待唤醒案例：线程之间的通信
1、创建一个顾客线程（消费者）：告知老板要的包子种类和数量，调用wait方法，放弃CPU的执行，进入到waiting无线等待状态。
2、创建一个老板线程（生产者）：花了5秒做包子，做好了以后，调用notify方法，唤醒顾客吃包子。
注意：
1、顾客和老板线程必须得使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行。
2、同步使用的锁对象必须保证是唯一的。
3、只有锁对象才能调用wait和notify方法。
Object类中的方法：
void wait() 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待
void notify() 唤醒在此对象监视器上等待的单个线程。 会继续执行wait方法之后的代码。
 */
public class Demo01WaitAndNotify {
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
                       System.out.println("告知老板要的包子种类和数量");
                       //调用wait方法，放弃CPU的执行，进入到waiting无线等待状态
                       try {
                           obj.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       //唤醒之后执行的代码
                       System.out.println("包子已经做好了，开吃！");
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
                        obj.notify();
                    }
                }
            }
        }.start();
    }
}

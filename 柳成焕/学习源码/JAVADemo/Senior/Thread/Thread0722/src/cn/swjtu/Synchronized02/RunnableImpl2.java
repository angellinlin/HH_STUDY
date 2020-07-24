package cn.swjtu.Synchronized02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl2 implements Runnable {
    //定义一个票源
    private static int ticket = 100;

    //1、在成员位置上创建一个ReentrantLock对象；
    Lock l = new ReentrantLock();

    //重写run方法，设置线程任务，卖票
    @Override
    public void run() {
        while (true) {
            //2、在可能会出现安全问题的代码前调用Lock接口中的方法lock获取锁。
            l.lock();
            if (ticket > 0) {
                //设置睡眠，增加线程安全问题出现
                try {
                    Thread.sleep(10);
                    //开始卖票
                    System.out.println(Thread.currentThread().getName() + " " + "正在卖第" + ticket + "张票");
                    ticket--;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //3、在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁。
                    l.unlock();
                }


            }
        }

    }


    //定义一个静态同步方法
    /*
    静态方法的锁对象是class属性-->class文件对象（反射）
     */
    /*   public static *//* synchronized*//* void sellTicketStatic() {
        synchronized (cn.swjtu.Synchronized.RunnableImpl1.class){
            if (ticket > 0) {
                //设置睡眠，增加线程安全问题出现
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //开始卖票
                System.out.println(Thread.currentThread().getName() + " " + "正在卖第" + ticket + "张票");
                ticket--;
            }
        }

    }*/



    /*//定义一个同步方法
    public *//*synchronized*//* void sellTicket() {
        synchronized (this){
            if (ticket > 0) {
                //设置睡眠，增加线程安全问题出现
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //开始卖票
                System.out.println(Thread.currentThread().getName() + " " + "正在卖第" + ticket + "张票");
                ticket--;
            }

        }

    }*/
}


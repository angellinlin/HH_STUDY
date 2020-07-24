package cn.swjtu.Demo02.WaitAndNotify;
/*
3、消费者（吃货）类：是一个线程类，可继承Thread
	设置线程任务run：吃包子
	对包子状态进行判断：
true有包子，吃货吃包子修改包子的状态为false，唤醒生产者线程生产包子
false吃货调用wait方法进入等待状态

 */
public class ChiHuo extends Thread{
    private BaoZi baozi;  //疑问？这两个类中的包子是同一个吗？？？
    //懂了，这里只是创建对象作为锁对象，其实真正创建的有内容的对象是在主程序中，
    // 调用对应的构造方法将有内容包子baozi对象传递进来作为锁对象

    public ChiHuo(BaoZi baozi){
        this.baozi=baozi;
    }

    //设置线程任务run：吃包子
    @Override
    public void run() {
        while (true){//使用死循环让吃货一直吃包子
            synchronized (baozi){
                if(baozi.isState()==false){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //线程被唤醒之后执行的代码
                //吃货吃包子修改包子的状态为false，唤醒生产者线程生产包子
                System.out.println("吃货正在吃："+baozi.getPi()+"皮"+baozi.getXian()+"馅的包子");
                baozi.setState(false);
                baozi.notify();
                System.out.println("吃货已经把："+baozi.getPi()+"皮"+baozi.getXian()+"馅的包子吃完了，包子铺开始生产包子");
                System.out.println("=======================");
            }

        }

    }
}

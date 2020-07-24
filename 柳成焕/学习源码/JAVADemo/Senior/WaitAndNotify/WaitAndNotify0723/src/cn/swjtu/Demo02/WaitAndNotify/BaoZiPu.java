package cn.swjtu.Demo02.WaitAndNotify;

/*
2、生产者类：包子铺，是一个线程类，继承Thread
	设置线程任务(run)：生产包子
	对包子的状态进行判断：
		true:有包子，调用wait方法进入等待状态
		false:没有包子，包子铺生产包子。
			增加趣味性：交替生产两种包子i%2
	包子铺生产好包子，将包子的状态设置为true，唤醒吃货线程，让吃货线程吃包子

注意：包子铺线程与包子线程的关系-->通信（互斥）
      必须同时使用同步技术保证两个线程只能有一个在执行
      锁对象必须保证唯一，可以使用包子对象作为锁对象
      包子铺类和吃货类把包子对象作为参数传递进来
        1、在成员位置创建一个包子变量
        2、使用带参构造方法为包子赋值
 */
public class BaoZiPu extends Thread {

    // 1、在成员位置创建一个包子变量
    private BaoZi baozi;

    // 2、使用带参构造方法为包子赋值
    public BaoZiPu(BaoZi baozi) {
        this.baozi = baozi;
    }


    @Override
    public void run() {
        //定义一个变量，用于判断生产哪种包子
        int count=0;

        synchronized (baozi) {
           while (true){
               if (baozi.isState() == true) {//true:有包子，调用wait方法进入等待状态
                   try {
                       baozi.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               //被唤醒之后，包子铺生产包子
               //生产两种包子
               if(count%2==0){
                   //生产薄皮牛肉包子
                   baozi.setPi("薄皮");
                   baozi.setXian("牛肉");
               }else{//生产冰皮三鲜馅包子
                   baozi.setPi("冰皮");
                   baozi.setXian("三鲜");
               }
               count++;
               System.out.println("包子铺正在生产："+baozi.getPi()+"皮"+baozi.getXian()+"馅的包子");
               //生产包子需要3秒
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               //包子铺生产好包子，将包子的状态设置为true，唤醒吃货线程，让吃货线程吃包子
               baozi.setState(true);
               baozi.notify();
               System.out.println("包子铺已经生产好了"+baozi.getPi()+"皮"+baozi.getXian()+"馅的包子，吃货可以开始吃了！");
           }
        }
    }
}


package cn.swjtu.ThreadSynchronized.ThreadSafe;

public class RunnableImpl implements Runnable {
    //定义一个多线程共享的票源
    private int ticket = 100;
    //创建一个锁对象
    Object obj = new Object();
        //设置线程任务，卖票
        @Override
        public void run(){
        //使用死循环，让卖票重复循环
        while (true) {
            //提高安全问题出现的概率
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj){
                //先判断票是否存在
                if (ticket > 0) {
                    //票存在，卖票 ticket--;
                    System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
                    ticket--;
                }
            }

        }

    }



}

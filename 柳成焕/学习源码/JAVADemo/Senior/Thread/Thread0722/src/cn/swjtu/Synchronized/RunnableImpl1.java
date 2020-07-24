package cn.swjtu.Synchronized;

public class RunnableImpl1 implements Runnable {
    //定义一个票源
    private static int ticket = 100;

    //重写run方法，设置线程任务，卖票
    @Override
    public void run() {
        while (true){
            sellTicketStatic();
        }

    }

    //定义一个静态同步方法
    /*
    静态方法的锁对象是class属性-->class文件对象（反射）
     */
    public static /* synchronized*/ void sellTicketStatic() {
        synchronized (RunnableImpl1.class){
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

    }



    //定义一个同步方法
    public /*synchronized*/ void sellTicket() {
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

    }
}

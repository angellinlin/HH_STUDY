package cn.swjtu.ThreadSafe;

/*
    模拟卖票机制
    创建3个窗口（线程），对共享的票进行出售

卖票案例出现了线程安全问题，卖出了不存在的票和重复的票。
解决线程安全的一种方案：使用同步代码块。
格式：synchronized(锁对象){
    可能会出现线程安全的代码（访问了共享数据的代码）
}
注意：
1、同步代码块的锁对象，可以使用任意的对象。
2、但是必须保证多个线程使用的锁对象是同一个。
3、锁对象的作用：
    把同步代码块锁住，只让一个线程在同步代码块中执行。
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        //创建实现类对象
        RunnableImpl run = new RunnableImpl();
        System.out.println("run:"+run);
        //创建Thread类对象，构造方法的参数使用实现类对象
        Thread th0 = new Thread(run);
        Thread th1 = new Thread(run);
        Thread th2 = new Thread(run);
        //开启多线程
        th0.start();
        th1.start();
        th2.start();
    }
}

package cn.swjtu.demo03.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
线程池：JDK1.5之后提供的。
java.util.concurrent.Executors：线程池的工厂类，用来生产线程池
Executors中的静态方法：
    static ExecutorService newFixedThreadPool(int nThreads) 创建一个可重用固定线程数的线程池
        参数：创建的线程池中包含的数量
        返回值：ExecutorService接口，返回的是ExecutorService接口的实现类对象，我们可以用ExecutorService接口接收（面向接口编程）
java.util.concurrent.ExecutorService：线程池接口
    用来从线程池中获取线程，调用start方法，执行线程任务。
    submit(Runnable task) 提交一个 Runnable 任务用于执行
     void shutdown() 关闭/销毁线程池的方法
线程池的使用步骤：
    1、使用线程工厂类Executors的静态newFixedThreadPool方法创建一个指定线程数量的线程池；
    2、创建一个类，实现Runnable接口与，重写run方法，设置线程任务；
    3、调用ExecutorService中的submit方法，传递线程任务（实现类），开启线程，执行run方法；
    4、调用调用ExecutorService中shutdown方法销毁线程池（不建议执行）。
注意：线程池会一直开启。使用完了线程，会自动把线程归还给线程池，线程可以继续拿出来使用

 */
public class Demo01ThreadPool {
    public static void main(String[] args) {
        //1、使用线程工厂类Executors的静态newFixedThreadPool方法创建一个指定线程数量的线程池；
        ExecutorService es = Executors.newFixedThreadPool(2);

        //3、调用ExecutorService中的submit方法，传递线程任务（实现类），开启线程，执行run方法；
        es.submit(new RunnableImpl());//pool-1-thread-2创建了一个新的线程
        es.submit(new RunnableImpl());//pool-1-thread-2创建了一个新的线程
        es.submit(new RunnableImpl());//pool-1-thread-1创建了一个新的线程

        es.shutdown();  //销毁线程
        //es.submit(new RunnableImpl()); //没有了线程池，再创建线程就会抛出异常
    }
}

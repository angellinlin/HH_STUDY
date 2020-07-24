package cn.swjtu.demo04.Lambda;
//重写run方法，设置线程任务
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

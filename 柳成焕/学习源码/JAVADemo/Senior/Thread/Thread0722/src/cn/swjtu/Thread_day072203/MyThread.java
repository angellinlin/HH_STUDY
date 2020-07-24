package cn.swjtu.Thread_day072203;

/*
获取线程的名称：
1、使用Thread类的方法String getName()
2、可以先获取到当前正在执行的线程，使用县城中的getName()再获取线程的名称。
static Thread currentThread() 返回对当前正在执行的线程对象的引用。

 */
//创建Thread的子类
public class MyThread extends Thread {
    //重写run方法，设置线程任务
    @Override
    public void run() {
        /*//获取线程名称1
        String name=getName();
        System.out.println(name);*/

        //获取线程名称2
        //首先获取线程
       /* Thread mt = currentThread();
        String name = mt.getName();
        System.out.println(name);*/

        //链式编程
        System.out.println(Thread.currentThread().getName());
    }
}

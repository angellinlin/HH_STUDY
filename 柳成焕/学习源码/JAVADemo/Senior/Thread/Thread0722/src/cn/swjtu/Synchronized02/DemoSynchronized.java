package cn.swjtu.Synchronized02;
/*
解决线程安全问题的第三种方案：使用Lock锁
java.util.concurrent.locks.Lock接口
Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作.
Lock接口中的方法：
    void lock()获取锁
    void unlock()释放锁
java.util.concurrent.locks.ReentrantLock implements Lock接口
使用步骤：
1、在成员位置上创建一个ReentrantLock对象；
2、在可能会出现安全问题的代码前调用Lock接口中的方法lock获取锁。
3、在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁。
 */
public class DemoSynchronized {
    public static void main(String[] args) {
        //定义一个实现类对象
        RunnableImpl2 run = new RunnableImpl2();
        Thread th0=new Thread(run);
        Thread th1=new Thread(run);
        Thread th2=new Thread(run);

        //启动线程
        th0.start();
        th1.start();
        th2.start();
    }


}

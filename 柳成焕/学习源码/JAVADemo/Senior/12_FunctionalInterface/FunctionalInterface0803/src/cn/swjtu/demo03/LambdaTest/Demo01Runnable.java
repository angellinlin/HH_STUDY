package cn.swjtu.demo03.LambdaTest;
/*
java.lang.Runnable接口就是一个函数式接口，假设有一个startThread方法作为参数，那么就可以使用Lambda进行传参、
这种抢矿其实和Thread类的构造方法参数为Runnable没有本质区别。
 */
public class Demo01Runnable {
    //定义一个方法，参数使用函数式接口Runnale
    public static void startThread(Runnable r){
        //开启多线程
        new Thread(r).start();
    }
    public static void main(String[] args) {
        //调用startThread方法，方法参数是一个接口，那我们可以传递这个接口的匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"-->线程启动了");
            }
        });

        //调用startThread方法，方法参数是一个接口，那我们可以传递Lambda表达式
        startThread(()->{
            System.out.println(Thread.currentThread().getName()+"-->线程启动了");
        });

        //优化Lambda
        startThread(()-> System.out.println(Thread.currentThread().getName()+"-->线程启动了"));
    }
}

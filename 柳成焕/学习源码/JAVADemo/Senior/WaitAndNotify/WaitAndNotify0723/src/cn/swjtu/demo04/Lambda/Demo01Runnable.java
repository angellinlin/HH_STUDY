package cn.swjtu.demo04.Lambda;
/*
实现Runnable接口的方式实现多线程程序
 */
public class Demo01Runnable {
    public static void main(String[] args) {
        RunnableImpl run=new RunnableImpl();
        Thread th=new Thread(run);
        th.start();

        //简化代码，使用匿名内部类实现
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}

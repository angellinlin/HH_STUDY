package cn.swjtu.SetThreadName;

public class Demo01SetThreadName {
    public static void main(String[] args) {
        //开启多线程
        MyThread mt=new MyThread();
        mt.setName("小花");
        mt.start();

        MyThread mt2=new MyThread("小李");
        mt2.start();
    }
}
